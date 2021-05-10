
/**
 * Dados sobre um jogador.
 *
 * @author grupo
 * @version 210330
 */

import java.util.*;
import java.util.stream.Collectors;

public class Jogador{
    /*
    private static final int GUARDA_REDES = 0;
    private static final int DEFESA = 1;
    private static final int MEDIO = 2;
    private static final int AVANCADO = 3;
    private static final int LATERAL = 4;
    */
    private String nome;
    private int nr_camisola;
    private double velocidade;
    private double resistencia;
    private double destreza;
    private double impulsao;
    private double jogoCabeca;
    private double remate;
    private double capPasse;
    private List<Equipa> historico;
    
    /**
     * Construtor por omissão.
     */
    public Jogador(){
        this.nome = "";
        this.nr_camisola = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogoCabeca = 0;
        this.remate = 0;
        this.capPasse = 0;
        this.historico = new ArrayList<>();
    }
    
    /**
     * Construtor parametrizado.
     */
    public Jogador (String nome, int nr_camisola, double velocidade, double resistencia, double destreza, double impulsao, double jogoCabeca, double remate, double capPasse, List<Equipa> historico){
        this.nome = nome;
        this.nr_camisola = nr_camisola;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoCabeca = jogoCabeca;
        this.remate = remate;
        this.capPasse = capPasse;
        this.historico = historico.stream().map(Equipa::new).collect(Collectors.toList());
    }
    
    /**
     * Construtor de cópia.
     */
    public Jogador(Jogador umJog){
        this.nome = umJog.getNome();
        this.nr_camisola = umJog.getNrCamisola();
        this.velocidade = umJog.getVelocidade();
        this.resistencia = umJog.getResistencia();
        this.destreza = umJog.getDestreza();
        this.impulsao = umJog.getImpulsao();
        this.jogoCabeca = umJog.getJogoCabeca();
        this.remate = umJog.getRemate();
        this.capPasse = umJog.getCapPasse();
        this.historico = umJog.getHistorico();
    }
    
    /**
    * Método que obtém o nome do jogador.
    * @return o nome
    */
    public String getNome(){
        return this.nome;
    }
    
    /**
    * Método que obtém o numero da camisola do jogador.
    * @return o numero da camisola
    */
    public int getNrCamisola(){
        return this.nr_camisola;
    }
    
    /**
    * Método que obtém o valor da velocidade do jogador.
    * @return o valor da velocidade
    */
    public double getVelocidade(){
        return this.velocidade;
    }
    
    /**
    * Método que obtém o valor da resistência do jogador.
    * @return o valor da resistência
    */
    public double getResistencia(){
        return this.resistencia;
    }

    /**
    * Método que obtém o valor da destreza do jogador.
    * @return o valor da destreza
    */
    public double getDestreza(){
        return this.destreza;
    }

    /**
    * Método que obtém o valor da impulsão do jogador.
    * @return o valor da impulsão
    */
    public double getImpulsao(){
        return this.impulsao;
    }

    /**
    * Método que obtém o valor do jogo de cabeça do jogador.
    * @return o valor do jogo de cabeça
    */
    public double getJogoCabeca(){
        return this.jogoCabeca;
    }

    /**
    * Método que obtém o valor do remate do jogador.
    * @return o valor do remate
    */
    public double getRemate(){
        return this.remate;
    }

    /**
    * Método que obtém o valor da capacidade de passe do jogador.
    * @return o valor da capacidade de passe
    */
    public double getCapPasse(){
        return this.capPasse;
    }
    
    /**
    * Método que obtém a lista de equipas em que já jogou.
    * @return a lista de equipas
    */
    public List<Equipa> getHistorico(){
       return this.historico;
    }
    
    /**
    * Método que muda o nome do jogador.
    * @param o novo nome
    */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
    * Método que muda o numero da camisola do jogador.
    * @param o novo valor da camisola
    */
    public void setNrCamisola(int nr_camisola){
        this.nr_camisola = nr_camisola;
    }
    
    /**
    * Método que muda o valor da velocidade do jogador.
    * @param o novo valor da velocidade
    */
    public void setVelocidade(double velocidade){
        this.velocidade = velocidade;
    }

    /**
    * Método que muda o valor da resistência do jogador.
    * @param o novo valor da resistência
    */
    public void setResistencia(double resistencia){
        this.resistencia = resistencia;
    }

    /**
    * Método que muda o valor da destreza do jogador.
    * @param o novo valor da destreza
    */
    public void setDestreza(double destreza){
        this.destreza = destreza;
    }

    /**
    * Método que muda o valor da impulsão do jogador.
    * @param o novo valor da impulsão
    */
    public void setImpulsao(double impulsao){
        this.impulsao = impulsao;
    }

    /**
    * Método que muda o valor do jogo de cabeça do jogador.
    * @param o novo valor do jogo de cabeça
    */
    public void setJogoCabeca(double jogoCabeca){
        this.jogoCabeca = jogoCabeca;
    }

    /**
    * Método que muda o valor do remate do jogador.
    * @param o novo valor do remate
    */
    public void setRemate(double remate){
        this.remate = remate;
    }   

    /**
    * Método que muda o valor da capacidade de passe do jogador.
    * @param o novo valor da capacidade de passe
    */
    public void setCapPasse(double capPasse){
        this.capPasse = capPasse;
    }
    
    /**
    * Método que muda a lista de equipas que já jogou.
    * @param a nova lista de equipas
    */
    public void setHistorico(List<Equipa> historico){
       this.historico = historico;
    }
}
