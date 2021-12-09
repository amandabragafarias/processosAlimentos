/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoprogramacao;

import java.util.Scanner;

/**
 *
 * @author Amanda Braga
 */
public class TrabalhoProgramacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String produtos[] = new String[5];
        String processos[] = new String[5];
        double matriz[][] = new double[5][5];
        double valorProcesso[] = new double[5];
        String custosPorProcessos[][] = new String[2][5];
        
     int opcao;
// Imprimir o menu….(dentro do laço, para sempre imprimir e manter rodando até que seja digitado 0)
     
        do{ 
        System.out.println("--------MENU--------");
        System.out.println("1 - Cadastro de Alimento.");
        System.out.println("2 - Cadastro de Tipos de Processo.");
        System.out.println("3 - Inclusão de processamento.");
        System.out.println("4 - Alteração de processamento.");
        System.out.println("5 - Cadastro de custos de processo por unidade.");
        System.out.println("6 - Relatório de Estoque.");
        System.out.println("7 - Relatório de custo por processo.");
        System.out.println("8 - Alimento em maior quantidade no estoque.");
        System.out.println("0 - Terminar programa.");
        
        System.out.println("Digite a opção desejada."); 
            opcao = input.nextInt();
            
switch (opcao){
       case 1: 
          
          produtos = cadastroProduto();
          System.out.println("Cadastro realizado com sucesso!");// cadastro de produto (alimentos)
         break;
           
       case 2: 
           processos = cadastroProcesso();
           System.out.println("Cadastro realizado com sucesso!");// cadastro de processo
        
         break;
           
       case 3: 
           matriz = inclusao(processos, produtos); 
          System.out.println("Cadastro realizado com sucesso!");// Inclusão de quantidade de produtos por processo 
         break;
           
       case 4: matriz = alteracao(processos, produtos, matriz);
          System.out.println("Alteração realizada com sucesso!");// Alterar quantidade de produtos por processo
             
         break;
            case 5: 
               valorProcesso = cadastroCusto(processos);
               System.out.println("Cadastro realizado com sucesso!");// cadastro de custo de processos (preço do processo por unidade de produto)
          break;
           
           
       case 6: 
          System.out.println("Os produtos e processos cadastrados são: ");// Relatório de estoque
            relatorioEstoque(matriz, processos, produtos);
          break;
           
       case 7: 
           custoPorProcesso(matriz,valorProcesso, processos);// Relatório de custo por processo
          
          break;
           
       case 8:
           System.out.println("O alimento em maior quantidade no estoque é: " + maiorQuant(matriz, produtos));
           maiorQuant(matriz, produtos);// Alimento presente em maior quantidade
          break;
          
       default: System.out.println("Não temos a opção " + opcao);
     }

        }
         while(opcao != 0);{
    //para de rodar ao digitar 0
    }
       
  } //---FIM DA MAIN---- 
    
    
    
    //---MÉTODOS---- 
    
    //cadatro de produtos -vetor produtos-
    public static String[] cadastroProduto() {
        Scanner e = new Scanner(System.in);
        String produtos[] = new String[5];
for(int i=0;i<5;i++){
        System.out.println("Digite o nome do produto.");
        produtos[i] = e.next();
     }
return produtos;
    }
    
    
    //cadastro de processos -vetor processos-
    public static String[] cadastroProcesso() {
       Scanner e = new Scanner(System.in);
        String processos[] = new String[5];
for(int i=0;i<5;i++){
        System.out.println("Digite o nome do processo.");
        processos[i] = e.next();
     }
return processos;
    }
    
    
    //cadastro de preços por processo -vetor valores-
    public static double[] cadastroCusto(String[] processos) {
       Scanner e = new Scanner(System.in);
       String processo[] = processos;
        double valores[] = new double[5];

 for(int i=0;i<5;i++){
           
              System.out.println("Entre com o custo unitário do processo " + processo[i]);
              valores[i]= e.nextDouble();
            
       }

return valores;
    }

    
    //relação entre vetor produtos e vetor processos, gerando uma matriz 5x5 com a quantidade de produtos por processo
    public static double[][] inclusao(String[] processos,String[] produtos) {
     Scanner e = new Scanner(System.in);
     String processo[] = processos;
     String produto[] = produtos;
     
     double m[][] = new double[5][5];
     
       for(int i=0;i<5;i++){
           for(int j=0;j<5;j++){
              System.out.println("Entre com o número de " + produto[i] + " para o processo " + processo[j]);
              m[j][i]= e.nextInt();
            
           }
       }
       
       return m;
    }

    
    //alteração da quantidade de produtos por processo na matriz 5x5
    public static double[][] alteracao(String[] processos,String[] produtos, double[][] matriz) {
     Scanner e = new Scanner(System.in);
     String processo[] = processos;
     String produto[] = produtos;
     double m[][] = matriz;
     
     //entrada de dados que deseja alterar
     System.out.println("Digite o nome do produto para alterar a quantidade.");
     String prod = e.next();
     System.out.println("Digite o nome do processo para alterar a quantidade de produtos presentes.");
     String process = e.next();
     System.out.println("Digite a quantidade.");
     double quant = e.nextDouble();
     
     //encontrar posicao na matriz e alterar o valor
       for(int i=0;i<5;i++){
           for(int j=0;j<5;j++){
              if(produto[j].equals(prod) && processo[i].equals(process)){
                  m[i][j]= quant;
              }
            
           }
       }
       
       return m;
        
           }

    //imprime matriz 6x6 com todos os produtos cadastrados com suas respectivas quantidades para cada processo
    public static void relatorioEstoque(double[][] matriz, String[] processos, String[] produtos) {
         double m[][] = matriz;
         String processo[] = processos;
         String produto[] = produtos;
         String mm[][] = new String[6][6];
         
          //preencher matriz 6x6
       for(int i=0;i<6;i++){
           for(int j=0;j<6;j++){
               
               mm[0][0] = " ";
           
                if(i==0 && j>0){
               mm[i][j] = produto[j-1];
           }
                 if(j==0 && i>0){
               mm[i][j] = processo[i-1];
           }
                if(i>0 && j>0){
                     mm[i][j] = String.valueOf(m[i-1][j-1]);
           }
         }
       }
       
       //imprimir
       for(int i=0;i<6;i++){
           for(int j=0;j<6;j++){
              System.out.print(mm[i][j]+"\t");
              
           }
         //tabulação
           System.out.println();
       }
        
    }

   
