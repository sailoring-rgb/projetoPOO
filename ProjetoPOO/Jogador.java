
/**
 * Dados sobre um jogador.
 *
 * @author grupo
 * @version 210330
 */
public class Jogador{
   /*
    private static final int GUARDA_REDES = 0;
    private static final int DEFESA = 1;
    private static final int MEDIO = 2;
    private static final int AVANCADO = 3;
    private static final int LATERAL = 4;
   */
    private double velocidade;
    private double resistencia;
    private double destreza;
    private double impulsao;
    private double jogoCabeca;
    private double remate;
    private double capPasse;
    
    /**
     * Construtor por omissão.
     */
    public Jogador(){
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.jogoCabeca = 0;
        this.remate = 0;
        this.capPasse = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Jogador (double velocidade, double resistencia, double destreza, double impulsao, double jogoCabeca, double remate, double capPasse){
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.jogoCabeca = jogoCabeca;
        this.remate = remate;
        this.capPasse = capPasse;
    }
    
    /**
     * Construtor de cópia.
     */
    public Jogador(Jogador umJog){
        this.velocidade = umJog.getVelocidade();
        this.resistencia = umJog.getResistencia();
        this.destreza = umJog.getDestreza();
        this.impulsao = umJog.getImpulsao();
        this.jogoCabeca = umJog.getJogoCabeca();
        this.remate = umJog.getRemate();
        this.capPasse = umJog.getCapPasse();
    }
    
    
    /**
     * Métodos get e set.
     */
    public double getVelocidade(){
        return this.velocidade;
    }

    public double getResistencia(){
        return this.resistencia;
    }

    public double getDestreza(){
        return this.destreza;
    }

    public double getImpulsao(){
        return this.impulsao;
    }

    public double getJogoCabeca(){
        return this.jogoCabeca;
    }

    public double getRemate(){
        return this.remate;
    }

    public double getCapPasse(){
        return this.capPasse;
    }
    
    public void setVelocidade(double velocidade){
        this.velocidade = velocidade;
    }

    public void setResistencia(double resistencia){
        this.resistencia = resistencia;
    }

    public void setDestreza(double destreza){
        this.destreza = destreza;
    }

    public void setImpulsao(double impulsao){
        this.impulsao = impulsao;
    }

    public void setJogoCabeca(double jogoCabeca){
        this.jogoCabeca = jogoCabeca;
    }

    public void setRemate(double remate){
        this.remate = remate;
    }   

    public void setCapPasse(double capPasse){
        this.capPasse = capPasse;
    }
  
    /*
     * public int habGuardaRedes (Jogador umJog){
     */
    
    public double habDefesa (){
        double habilidade = 0;
        habilidade += this.velocidade*0.5;
        habilidade += this.resistencia*1;
        habilidade += this.destreza*0.5;
        habilidade += this.impulsao*1;
        habilidade += this.jogoCabeca*1;
        habilidade += this.remate*0.2;
        habilidade += this.capPasse*0.2;
        return habilidade;
    }
    
    public double habMedio (){
        double habilidade = 0;
        habilidade += this.velocidade*0.5;
        habilidade += this.resistencia*0.5;
        habilidade += this.destreza*1;
        habilidade += this.impulsao*0.5;
        habilidade += this.jogoCabeca*0.5;
        habilidade += this.remate*0.5;
        habilidade += this.capPasse*1;
        return habilidade;
    }
    
    public double habAvancado (){
        double habilidade = 0;
        habilidade += this.velocidade*1;
        habilidade += this.resistencia*0.5;
        habilidade += this.destreza*1;
        habilidade += this.impulsao*1;
        habilidade += this.jogoCabeca*1;
        habilidade += this.remate*1;
        habilidade += this.capPasse*0.5;
        return habilidade;
    }
    
    public double habLateral (){
        double habilidade = 0;
        habilidade += this.velocidade*1;
        habilidade += this.resistencia*0.5;
        habilidade += this.destreza*1;
        habilidade += this.impulsao*1;
        habilidade += this.jogoCabeca*0.5;
        habilidade += this.remate*0.5;
        habilidade += this.capPasse*1;
        return habilidade;
    }
}
