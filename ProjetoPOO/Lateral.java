
/**
 * Dados sobre um Jogador do tipo Lateral.
 *
 * @author grupo
 * @version 210402
 */
public class Lateral extends Jogador{

    private double capCruzamento;
    
    /**
     * Construtor por omissão.
     */
    public Lateral(){
        this.capCruzamento = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Lateral(int capCruzamento){
        this.capCruzamento = capCruzamento;
    }
    
    /**
     * Construtor de cópia.
     */
    public Lateral(Lateral umJog){
        this.capCruzamento = umJog.getCapCruzamento();
    }
    
    /**
    * Método que obtém o valor da capacidade de cruzamento do lateral.
    * @return o valor da capacidade de cruzamento
    */
    public double getCapCruzamento(){
        return this.capCruzamento;
    }
    
    /**
    * Método que muda o valor da capacidade de cruzamento do lateral.
    * @param o novo valor da capacidade de cruzamento
    */
    public void setCapCruzamento(double capCruzamento){
        this.capCruzamento = capCruzamento;
    }
    
    /**
    * Método que calcula a habilidade do lateral.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do lateral
    */
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
