
/**
 * Write a description of class GuardaRedes here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
