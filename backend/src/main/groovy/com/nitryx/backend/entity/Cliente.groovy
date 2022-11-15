package com.nitryx.backend.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome){
        this.cpf = cpf
        this.nome = nome

    }

    public Long getId(){
        return this.id;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return  this.cpf;
    }

    public void setNome(String nome){
        this.nome = nome
    }


}
