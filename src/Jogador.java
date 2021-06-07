
/**
 * Dados sobre um jogador.
 *
 * @author grupo
 * @version 210330
 */

import java.util.*;
import java.util.stream.Collectors;

public class Jogador{
    private static final int AVANCADO = 1;
    private static final int MEDIO = 2;
    private static final int LATERAL = 3;
    private static final int DEFESA = 4;
    private static final int GR = 5;
    
    private String nome;
    private int nr_camisola;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int capPasse;
    private List<String> historico;
    private int tipoJogador;
    
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
        this.tipoJogador = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Jogador (String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, List<String> historico, int tipoJogador){
        this.nome = nome;
        this.nr_camisola = nr_camisola;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoCabeca = jogoCabeca;
        this.remate = remate;
        this.capPasse = capPasse;
        this.historico = historico;
        this.tipoJogador = tipoJogador;
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
        this.tipoJogador = umJog.getTipoJogador();
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
    public int getVelocidade(){
        return this.velocidade;
    }
    
    /**
    * Método que obtém o valor da resistência do jogador.
    * @return o valor da resistência
    */
    public int getResistencia(){
        return this.resistencia;
    }

    /**
    * Método que obtém o valor da destreza do jogador.
    * @return o valor da destreza
    */
    public int getDestreza(){
        return this.destreza;
    }

    /**
    * Método que obtém o valor da impulsão do jogador.
    * @return o valor da impulsão
    */
    public int getImpulsao(){
        return this.impulsao;
    }

    /**
    * Método que obtém o valor do jogo de cabeça do jogador.
    * @return o valor do jogo de cabeça
    */
    public int getJogoCabeca(){
        return this.jogoCabeca;
    }

    /**
    * Método que obtém o valor do remate do jogador.
    * @return o valor do remate
    */
    public int getRemate(){
        return this.remate;
    }

    /**
    * Método que obtém o valor da capacidade de passe do jogador.
    * @return o valor da capacidade de passe
    */
    public int getCapPasse(){
        return this.capPasse;
    }
    
    /**
    * Método que obtém o historico do jogador.
    * @return o historico
    */
    public List<String> getHistorico(){
        return this.historico;
    }
    
    /**
    * Método que obtém o tipo do jogador.
    * @return o tipo do jogador
    */
    public int getTipoJogador(){
        return this.tipoJogador;
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
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }

    /**
    * Método que muda o valor da resistência do jogador.
    * @param o novo valor da resistência
    */
    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }

    /**
    * Método que muda o valor da destreza do jogador.
    * @param o novo valor da destreza
    */
    public void setDestreza(int destreza){
        this.destreza = destreza;
    }

    /**
    * Método que muda o valor da impulsão do jogador.
    * @param o novo valor da impulsão
    */
    public void setImpulsao(int impulsao){
        this.impulsao = impulsao;
    }

    /**
    * Método que muda o valor do jogo de cabeça do jogador.
    * @param o novo valor do jogo de cabeça
    */
    public void setJogoCabeca(int jogoCabeca){
        this.jogoCabeca = jogoCabeca;
    }

    /**
    * Método que muda o valor do remate do jogador.
    * @param o novo valor do remate
    */
    public void setRemate(int remate){
        this.remate = remate;
    }   

    /**
    * Método que muda o valor da capacidade de passe do jogador.
    * @param o novo valor da capacidade de passe
    */
    public void setCapPasse(int capPasse){
        this.capPasse = capPasse;
    }
    
    /**
    * Método que muda o historico do jogador.
    * @return o novo historico
    */
    public void setHistorico(List<String> historico){
        this.historico = new ArrayList<>();
        for(String hist : historico) {
            this.historico.add(hist);
        }
    }
    
    /**
    * Método que muda o tipo do jogador.
    * @return o novo tipo de jogador
    */
    public void setTipoJogador(int tipoJogador){
        this.tipoJogador = tipoJogador;
    }
    
    /**
    * Método que adiciona uma equipa o historico do jogador.
    * @return o novo historico
    */
    public void addHistorico(String equipa){
        this.historico.add(equipa);
    }
    
    /**
    * Método que faz um clone do objeto Jogador.
    * @return o clone
    */
    public Jogador clone(){
        return new Jogador(this);
    }
    
    public void apresentarJogador(){
        System.out.println("  Habilidades:");

        System.out.println("Velocidade: " + this.getVelocidade());
        System.out.println("Resistencia: " + this.getResistencia());
        System.out.println("Destreza: " + this.getDestreza());
        System.out.println("Impulsao: " + this.getImpulsao());
        System.out.println("Jogo de Cabeça: " + this.getJogoCabeca());
        System.out.println("Remate: " + this.getRemate());
        System.out.println("Capacidade de Passe: " + this.getCapPasse());
    }
    
    public void apresentarHistorico(){
        System.out.println("Equipas frequentadas: ");
        for (String equipa : historico) {
                System.out.println(equipa);
        }
    }
}
