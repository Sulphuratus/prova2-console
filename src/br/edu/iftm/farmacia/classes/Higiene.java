package br.edu.iftm.farmacia.classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Higiene extends Produto{

    private int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
    private int mesAtual = Calendar.getInstance().get(Calendar.MONTH);
    private int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private int periodoVencimento;

    /*public Higiene (String nome, int codigoNumerico, int diaVencimento, int mesVencimento,
    int anoVencimento, double preco, double precoAtual){
        super(nome, codigoNumerico, diaVencimento, mesVencimento, anoVencimento, preco, precoAtual);
    
    }*/

    public int calcularVencimento (){
        LocalDate dataAtual = LocalDate.of(anoAtual, mesAtual, diaAtual);
        LocalDate dataVencimento = LocalDate.of(super.getAnoVencimento(), super.getMesVencimento(), 
        super.getDiaVencimento());

        Period periodo =  Period.between(dataAtual, dataVencimento);

        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anos = periodo.getYears();

        return (dias + meses*30 + anos*365);
    }

    public double calcularPreco(){
        periodoVencimento = calcularVencimento ();

        if(periodoVencimento >180 ){
            super.setPrecoAtual(super.getPreco());

        }else if(periodoVencimento >= 60 && periodoVencimento <= 180){
            super.setPrecoAtual(super.getPreco()*0.8);

        }else if(periodoVencimento > 0 && periodoVencimento <= 60){
            super.setPrecoAtual(super.getPreco()*0.7);
            
        }else if (periodoVencimento <= 0){
            JOptionPane.showMessageDialog(null, "Produto vencido, comecialização proibida", "Atenção!", JOptionPane.ERROR_MESSAGE);
            super.setPrecoAtual(super.getPreco()*0);
            
        }return super.precoAtual;

    }

}
