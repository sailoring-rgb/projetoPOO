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
        super();
        this.drible = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Avancado(String nome, int numCamisola, double velocidade, double resistencia, double destreza, 
                    double impulsao, double jogoCabeca, double remate, double capPasse, int drible){
        super(nome, numCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse);
        this.drible = drible;
    }
    
    /**
     * Construtor de cópia.
     */
    public Avancado(Avancado umJog){
        super(umJog);
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
        double habilidade = umJog.getVelocidade()*1 + umJog.getResistencia()*0.5 + umJog.getDestreza()*1 + umJog.getImpulsao()*1 + 
                            umJog.getJogoCabeca()*1 + umJog.getRemate()*1 + umJog.getCapPasse()*0.5 + this.drible*1;
        // isto diminui (imenso) os acessos à memória
        return habilidade;
    }
}