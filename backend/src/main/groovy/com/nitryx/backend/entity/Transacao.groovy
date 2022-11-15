package com.nitryx.backend.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.text.DateFormat
import java.text.SimpleDateFormat


@Entity
class Transacao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String datahora;
    private float valor;

    Transacao( float valor) {
        this.valor = valor

        DateFormat df = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        this.datahora = df.format(today);
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getContaBancariaId() {
        return contaBancariaId
    }

    void setContaBancariaId(Long contaBancariaId) {
        this.contaBancariaId = contaBancariaId
    }

    String getDatahora() {
        return datahora
    }

    void setDatahora(String datahora) {
        this.datahora = datahora
    }

    float getValor() {
        return valor
    }

    void setValor(float valor) {
        this.valor = valor
    }
}
