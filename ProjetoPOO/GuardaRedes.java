
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo
 * @version 210402
 */
public class GuardaRedes{
    
    private double elasticidade;
    
    public GuardaRedes(){
        this.elasticidade = 0;
    }
    
    public GuardaRedes(int elasticidade){
        this.elasticidade = elasticidade;
    }
    
    public GuardaRedes(GuardaRedes umJog){
        this.elasticidade = umJog.getElasticidade();
    }
    
     /**
     * Métodos get e set.
     */
    public double getElasticidade(){
        return this.elasticidade;
    }
    
    public void setElasticidade(double elasticidade){
        this.elasticidade = elasticidade;
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
        
        return habilidade;
    }
}
