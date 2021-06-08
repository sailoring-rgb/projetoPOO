/**
 * Dados sobre um Jogador do tipo Médio.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class Medio extends Jogador{
   
    private int capRecuperacao;
    private int dominioBola; // habilidade de reter uma bola em condições de realizar uma jogada
    
    /**
     * Construtor por omissão.
     */
    public Medio(){
        super();
        this.capRecuperacao = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Medio(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int capRecuperacao, List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse,historico, 2);
        this.capRecuperacao = capRecuperacao;
    }
    
    /**
     * Construtor de cópia.
     */
    public Medio(Medio umJog){
        super(umJog);
        this.capRecuperacao = umJog.getCapRecuperacao();
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
    * Método que calcula a habilidade do médio.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do médio
    */
    public double habMedio (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*0.5 + umJog.getDestreza()*1 + umJog.getImpulsao()*0.5 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*1 + this.capRecuperacao*1;
        return habilidade;
    }
    
    public void apresentarJogadorMedio(){
        System.out.println("Posição: Médio");
        apresentarJogador();
        System.out.println("Capacidade de Recuperação: " + capRecuperacao);
        
        apresentarHistorico();
    }
    
    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                new ArrayList<>());
    }
}
