package GestInfo;
/**
 * Dados sobre um Jogador do tipo Médio.
 *
 * @author grupo 3
 * @version 210402
 */

import java.util.*;
import java.io.PrintWriter;
import java.util.Random;

public class Medio extends Jogador{
   
    private int capRecuperacao;
    private int dominioBola;
    
    /**
     * Construtor por omissão.
     */
    public Medio(){
        super();
        this.capRecuperacao = 0;
        Random rand = new Random();
        this.dominioBola = rand.nextInt(101);
    }
    
    /**
     * Construtor parametrizado.
     */
    public Medio(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int capRecuperacao, int dominioBola, List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse,historico, 2);
        this.capRecuperacao = capRecuperacao;
        this.dominioBola = dominioBola;
    }
    
    /**
     * Construtor de cópia.
     */
    public Medio(Medio umJog){
        super(umJog);
        this.capRecuperacao = umJog.getCapRecuperacao();
        this.dominioBola = umJog.getDominioBola();
    }
    
    /**
    * Método que obtém o valor da capacidade de recuperação da bola do médio.
    * @return o valor da capacidade de recuperação da bola
    */
    public int getCapRecuperacao(){
        return this.capRecuperacao;
    }
    
    /**
    * Método que muda o valor da capacidade de recuperação da bola do médio.
    * @param o novo valor da capacidade de recuperação da bola
    */
    public void setCapRecuperacao(int capRecuperacao){
        this.capRecuperacao = capRecuperacao;
    }
    
    /**
    * Método que obtém o valor do domínio da bola do médio.
    * @return o valor da domínio da bola
    */
    public int getDominioBola(){
        return this.dominioBola;
    }
    
    /**
    * Método que muda o valor do domínio da bola do médio.
    * @param o novo valor do domínio da bola
    */
    public void setDominioBola(int dominioBola){
        this.dominioBola = dominioBola;
    }
    
    /**
    * Método que calcula a habilidade do médio.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do médio
    */
    public double habMedio (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*0.5 + umJog.getDestreza()*1 + umJog.getImpulsao()*0.5 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*1 + getCapRecuperacao()*1 + getDominioBola()*1;
        return habilidade;
    }
    
    /**
    * Método que imprime a informação de um médio, incluindo o seu histórico
    * (ou seja, as equipas onde já esteve).
    */
    public void apresentarJogadorMedio(){
        System.out.println("Posição: Médio");
        apresentarJogador();
        System.out.println("     Capacidade de Recuperação: " + getCapRecuperacao());
        System.out.println("     Dominio de Bola: " + getDominioBola());
        
        System.out.println("Habilidade geral:" + habMedio(this));
        
        apresentarHistorico();
    }
    
    /**
    * Método que preenche os campos de um objeto de tipo Medio (e dos seus campos)
    * com o conteúdo de uma string separado por vírgulas.
    */
    public static Medio parse(String input){
        Random rand = new Random();
        
        String[] campos = input.split(",");
        return new Medio(campos[0],
                Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                rand.nextInt(101),
                new ArrayList<>());
    }
    
    /**
    * Método que guarda um objeto de tipo Medio.
    */
    public void saverMedio(PrintWriter print,Jogador umJog){
        print.print("Medio:");
        umJog.saver(print);
        print.println(","+this.capRecuperacao);
        }
        
    /**
    * Método que faz um clone do objeto Medio.
    * @return o clone
    */
    public Medio clone(){
        return new Medio(this);
    }
}
