
/**
 * Dados sobre um Jogador do tipo Médio.
 *
 * @author grupo
 * @version 210402
 */
public class Medio extends Jogador{
   
    private double capRecuperacao;
    private double dominioBola; // habilidade de reter uma bola em condições de realizar uma jogada
    
    /**
     * Construtor por omissão.
     */
    public Medio(){
        this.capRecuperacao = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Medio(int capRecuperacao){
        this.capRecuperacao = capRecuperacao;
    }
    
    /**
     * Construtor de cópia.
     */
    public Medio(Medio umJog){
        this.capRecuperacao = umJog.getCapRecuperacao();
    }
    
    /**
    * Método que obtém o valor da capacidade de recuperação da bola do médio.
    * @return o valor da capacidade de recuperação da bola
    */
    public double getCapRecuperacao(){
        return this.capRecuperacao;
    }
    
        /**
    * Método que obtém o valor da capacidade de domínio da bola do médio.
    * @return o valor da capacidade de domínio da bola
    */
    public double getDominioBola(){
        return this.dominioBola;
    }
    
    /**
    * Método que muda o valor da capacidade de recuperação da bola do médio.
    * @param o novo valor da capacidade de recuperação da bola
    */
    public void setCapRecuperacao(double capRecuperacao){
        this.capRecuperacao = capRecuperacao;
    }

    /**
    * Método que muda o valor da capacidade de domínio da bola do médio.
    * @param o novo valor da capacidade de domínio da bola
    */
    public void setDominioBola(double dominioBola){
        this.dominioBola = dominioBola;
    }    
    
    /**
    * Método que calcula a habilidade do médio.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do médio
    */
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
        habilidade += this.dominioBola*1;
        
        return habilidade;
    }
}
