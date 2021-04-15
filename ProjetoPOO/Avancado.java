
/**
 * Dados sobre um Jogador do tipo Avançado.
 *
 * @author grupo
 * @version 210402
 */
public class Avancado{
    
    private double drible;
    
    public Avancado(){
        this.drible = 0;
    }
    
    public Avancado(int drible){
        this.drible = drible;
    }
    
    public Avancado(Avancado umJog){
        this.drible = umJog.getDrible();
    }
    
     /**
     * Métodos get e set.
     */
    public double getDrible(){
        return this.drible;
    }
    
    public void setDrible(double drible){
        this.drible = drible;
    }
    
    public double habAvancado (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*1;
        habilidade += umJog.getResistencia()*0.5;
        habilidade += umJog.getDestreza()*1;
        habilidade += umJog.getImpulsao()*1;
        habilidade += umJog.getJogoCabeca()*1;
        habilidade += umJog.getRemate()*1;
        habilidade += umJog.getCapPasse()*0.5;
        habilidade += this.drible*1;
        
        return habilidade;
    }
}
