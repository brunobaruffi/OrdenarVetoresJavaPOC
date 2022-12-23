package org.exemple.testelista.service.impl;

import org.exemple.testelista.service.ProcessarService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProcessarServiceImpl implements ProcessarService {

    int[] listRandom;
    int[] listsort;
    int[] listquick;
    int[] listbubble;

    int qtd;
public ProcessarServiceImpl(){
    qtd = 10000;
    System.out.println("dddddd");
    listRandom = new int[qtd];
    listsort = new int[qtd];
    listquick = new int[qtd];
    listbubble = new int[qtd];
}
    public void process(){
        criarLista();
        listsort = listRandom;
        listquick = listRandom;
        listbubble = listRandom;


       //sort tradicional do java
        long tempoInicial = System.currentTimeMillis();
        Arrays.sort(listsort);
        long tempofinal = System.currentTimeMillis();

        System.out.println("Sort:" + (tempofinal-tempoInicial));
        System.out.println("Tempo inicial: " + tempoInicial + " Tempo final: "+ tempofinal);

        //quicksort manual
        tempoInicial = System.currentTimeMillis();
        quickSort(listquick,0,listquick.length-1);
        tempofinal = System.currentTimeMillis();
        System.out.println("quick:" + (tempofinal-tempoInicial));
        System.out.println("Tempo inicial: " + tempoInicial + " Tempo final: "+ tempofinal);
        //bubblesort
        tempoInicial = System.currentTimeMillis();
        listbubble = bubbleSort(listbubble);
        tempofinal = System.currentTimeMillis();
        System.out.println("bubble:" + (tempofinal-tempoInicial));
        System.out.println("Tempo inicial: " + tempoInicial + " Tempo final: "+ tempofinal);
    }

    public static void printVet(int[] vetor){
        for (int c=0;c<vetor.length-1;c++){
            System.out.println(vetor[c]);
        }
    }
    private void criarLista(){
        Random gerador = new Random();
        limparVetor();

        for (int i = 0; i < qtd; i++) {
            listRandom[i] =gerador.nextInt(2000000);
        }
    }
    private void limparVetor(){
        for(int c=0;c<listRandom.length-1;c++){
            listRandom[c]=0;
        }
    }

    private static int[] bubbleSort(int vetor[]){
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
        return vetor;
    }

    private void quickSort(int[] vetor, int inicio, int fim) {
        if(fim > inicio) {
            //Chamada da rotina que ira dividir o vetor em 3 partes.
            int indexPivo = dividir(vetor, inicio, fim);
      /* Chamada recursiva para redivisao do vetor de elementos menores
        que o pivô. */
            quickSort(vetor, inicio, indexPivo - 1);
      /* Chamada recursiva para redivisao do vetor de elementos maiores
        que o pivô. */
            quickSort(vetor, indexPivo + 1, fim);
        }
    }
    private int dividir(int[] vetor, int inicio, int fim) {
        int pivo, pontEsq, pontDir = fim;
        pontEsq = inicio + 1;
        pivo = vetor[inicio];

        while(pontEsq <= pontDir) {
      /* Vai correr o vetor ate que ultrapasse o outro ponteiro
        ou ate que o elemento em questão seja menor que o pivô. */
            while(pontEsq <= pontDir && vetor[pontEsq] <= pivo) {
                pontEsq++;
            }

      /* Vai correr o vetor ate que ultrapasse o outro ponteiro
        que o elemento em questão seja maior que o pivô. */
            while(pontDir >= pontEsq && vetor[pontDir] > pivo) {
                pontDir--;
            }

      /* Caso os ponteiros ainda nao tenham se cruzado, significa que valores
        menores e maiores que o pivô foram localizados em ambos os lados.
        Trocar estes elementos de lado. */
            if(pontEsq < pontDir) {
                trocar(vetor, pontDir, pontEsq);
                pontEsq++;
                pontDir--;
            }
        }

        trocar(vetor, inicio, pontDir);
        return pontDir;
    }
    private void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
