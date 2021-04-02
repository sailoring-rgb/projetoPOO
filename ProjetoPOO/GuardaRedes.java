
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo
 * @version 210402
 */
public class GuardaRedes
{
    private double elasticidade;
    
    public GuardaRedes(){
        this.elasticidade = 0;
    }
    
    public GuardaRedes(int elasticidade){
        this.elasticidade = elasticidade;
    }
    
    public GuardaRedes(GuardaRedes umGR){
        this.elasticidade = umGR.getElasticidade();
    }
    
    public double getElasticidade(){
        return this.elasticidade;
    }
    
    public void setElasticidade(double elasticidade){
        this.elasticidade = elasticidade;
    }
}
