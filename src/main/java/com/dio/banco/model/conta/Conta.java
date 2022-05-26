package com.dio.banco.model.conta;

import java.util.ArrayList;

import com.dio.banco.model.Transacao;

import lombok.Getter;

@Getter
public abstract class Conta {
    protected int agencia;
    protected double saldo;
    protected int numero;
    protected ArrayList<Transacao> transacaos;
    protected int idCliente; //cpf ou cnpj
    protected int cnpjBanco;

    public Conta(){
        this.transacaos = new ArrayList<>();
    }

    /**
     * Realiza saques na conta se possuir saldo suficiente
     * @param valor double - valor a ser sacado
     * @return boolean - true se tiver saldo disponivel
     */
    public boolean sacar(double valor){
        if(this.saldo - valor >= 0){
            this.saldo -= valor;
            this.transacaos.add(new Transacao(this, valor, "Saque"));
            return true;
        }
        return false;
    }

    /**
     * Realiza depositos na conta
     * @param valor double - valor a ser depositado
     */
    public void depositar(double valor){
        this.transacaos.add(new Transacao(this, valor, "Deposito"));
        this.saldo += valor;
    }

    /**
     * Realiza transferencia entre contas
     * @param valor double - valor a ser transferido
     * @param contaDestido Conta - conta a receber valor 
     * @return String - mensagem sobre a transferencia
     */
    public String transferir(double valor, Conta contaDestido){
        if(this.cnpjBanco == contaDestido.getCnpjBanco()){
            if(this.sacar(valor)){
                contaDestido.depositar(valor);
                this.transacaos.add(new Transacao(this, contaDestido, valor, "Transferencia"));
                return "Transação bem sucedida!";
            }
            return "Valor indisponível!";
        }
        return "Bancos diferentes!";
    }

    @Override
    public String toString() {
        return  "======= Dados da Conta =======" + "\n"+
                "   Agencia: " + agencia + "\n"+
                "   Conta: "+ numero + "\n"+
                "   Cliente: " + idCliente + "\n"+
                "   Saldo:" + saldo;
    }
}