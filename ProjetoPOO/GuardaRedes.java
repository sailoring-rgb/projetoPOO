
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class GuardaRedes extends Jogador{
    
    private double elasticidade;
    private double lancamento; // ato de lançar a bola para um companheiro distante consoante a distância a que está dele.
    
    /**
     * Construtor por omissão.
     */
    public GuardaRedes(){
        super();
        this.elasticidade = 0;
        this.lancamento = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public GuardaRedes(String nome, int nr_camisola, double velocidade, double resistencia, double destreza, double impulsao, double jogoCabeca, double remate, double capPasse, double elasticidade, double lancamento, List<Equipa> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse, historico);
        this.elasticidade = elasticidade;
        this.lancamento = lancamento;
    }
    
    /**
     * Construtor de cópia.
     */
    public GuardaRedes(GuardaRedes umJog){
        super(umJog);
        this.elasticidade = umJog.getElasticidade();
        this.lancamento = umJog.getLancamento();
    }
    
    /**
    * Método que obtém o valor da elasticidade do guarda-redes.
    * @return o valor da elasticidade
    */
    public double getElasticidade(){
        return this.elasticidade;
    }
    
    /**
    * Método que obtém o valor da capacidade de lançamento do guarda-redes.
    * @return o valor da capacidade de lançamento
    */
    public double getLancamento(){
        return this.lancamento;    
    }
    
    /**
    * Método que muda o valor da elasticidade do guarda-redes.
    * @param o novo valor da elasticidade
    */
    public void setElasticidade(double elasticidade){
        this.elasticidade = elasticidade;
    }
    
    /**
    * Método que muda o valor da capacidade de lançamento do guarda-redes.
    * @param o novo valor da capacidade de lançamento
    */
    public void setLancamento(double lancamento){
        this.lancamento = lancamento;
    }
    
    /**
    * Método que calcula a habilidade do guarda-redes.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do guarda-redes
    */
    public double habGuardaRedes (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*1 + umJog.getDestreza()*0.5 + umJog.getImpulsao()*1 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*0.5 + this.elasticidade*1 +
                            this.lancamento*1;
        return habilidade;
    }
}
