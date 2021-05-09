/**
 * Dados sobre um Jogador do tipo Defesa.
 *
 * @author grupo
 * @version 210402
 */

public class Defesa extends Jogador{
    
    private double desarme; // abordagem ao oponente, buscando obter a posse de bola
    
    /**
     * Construtor por omissão.
     */
    public Defesa(){
        super();
        this.desarme = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Defesa(String nome, int numCamisola, double velocidade, double resistencia, double destreza, double impulsao, 
                  double jogoCabeca, double remate, double capPasse, double desarme){
        super(nome, numCamisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse);
        this.desarme = desarme;
    }
    
    /**
     * Construtor de cópia.
     */
    public Defesa(Defesa umJog){
        super(umJog);
        this.desarme = umJog.getDesarme();
    }
    
    /**
    * Método que obtém o valor da capacidade de desarme do defesa.
    * @return o valor da capacidade de desarme
    */
    public double getDesarme(){
        return this.desarme;
    }
    
    /**
    * Método que muda o valor da capacidade de desarme do defesa.
    * @param o novo valor da capacidade de desarme
    */
    public void setDesarme(double desarme){
        this.desarme = desarme;
    }
    
    /**
    * Método que calcula a habilidade do defesa.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do defesa
    */
    public double habDefesa (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*1 + umJog.getDestreza()*0.5 + umJog.getImpulsao()*1 +
                            umJog.getJogoCabeca()*1 + umJog.getRemate()*0.2 + umJog.getCapPasse()*0.2 + this.desarme*1;
        return habilidade;
    }
}