package com.nitryx.backend.http.controller

import com.nitryx.backend.entity.ContaBancariaQuery
import com.nitryx.backend.entity.TransacaoContaBancariaQuery
import com.nitryx.backend.service.ContaBancariaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/contas/{id}/transacoes")
class TransacoesController {
    @Autowired
    ContaBancariaService contaBancariaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoContaBancariaQuery> getContas(@PathVariable("id") String id){
        return contaBancariaService.transacoesContaBancaria((Long)id);
    }
}
