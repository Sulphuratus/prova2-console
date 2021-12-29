package br.edu.iftm.farmacia.classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Medicamento extends Produto{

    private int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
    private int mesAtual = Calendar.getInstance().get(Calendar.MONTH);
    private int diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private boolean generico;
    private int periodoVencimento;

    /*public Medicamento (String nome, int codigoNumerico, int diaVencimento, int mesVencimento,
    int anoVencimento, double preco, double precoAtual){
        super(nome, codigoNumerico, diaVencimento, mesVencimento, anoVencimento, preco, precoAtual);
    }*/

    public Medicamento (){
        super();
    }

    public int calcularVencimento (){
        int dias, meses, anos;
        LocalDate dataAtual = LocalDate.of(anoAtual, mesAtual, diaAtual);
        LocalDate dataVencimento = LocalDate.of(super.getAnoVencimento(), super.getMesVencimento(), 
        super.getDiaVencimento());

        Period periodo =  Period.between(dataAtual, dataVencimento);

        dias = periodo.getDays();
        meses = periodo.getMonths();
        anos = periodo.getYears();

        return (dias + meses*30 + anos*365);

    }

    public boolean definirGenerico(){
        String msg = "";
        msg = msg+"\nTipo de medicamento:";
        msg = msg+"\nGenérico: digite 'true'";
        msg = msg+"\nNão Genérico: digite 'false'";
        String gen = JOptionPane.showInputDialog(null, msg, "Medicamento", JOptionPane.QUESTION_MESSAGE);
        generico = Boolean.parseBoolean(gen);
        return generico;
    }

    public double calcularPreco(){
        definirGenerico();
        periodoVencimento = calcularVencimento ();

        if( periodoVencimento >=180 && generico ){
            System.out.println(generico);
            super.setPrecoAtual(super.getPreco()*0.9);

        }else if(periodoVencimento > 0 && periodoVencimento < 180 && generico){
            super.setPrecoAtual(super.getPreco()*0.8);
            System.out.println(generico);
            //return super.precoAtual;

        }else if(periodoVencimento >= 180 && !generico){
            super.setPrecoAtual(super.getPreco()*1.3);
            System.out.println(generico);
            //return super.precoAtual;

        }else if(periodoVencimento > 0 && periodoVencimento < 180 && !generico){
            super.setPrecoAtual(super.getPreco()*1.1);
            System.out.println(generico);

        }else if (periodoVencimento <= 0 ){
            JOptionPane.showMessageDialog(null, "Produto vencido, comecialização proibida", "Atenção!", JOptionPane.ERROR_MESSAGE);
            super.setPrecoAtual(super.getPreco()*0);
            System.out.println(generico);

        }return super.precoAtual;

    }
    
}
