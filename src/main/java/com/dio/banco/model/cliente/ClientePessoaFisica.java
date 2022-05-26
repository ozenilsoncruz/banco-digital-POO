package com.dio.banco.model.cliente;

import lombok.Getter;

public class ClientePessoaFisica extends Cliente {
    @Getter
    private int cpf;

    public ClientePessoaFisica(String nome, int cpf) {
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome:" + nome  + "\n"+
               "CPF: " + cpf;
               
    }
    
}
