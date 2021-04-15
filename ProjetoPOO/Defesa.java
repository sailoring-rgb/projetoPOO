
/**
 * Dados sobre um Jogador do tipo Defesa.
 *
 * @author grupo
 * @version 210402
 */

public class Defesa{
    
    private double intercepcao;
    
    public Defesa(){
        this.intercepcao = 0;
    }
    
    public Defesa(int intercepcao){
        this.intercepcao = intercepcao;
    }
    
    public Defesa(Defesa umJog){
        this.intercepcao = umJog.getIntercepcao();
    }
    
     /**
     * Métodos get e set.
     */
    public double getIntercepcao(){
        return this.intercepcao;
    }
    
    public void setIntercepcao(double intercepcao){
        this.intercepcao = intercepcao;
    }
    
    public double habDefesa (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*0.5;
        habilidade += umJog.getResistencia()*1;
        habilidade += umJog.getDestreza()*0.5;
        habilidade += umJog.getImpulsao()*1;
        habilidade += umJog.getJogoCabeca()*1;
        habilidade += umJog.getRemate()*0.2;
        habilidade += umJog.getCapPasse()*0.2;
        habilidade += this.intercepcao*1;
        
        return habilidade;
    }
}
