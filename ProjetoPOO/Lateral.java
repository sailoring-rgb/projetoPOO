
/**
 * Dados sobre um Jogador do tipo Lateral.
 *
 * @author grupo
 * @version 210402
 */
public class Lateral extends Jogador{

    private double capCruzamento;
    
    public Lateral(){
        this.capCruzamento = 0;
    }
    
    public Lateral(int capCruzamento){
        this.capCruzamento = capCruzamento;
    }
    
    public Lateral(Lateral umJog){
        this.capCruzamento = umJog.getCapCruzamento();
    }
    
     /**
     * Métodos get e set.
     */
    public double getCapCruzamento(){
        return this.capCruzamento;
    }
    
    public void setCruzamento(double capCruzamento){
        this.capCruzamento = capCruzamento;
    }
    
    public double habLateral (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*1;
        habilidade += umJog.getResistencia()*0.5;
        habilidade += umJog.getDestreza()*1;
        habilidade += umJog.getImpulsao()*1;
        habilidade += umJog.getJogoCabeca()*0.5;
        habilidade += umJog.getRemate()*0.5;
        habilidade += umJog.getCapPasse()*1;
        habilidade += this.capCruzamento*1;
        
        return habilidade;
    }
}
