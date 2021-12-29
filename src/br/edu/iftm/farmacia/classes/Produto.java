package br.edu.iftm.farmacia.classes;



public abstract class Produto {

    protected String nome;
    protected int codigoNumerico;
    protected int diaVencimento, mesVencimento, anoVencimento; 
    protected double preco, precoAtual;
    
    public Produto (String nome, int codigoNumerico, int diaVencimento, int mesVencimento,
    int anoVencimento, double preco, double precoAtual){

        this.nome = nome;
        this.codigoNumerico = codigoNumerico;
        this.diaVencimento = diaVencimento;
        this.mesVencimento = mesVencimento;
        this.anoVencimento = anoVencimento;
        this.preco = preco;
        this.precoAtual = precoAtual;
    }

    public Produto(){

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoNumerico() {
        return this.codigoNumerico;
    }

    public void setCodigoNumerico(int codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public int getDiaVencimento() {
        return this.diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public int getMesVencimento() {
        return this.mesVencimento;
    }

    public void setMesVencimento(int mesVencimento) {
        this.mesVencimento = mesVencimento;
    }

    public int getAnoVencimento() {
        return this.anoVencimento;
    }

    public void setAnoVencimento(int anoVencimento) {
        this.anoVencimento = anoVencimento;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoAtual() {
        return this.precoAtual;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }

    public abstract int calcularVencimento();

    public abstract double calcularPreco();



    
}
