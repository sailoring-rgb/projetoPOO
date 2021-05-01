/**
 * Dados sobre um Jogador do tipo Médio.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class Medio extends Jogador{
   
    private double capRecuperacao;
    private double dominioBola; // habilidade de reter uma bola em condições de realizar uma jogada
    
    /**
     * Construtor por omissão.
     */
    public Medio(){
        super();
        this.capRecuperacao = 0;
        this.dominioBola = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Medio(double velocidade, double resistencia, double destreza, double impulsao, double jogoCabeca, double remate, double capPasse, double capRecuperacao, double dominioBola, List<Equipa> historico){
        super(velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse, historico);
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
    public double getCapRecuperacao(){
        return this.capRecuperacao;
    }
    
    /**
    * Método que obtém o valor da capacidade de domínio da bola do médio.
    * @return o valor da capacidade de domínio da bola
    */
    public double getDominioBola(){
        return this.dominioBola;
    }
    
    /**
    * Método que muda o valor da capacidade de recuperação da bola do médio.
    * @param o novo valor da capacidade de recuperação da bola
    */
    public void setCapRecuperacao(double capRecuperacao){
        this.capRecuperacao = capRecuperacao;
    }

    /**
    * Método que muda o valor da capacidade de domínio da bola do médio.
    * @param o novo valor da capacidade de domínio da bola
    */
    public void setDominioBola(double dominioBola){
        this.dominioBola = dominioBola;
    }    
    
    /**
    * Método que calcula a habilidade do médio.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do médio
    */
    public double habMedio (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*0.5 + umJog.getDestreza()*1 + umJog.getImpulsao()*0.5 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*1 + this.capRecuperacao*1 + this.dominioBola*1;
        return habilidade;
    }
}
