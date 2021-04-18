
/**
 * Dados sobre um Jogador do tipo Médio.
 *
 * @author grupo
 * @version 210402
 */
public class Medio extends Jogador{
   
    private double capRecuperacao;
    private double dominioBola; // habilidade de reter uma bola em condições de realizar uma jogada
    
    public Medio(){
        this.capRecuperacao = 0;
    }
    
    public Medio(int capRecuperacao){
        this.capRecuperacao = capRecuperacao;
    }
    
    public Medio(Medio umJog){
        this.capRecuperacao = umJog.getCapRecuperacao();
    }
    
     /**
     * Métodos get e set.
     */
    public double getCapRecuperacao(){
        return this.capRecuperacao;
    }
    
    public void setCapRecuperacao(double capRecuperacao){
        this.capRecuperacao = capRecuperacao;
    }
    
    public double habMedio (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*0.5;
        habilidade += umJog.getResistencia()*0.5;
        habilidade += umJog.getDestreza()*1;
        habilidade += umJog.getImpulsao()*0.5;
        habilidade += umJog.getJogoCabeca()*0.5;
        habilidade += umJog.getRemate()*0.5;
        habilidade += umJog.getCapPasse()*1;
        habilidade += this.capRecuperacao*1;
        
        return habilidade;
    }
}
