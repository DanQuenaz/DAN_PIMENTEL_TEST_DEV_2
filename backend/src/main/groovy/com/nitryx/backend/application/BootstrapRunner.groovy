package com.nitryx.backend.application

import com.nitryx.backend.entity.Cliente
import com.nitryx.backend.entity.ContaBancaria
import com.nitryx.backend.entity.ContaBancariaQuery
import com.nitryx.backend.entity.TransacaoContaBancariaQuery
import com.nitryx.backend.service.ClienteService
import com.nitryx.backend.service.ContaBancariaService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@CompileStatic
@Component
@Slf4j
class BootstrapRunner implements ApplicationRunner {
    @Autowired
    protected ClienteService clienteService;

    @Autowired
    protected ContaBancariaService contaBancariaService;

    @Transactional
    @Override
    void run(ApplicationArguments args) throws Exception {

        Cliente cliente1 = new Cliente("118.673.276-86", "Dan Pimentel");
        Cliente cliente2 = new Cliente("118.673.276-87", "Dan Magdyan");

        clienteService.salvar(cliente1);
        clienteService.salvar(cliente2);

        ContaBancaria conta1 = new ContaBancaria(100, 234567, 0, cliente1.getId());
        ContaBancaria conta2 = new ContaBancaria(100, 234568, 0, cliente2.getId());

        contaBancariaService.criarConta(conta1);
        contaBancariaService.criarConta(conta2);

        contaBancariaService.creditar(1, 358);
        contaBancariaService.creditar(2, 543);
        contaBancariaService.debitar(1, 51);
        contaBancariaService.transferir(1, 2, 56);

//        List<ContaBancariaQuery> lista = contaBancariaService.todasContasBancarias();
//
//        for(ContaBancariaQuery index : lista){
//            System.out.println(index.getNome());
//        }
//
//        List<ContaBancariaQuery> lista3 = contaBancariaService.todasContasBancarias();
//
//        for(ContaBancariaQuery index : lista3){
//            System.out.println(index.getNome());
//        }
//
//        List<TransacaoContaBancariaQuery> lista2 = contaBancariaService.transacoesContaBancaria(1);
//
//        for(TransacaoContaBancariaQuery index : lista2){
//            System.out.println(index.getDataHora());
//        }





    }
}
