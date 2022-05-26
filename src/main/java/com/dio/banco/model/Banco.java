package com.dio.banco.model;

import java.util.ArrayList;

import com.dio.banco.model.conta.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Banco {
    @Setter
    private String nome;
    private int cnpj;
    private ArrayList<Conta> contas;

    public Banco (String nome, int cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = new ArrayList<>();
    }

    /**
     * Remove uma Conta da lista de contas do banco
     * @param c Conta - Conta a ser deletada
     */
    public void deletarConta(Conta c){
        this.contas.remove(c);
    }

    /**
     * Imprime todas as contas no terminal
     */
    public void imprimircontas(){
        System.out.println("Todas as contas");
        for(Conta c: contas){
            System.out.println(c);
        }
    }
}
