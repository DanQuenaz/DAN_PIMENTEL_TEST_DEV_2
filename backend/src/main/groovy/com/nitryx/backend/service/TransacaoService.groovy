package com.nitryx.backend.service

import com.nitryx.backend.entity.Transacao
import com.nitryx.backend.repository.TransacaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransacaoService {
    @Autowired
    protected TransacaoRepository transacaoRepository;

    public Transacao salvar(Transacao transacao){
        return transacaoRepository.save(transacao);
    }
}
