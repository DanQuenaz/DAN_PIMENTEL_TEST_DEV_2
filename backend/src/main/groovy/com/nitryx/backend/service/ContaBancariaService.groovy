package com.nitryx.backend.service

import com.nitryx.backend.entity.ContaBancaria
import com.nitryx.backend.entity.ContaBancariaQuery
import com.nitryx.backend.entity.TransacaoContaBancariaQuery
import com.nitryx.backend.entity.Transacao
import com.nitryx.backend.mapper.ContaBancariaMapper
import com.nitryx.backend.mapper.TransacaoContaBancariaMapper
import com.nitryx.backend.repository.ContaBancariaRespository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

import java.text.MessageFormat

@Service
class ContaBancariaService {
    @Autowired
    ContaBancariaRespository contaBancariaRespository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TransacaoService transacaoService;


    final Logger logger = LoggerFactory.getLogger(ContaBancariaService.class);

    public List<ContaBancariaQuery> todasContasBancarias(){
        String query =  "SELECT CONTA_BANCARIA.ID, NOME, NUMERO_AGENCIA, NUMERO_CONTA, SALDO " +
                        "FROM CONTA_BANCARIA " +
                        "INNER JOIN CLIENTE " +
                            "ON CONTA_BANCARIA.CLIENTE_ID  = CLIENTE.ID "
        return jdbcTemplate.query(query, new ContaBancariaMapper());
    }

    public List<TransacaoContaBancariaQuery> transacoesContaBancaria(Long id){
        //Essa query funciona no banco H2 do navegador, mas não funciona aqui, não consegui descobrir porque :(
//        String query = "SELECT CONTA_BANCARIA.ID, DATAHORA, VALOR, SALDO " +
//                "FROM CONTA_BANCARIA INNER JOIN CONTA_BANCARIA_TRANSACOES ON CONTA_BANCARIA.ID = CONTA_BANCARIA_TRANSACOES.CONTA_BANCARIA_ID " +
//                "INNER JOIN TRANSACAO ON TRANSACAO.ID = CONTA_BANCARIA_TRANSACOES.TRANSACOES " +
//                "WHERE CONTA_BANCARIA.ID = ?";
        String query =  new StringBuilder("SELECT ID, DATAHORA, VALOR FROM  TRANSACAO")
        System.out.println(query)
        return jdbcTemplate.query(query, new TransacaoContaBancariaMapper());
    }

    public ContaBancaria salvar(ContaBancaria contaBancaria){

        return contaBancariaRespository.save(contaBancaria);
    }

    public ContaBancaria criarConta(ContaBancaria contaBancaria){
        if(this.salvar(contaBancaria)){
            logger.info(MessageFormat.format("Criada conta {0}",  contaBancaria.getNumeroConta()));
        }
    }

    public Optional<ContaBancaria> buscarContaId(Long id){
        return contaBancariaRespository.findById(id);
    }

    public ContaBancaria debitar(Long id, float valor){
        ContaBancaria conta = this.buscarContaId(id).get();

        float resultado = conta.debitar(valor);

        if(resultado>-1){
            Transacao transacao = transacaoService.salvar(new Transacao((Float)(-1*valor)));
            conta.addTransacao(transacao.getId());
            this.salvar(conta);
            logger.info(MessageFormat.format("Debitado {0} da conta {1}", valor, conta.getNumeroConta()));
        }else{
            logger.info(MessageFormat.format("Falha ao debitar {0} da conta {1}", valor, conta.getNumeroConta()));
        }

    }

    public ContaBancaria creditar(Long id, float valor){
        ContaBancaria conta = this.buscarContaId(id).get();

        conta.creditar(valor);

        Transacao transacao = transacaoService.salvar(new Transacao(valor));
        conta.addTransacao(transacao.getId());

        this.salvar(conta);
        logger.info(MessageFormat.format("Creditado {0} na conta {1}", valor, conta.getNumeroConta()));
    }

    public ContaBancaria transferir(Long id1, Long id2, float valor){
        ContaBancaria conta1 = this.buscarContaId(id1).get();
        ContaBancaria conta2 = this.buscarContaId(id2).get();

        float resultado = conta1.transferir(conta2, valor);

        if(resultado>-1){
            Transacao transacao1 = transacaoService.salvar(new Transacao((Float)(-1*valor)));
            Transacao transacao2 = transacaoService.salvar(new Transacao((Float)(valor)));

            conta1.addTransacao(transacao1.getId());
            conta2.addTransacao(transacao2.getId());

            this.salvar(conta1);
            this.salvar(conta2);
            logger.info(MessageFormat.format("Tranferido {0} da conta {1} para conta {2}", valor, conta1.getNumeroConta(), conta2.getNumeroConta()));
        }else {
            logger.info(MessageFormat.format("Falha na tranferência de {0} da conta {1} para conta {2}", valor, conta1.getNumeroConta(), conta2.getNumeroConta()));
        }

    }
}
