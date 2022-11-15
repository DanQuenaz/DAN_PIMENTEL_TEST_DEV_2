package com.nitryx.backend.mapper

import com.nitryx.backend.entity.ContaBancaria
import com.nitryx.backend.entity.ContaBancariaQuery
import org.springframework.jdbc.core.RowMapper

import java.sql.ResultSet
import java.sql.SQLException


class ContaBancariaMapper implements RowMapper<ContaBancariaQuery>{
    public ContaBancariaQuery mapRow(ResultSet resultSet, int i) throws SQLException {

        ContaBancariaQuery conta = new ContaBancariaQuery();
        conta.setId(resultSet.getLong("id"));
        conta.setNome(resultSet.getString("nome"));
        conta.setNumeroAgencia(resultSet.getInt("numero_agencia"));
        conta.setNumeroConta(resultSet.getInt("numero_conta"));
        conta.setSaldo(resultSet.getFloat("saldo"));


        return conta;
    }
}
