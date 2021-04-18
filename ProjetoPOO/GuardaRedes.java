
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo
 * @version 210402
 */
public class GuardaRedes extends Jogador{
    
    private double elasticidade;
    private double lancamento; // ato de chutar a bola para um companheiro distante
    
    public GuardaRedes(){
        this.elasticidade = 0;
        this.lancamento = 0;
    }
    
    public GuardaRedes(double elasticidade, double lancamento){
        this.elasticidade = elasticidade;
        this.lancamento = lancamento;
    }
    
    public GuardaRedes(GuardaRedes umJog){
        this.elasticidade = umJog.getElasticidade();
        this.lancamento = umJog.getLancamento();
    }
    
     /**
     * Métodos get e set.
     */
    public double getElasticidade(){
        return this.elasticidade;
    }
    
    public double getLancamento(){
        return this.lancamento;    
    }
    
    public void setElasticidade(double elasticidade){
        this.elasticidade = elasticidade;
    }
    
    public void setLancamento(double lancamento){
        this.lancamento = lancamento;
    }
    
    public double habGuardaRedes (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*0.2;
        habilidade += umJog.getResistencia()*0.5;
        habilidade += umJog.getDestreza()*0.7;
        habilidade += umJog.getImpulsao()*1;
        habilidade += umJog.getJogoCabeca()*0.2;
        habilidade += umJog.getRemate()*0.2;
        habilidade += umJog.getCapPasse()*0.4;
        habilidade += this.elasticidade*1;
        habilidade += this.lancamento*1;
        
        return habilidade;
    }
}
