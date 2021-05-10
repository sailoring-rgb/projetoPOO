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
        super();
        this.capCruzamento = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Lateral(String nome, int numCamisola, double velocidade, double resistencia, double destreza, double impulsao, 
                   double jogoCabeca, double remate, double capPasse, double capCruzamento){
        super(nome, numCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse);
        this.capCruzamento = capCruzamento;
    }
    
    /**
     * Construtor de cópia.
     */
    public Lateral(Lateral umJog){
        super(umJog);
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
        double habilidade = umJog.getVelocidade()*1 + umJog.getResistencia()*1 + umJog.getDestreza()*1 + umJog.getImpulsao()*0.5 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*1 + this.capCruzamento*1;
        return habilidade;
    }
}