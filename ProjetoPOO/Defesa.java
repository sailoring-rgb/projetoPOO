
/**
 * Dados sobre um Jogador do tipo Defesa.
 *
 * @author grupo
 * @version 210402
 */

public class Defesa extends Jogador{
    
    private double desarme; // abordagem ao oponente, buscando obter a posse de bola
    
    public Defesa(){
        this.desarme = 0;
    }
    
    public Defesa(int desarme){
        this.desarme = desarme;
    }
    
    public Defesa(Defesa umJog){
        this.desarme = umJog.getDesarme();
    }
    
     /**
     * Métodos get e set.
     */
    public double getDesarme(){
        return this.desarme;
    }
    
    public void setDesarme(double desarme){
        this.desarme = desarme;
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
        habilidade += this.desarme*1;
        
        return habilidade;
    }
}
