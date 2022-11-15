package com.nitryx.backend.service

import com.nitryx.backend.entity.Cliente
import com.nitryx.backend.repository.ClienteRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.text.MessageFormat

@Service
class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    public Cliente salvar(Cliente cliente){
        logger.info(MessageFormat.format("Criado cliente {0}", cliente.getNome()));
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listaCliente(){
        return(clienteRepository.findAll());
    }

    public Optional<Cliente> buscarClientePorId(Long id){
        return(clienteRepository.findById(id));
    }

}
