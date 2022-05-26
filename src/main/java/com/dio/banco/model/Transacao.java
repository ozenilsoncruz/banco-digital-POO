package com.dio.banco.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.dio.banco.model.conta.Conta;

public class Transacao {
    private String tipo;
    private double valor;
    private Conta contaOrigem;
    private Conta contaDestido;
    private String dataHora;

    public Transacao (Conta cOrigem, double valor, String tipo){
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = cOrigem;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Transacao (Conta cOrigem, Conta cDestino, double valor, String tipo){
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = cOrigem;
        this.contaDestido = cDestino;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor(){
        return valor;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestido() {
        return contaDestido;
    }

    public String getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        String retorno = "======= Dados da Transacao =======" + "\n"+
                         "   Origem: " + contaOrigem.getAgencia() + " " + contaOrigem.getNumero() + "\n"+
                         "   Acao: "+ tipo + "\n"+
                         "   Valor: "+ valor + "\n"+
                         "   Data/Hora: " + dataHora;
        if(contaDestido != null) 
            retorno += "\n" + "   Destino: "+ contaDestido.getAgencia() + " " + contaDestido.getNumero();
        return retorno;
    }

    
}