//calcula o valor de cada processo com base na quantidade de produtos e imprime o resultado em uma matriz 2x5
    public static void custoPorProcesso(double[][] matriz, double[] valorProcesso, String[] processos) { 
          double m[][] = matriz;
          double valores[] = valorProcesso;
          double vetorSoma[] = new double[5];
          String matrizCustos[][] = new String [2][5];
     
        for(int i=0;i<5;i++){
           double soma = 0;
           for(int j=0;j<5;j++){
              soma = soma + m[i][j];
              
 }       // salvar quantidade de produtos no vetor soma
           vetorSoma[i]=soma;
       } 
      
       for(int i=0;i<5;i++){
           
           for(int j=0;j<5;j++){
               
              matrizCustos[0][j] = processos[j];
                
              matrizCustos[1][j] = String.valueOf(vetorSoma[j] * valores[j]);
             
              
           } 
       }
          
        //imprimir
       for(int i=0;i<2;i++){
           for(int j=0;j<5;j++){
              System.out.print(matrizCustos[i][j]+"\t");
              
           }
           System.out.println();
       }
        
    }

    //calcula e imprime o produto presente em maior quantidade
    public static String maiorQuant(double[][] matriz, String [] produtos) {
        double maior = 0; 
        double m[][] = matriz;
        String produto[] = produtos;
        String prodmaior=null;
        double vetorSoma[] = new double [5];
        
        //calcular quantidade de produtos
       for(int j=0;j<5;j++){
           double soma = 0;
           for(int i=0;i<5;i++){
              soma = soma + m[i][j];
              
 }       // salvar quantidade de produtos no vetor soma
           vetorSoma[j]=soma;
       } 
       //verificar maior soma
       for(int i=0;i<5;i++){
         if(vetorSoma[i]>maior){
         maior = vetorSoma[i];
         }
         
  }
       //identificar nome do produto no vetor produtos
        for(int i=0;i<5;i++){
         if(vetorSoma[i]==maior){
        prodmaior = produtos[i];
         }
  }
       return prodmaior;
        }

    //------FIM------
}
