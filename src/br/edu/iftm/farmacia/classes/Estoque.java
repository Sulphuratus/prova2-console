package br.edu.iftm.farmacia.classes;

import java.text.DecimalFormat;

//import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class Estoque {

    static DecimalFormat df = new DecimalFormat("##.###");

    public static int cadastrarProduto(Produto p[], int cod) {
        String temp;
        int tipo;
        String msg = "";        

        do {
            msg = msg + "\nDigite o número do Produto a cadastrar:";
            msg = msg +"\n1 - Medicamento";
            msg = msg + "\n2 - Produto de Higiene:";
            temp = JOptionPane.showInputDialog(null, msg,"Cadastro", JOptionPane.QUESTION_MESSAGE);
            tipo = Integer.parseInt(temp);

        } while (tipo != 1 && tipo != 2);

        if (tipo == 1) {
            Medicamento registra = new Medicamento();

            registra.setCodigoNumerico(cod+1);

            registra.setNome(JOptionPane.showInputDialog(null, "Digite os dados do medicamento: ",
            "Medicamento", JOptionPane.QUESTION_MESSAGE));

            temp = (JOptionPane.showInputDialog(null, "Digite o preço de tabela do medicamento: ",
            "Medicamento", JOptionPane.QUESTION_MESSAGE));
            registra.setPreco(Double.parseDouble(temp));

            temp = JOptionPane.showInputDialog(null, "Digite o dia de vencimento do medicamento: ",
            "Medicamento", JOptionPane.QUESTION_MESSAGE);
            registra.setDiaVencimento(Integer.parseInt(temp));

            temp = JOptionPane.showInputDialog(null, "Digite o mês de vencimento do medicamento: ",
            "Medicamento", JOptionPane.QUESTION_MESSAGE);
            registra.setMesVencimento(Integer.parseInt(temp));

            temp = JOptionPane.showInputDialog(null, "Digite o ano de vencimento do medicamento: ",
            "Medicamento", JOptionPane.QUESTION_MESSAGE);
            registra.setAnoVencimento(Integer.parseInt(temp));

            //registra.calcularVencimento();

            registra.calcularPreco();

            p[cod] = registra;

        } else {
            Higiene registra = new Higiene();

            registra.setCodigoNumerico(cod+1);
            registra.setNome(JOptionPane.showInputDialog(null, "Digite a descrição do produto: ",
            "Higiene", JOptionPane.QUESTION_MESSAGE));

            temp = (JOptionPane.showInputDialog(null, "Digite o preço de tabela do produto: ",
            "Higiene", JOptionPane.QUESTION_MESSAGE));
            registra.setPreco(Double.parseDouble(temp));

            temp = JOptionPane.showInputDialog(null, "Digite o dia de vencimento do produto: ",
            "Higiene", JOptionPane.QUESTION_MESSAGE);
            registra.setDiaVencimento(Integer.parseInt(temp));

            temp = JOptionPane.showInputDialog(null, "Digite o mês de vencimento do produto: ",
            "Higiene", JOptionPane.QUESTION_MESSAGE);
            registra.setMesVencimento(Integer.parseInt(temp));

            temp = JOptionPane.showInputDialog(null, "Digite o ano de vencimento do produto: ",
            "Higiene", JOptionPane.QUESTION_MESSAGE);
            registra.setAnoVencimento(Integer.parseInt(temp));

            //registra.calcularVencimento();

            registra.calcularPreco();

            p[cod] = registra;

        }
        cod++;
        return cod;
    }

    public static void alterarProduto(Produto p[],int cod){
    int codigo, dia, mes, ano;
    String temp, msg = "";
    codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto a ser alterado: "));
    if (codigo < 1 || codigo > cod)
        JOptionPane.showMessageDialog(null, "Produto Inexistente!");
    else{
        msg = msg + "\n------------  Produto a ser alterado  -------------------------";
        msg = msg + "\nCodigo: " + p[codigo-1].getCodigoNumerico();
        msg = msg + "\nDescrição: " + p[codigo-1].getNome();
        msg = msg + "\nPreço de tabela: " + p[codigo-1].getPreco();
        msg = msg + "\nPrazo para o vencimento: " + p[codigo-1].calcularVencimento() +" dias";
        msg = msg + "\nPreço de Venda: " + df.format(p[codigo-1].precoAtual);
        JOptionPane.showMessageDialog(null, msg);
        
        p[codigo-1].setNome(JOptionPane.showInputDialog("Digite a nova descrição: "));
        
        temp = JOptionPane.showInputDialog("Digite  o  preço  de  tabela: ");
        p[codigo-1].setPreco(Float.parseFloat(temp));

        temp = JOptionPane.showInputDialog("Digite o dia de vencimento: ");
        dia = Integer.parseInt(temp);
        p[codigo-1].setDiaVencimento(dia);

        temp = JOptionPane.showInputDialog("Digite o mês de vencimento: ");
        mes = Integer.parseInt(temp);
        p[codigo-1].setMesVencimento(mes);

        temp = JOptionPane.showInputDialog("Digite o ano de vencimento: ");
        ano = Integer.parseInt(temp);
        p[codigo-1].setAnoVencimento(ano);

        p[codigo-1].calcularPreco();

        JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!" );
        }
    }// fim alterarDadosDeUmProduto

    public static void mostrarEstoque(Produto p[], int cod){
        String msg = "";
        
        for (int cont = 0; cont < cod; cont++){
            msg = msg + "\n-------------------------------------------------";
            msg = msg + "\nCodigo: " + p[cont].getCodigoNumerico();
            msg = msg + "\nDescrição: " + p[cont].getNome();
            msg = msg + "\nPreço de tabela: " + p[cont].getPreco();
            msg = msg + "\nPrazo para o vencimento: " + p[cont].calcularVencimento() +" dias";
            msg = msg + "\nPreço de Venda: " + df.format(p[cont].precoAtual);
            JOptionPane.showMessageDialog(null, msg);
        }

    }

    public static void mostrarMenorValidade(Produto p[], int cod){
        //float maiorPreco;
        int indice, menorValidade, cont;
        String msg = "";
        menorValidade = p[0].calcularVencimento();
        indice = 0;

        for (cont = 1; cont < cod; cont ++){
            if (p[cont].calcularVencimento() < menorValidade){
            menorValidade = p[cont].calcularVencimento();
            indice = cont;
            }
        }

        msg += "\nCodigo: " + p[indice].getCodigoNumerico();
        msg += "\nDescrição: " + p[indice].getNome();
        msg += "\nPreço de Tabela: " + p[indice].getPreco();
        msg += "\nPrazo de validade: " + p[indice].calcularVencimento() + " dias";
        msg += "\nPreço de Venda: " + df.format(p[indice].getPrecoAtual());
        JOptionPane.showMessageDialog(null, msg);

    }//fim mostraMenorValidade


    public static int menu(){
        int opcao;
        String mensagem, temp;
        mensagem ="---------------------------------------  MENU  ---------------------------------------\n";
        mensagem += "Digite a função desejada:\n";
        mensagem += "1 - Cadastrar Produto\n";
        mensagem += "2 - Mostrar detalhes do Produto mais próximo do vencimento\n";
        mensagem += "3 - Mostrar todos os produtos do estoque\n";
        mensagem += "4 - Alterar Produto\n";
        mensagem += "5 - Finalizar Programa\n";
        

        temp = JOptionPane.showInputDialog(mensagem);
        opcao = Integer.parseInt(temp);
        return opcao;
        
    }

    public void executaMenu(){
        Produto produto[] = new Produto[20];
        int opcao, contador = 0;

        try {
            
            do{
                opcao = menu();
                switch(opcao)
                {
                    case 1: if (contador == produto.length)
                    JOptionPane.showMessageDialog(null, "Capacidade máxima do estoque preenchida!");
                    else 
                    contador = cadastrarProduto(produto, contador);
                    break;
    
                    case 2: if (contador == 0)
                    JOptionPane.showMessageDialog(null, "Nenhum produto no estoque!");
                    else mostrarMenorValidade(produto, contador);
                    break;
    
                    case 3: if(contador == 0)
                    JOptionPane.showMessageDialog(null, "Nenhum produto no estoque!");
                    else 
                    mostrarEstoque(produto, contador);
                    break;
                    
                    case 4: if (contador == 0)
                    JOptionPane.showMessageDialog(null, "Nenhum produto no estoque!");
                    else alterarProduto(produto, contador);
    
                } // fim switch
    
            } while(opcao != 5);

        } catch (Exception e) {
            System.out.println("\n << Erro encontrado: -> " + e.getMessage());
        }
        

    } // Fim método executaMenu

    
}
