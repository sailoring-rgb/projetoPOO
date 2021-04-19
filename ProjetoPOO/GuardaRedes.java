
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo
 * @version 210402
 */
public class GuardaRedes extends Jogador{
    
    private double elasticidade;
    private double lancamento; // ato de lançar a bola para um companheiro distante consoante a distância a que está dele.
    
    /**
     * Construtor por omissão.
     */
    public GuardaRedes(){
        this.elasticidade = 0;
        this.lancamento = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public GuardaRedes(double elasticidade, double lancamento){
        this.elasticidade = elasticidade;
        this.lancamento = lancamento;
    }
    
    /**
     * Construtor de cópia.
     */
    public GuardaRedes(GuardaRedes umJog){
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
        double habilidade = umJog.getVelocidade()*0.2 + umJog.getResistencia()*0.5 + umJog.getDestreza()*0.7 + umJog.getImpulsao()*1 +
                            umJog.getJogoCabeca()*0.2 + umJog.getRemate()*0.2 + umJog.getCapPasse()*0.4 + this.elasticidade*1 +
                            this.lancamento*1;
        return habilidade;
    }
}
