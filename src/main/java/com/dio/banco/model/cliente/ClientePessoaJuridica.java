package com.dio.banco.model.cliente;

import lombok.Getter;

public class ClientePessoaJuridica extends Cliente {
    @Getter
    private int cnpj;

    public ClientePessoaJuridica(String nome, int cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Nome:" + nome  + "\n"+
               "CNPJ: " + cnpj;
               
    }
    
}
