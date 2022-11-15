package com.nitryx.backend.entity

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Transient
import java.text.MessageFormat

@Entity
class ContaBancaria implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numeroAgencia;
    private int numeroConta;
    private float saldo;
    private Long clienteId;

    @ElementCollection
    private List<Long> transacoes;

    public ContaBancaria(){}

    public ContaBancaria(int numeroAgencia, int numeroConta, float saldo, Long clienteId){
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.clienteId = clienteId;
        this.transacoes = new ArrayList<Long>();
    }

    public void addTransacao(Long transacaoId){
        this.transacoes.add(transacaoId);
    }

    public int getNumeroConta(){
        return this.numeroConta;
    }

    public float debitar(float valor){
        if(this.saldo >= valor){
            this.saldo -= valor;

            return this.saldo;
        }
        return -1;
    }

    public void creditar(float valor){
        this.saldo += valor;

    }

    public float transferir(ContaBancaria contaBancariaDestino, valor){
        if(this.saldo >= valor){
            this.debitar(valor);
            contaBancariaDestino.creditar(valor);
            return this.saldo;
        }
        return -1;
    }

}
