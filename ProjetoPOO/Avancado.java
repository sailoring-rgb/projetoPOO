
/**
 * Dados sobre um Jogador do tipo Avançado.
 *
 * @author grupo
 * @version 210402
 */
public class Avancado extends Jogador{
    
    private double drible; // habilidade de evitar que adversio desarme o jogador que tem posse de bola
    
    /**
     * Construtor por omissão.
     */
    public Avancado(){
        this.drible = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Avancado(int drible){
        this.drible = drible;
    }
    
    /**
     * Construtor de cópia.
     */
    public Avancado(Avancado umJog){
        this.drible = umJog.getDrible();
    }
    
    /**
    * Método que obtém o valor da capacidade de drible do avançado.
    * @return o valor da capacidade de drible
    */
    public double getDrible(){
        return this.drible;
    }
    
    /**
    * Método que muda o valor da capacidade de drible do avançado.
    * @param o novo valor da capacidade de drible
    */
    public void setDrible(double drible){
        this.drible = drible;
    }
    
    /**
    * Método que calcula a habilidade do avançado.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do avançado
    */
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
