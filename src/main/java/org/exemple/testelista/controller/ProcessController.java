package org.exemple.testelista.controller;

import lombok.AllArgsConstructor;
import org.exemple.testelista.service.ProcessarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("processar")
@AllArgsConstructor
public class ProcessController {

    private ProcessarService processarService;
    @GetMapping
    public void processarLista(){
        processarService.process();
    }
}
