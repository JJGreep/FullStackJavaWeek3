package com.example.Week3.Models;


public class Account {

    private long id;
    private String iban;
    private double saldo;
    private String[] names;

    public Account(){}

    public Account(long id, String iban, double saldo, String[] names) {
        super();
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
        this.names = names;
    }


    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban){
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
