package com.nitryx.backend.mapper


import com.nitryx.backend.entity.TransacaoContaBancariaQuery
import org.springframework.jdbc.core.RowMapper

import java.sql.ResultSet
import java.sql.SQLException

class TransacaoContaBancariaMapper implements RowMapper<TransacaoContaBancariaQuery>{
    public TransacaoContaBancariaQuery mapRow(ResultSet resultSet, int i) throws SQLException {

        TransacaoContaBancariaQuery conta = new TransacaoContaBancariaQuery();
//        conta.setId(resultSet.getLong("id"));
        conta.setDataHora(resultSet.getString("datahora"));
//        conta.setValor(resultSet.getFloat("valor"));
//        conta.setSaldoAnterior(resultSet.getFloat("saldo"));


        return conta;
    }
}
