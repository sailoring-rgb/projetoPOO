
/**
 * Dados sobre um Jogador do tipo Lateral.
 *
 * @author grupo
 * @version 210402
 */
public class Lateral{

    private double cruzamento;
    
    public Lateral(){
        this.cruzamento = 0;
    }
    
    public Lateral(int cruzamento){
        this.cruzamento = cruzamento;
    }
    
    public Lateral(Lateral umJog){
        this.cruzamento = umJog.getCruzamento();
    }
    
     /**
     * Métodos get e set.
     */
    public double getCruzamento(){
        return this.cruzamento;
    }
    
    public void setCruzamento(double cruzamento){
        this.cruzamento = cruzamento;
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
        habilidade += this.cruzamento*1;
        
        return habilidade;
    }
}
