package com.dio.banco.model.cliente;

import java.util.ArrayList;

import com.dio.banco.model.conta.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Cliente{
    protected String nome;
    protected ArrayList<Conta> contas;
   
    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    /**
     * Imprime todas as clientes no terminal
     */
    public void imprimirContas(){
        for(Conta c: contas){
            System.out.println(c);
        }
    }
    
}