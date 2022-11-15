package com.nitryx.backend.http.controller

import com.nitryx.backend.entity.ContaBancariaQuery
import com.nitryx.backend.service.ContaBancariaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contas")
class ContaBancariaController {
    @Autowired
    ContaBancariaService contaBancariaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContaBancariaQuery> getContas(){
        return contaBancariaService.todasContasBancarias();
    }
}
