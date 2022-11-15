package com.nitryx.backend.entity

class TransacaoContaBancariaQuery implements Serializable{
    private Long id;
    private String dataHora;
    private Float valor;
    private Float saldoAnterior;

    TransacaoContaBancariaQuery() {
    }

    TransacaoContaBancariaQuery(Long id, String dataHora, Float valor, Float saldoAnterior) {
        this.id = id
        this.dataHora = dataHora
        this.valor = valor
        this.saldoAnterior = saldoAnterior
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getDataHora() {
        return dataHora
    }

    void setDataHora(String dataHora) {
        this.dataHora = dataHora
    }

    Float getValor() {
        return valor
    }

    void setValor(Float valor) {
        this.valor = valor
    }

    Float getSaldoAnterior() {
        return saldoAnterior
    }

    void setSaldoAnterior(Float saldoAnterior) {
        this.saldoAnterior = saldoAnterior
    }
}
