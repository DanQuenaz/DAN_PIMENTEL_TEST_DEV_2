package com.nitryx.backend.entity

class ContaBancariaQuery implements  Serializable{

    private Long id;
    private String nome;
    private Integer numeroAgencia;
    private Integer numeroConta;
    private Float saldo;

    ContaBancariaQuery() {
    }

    ContaBancariaQuery(Long id, String nome, Integer numeroAgencia, Integer numeroConta, Float saldo) {
        this.id = id
        this.nome = nome
        this.numeroAgencia = numeroAgencia
        this.numeroConta = numeroConta
        this.saldo = saldo
    }


    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    Integer getNumeroAgencia() {
        return numeroAgencia
    }

    void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia
    }

    Integer getNumeroConta() {
        return numeroConta
    }

    void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta
    }

    Float getSaldo() {
        return saldo
    }

    void setSaldo(Float saldo) {
        this.saldo = saldo
    }
}




