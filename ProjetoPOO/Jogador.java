
/**
 * Características base de um jogador.
 *
 * @author grupo
 * @version 210330
 */
public class Jogador{
    private double velocidade;
    private double resistencia;
    private double destreza;
    private double implusao;
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
        this.implusao = 0;
        this.jogoCabeca = 0;
        this.remate = 0;
        this.capPasse = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public Jogador (double velocidade, double resistencia, double destreza, double implusao, double jogoCabeca, double remate, double capPasse){
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.implusao = implusao;
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
        this.implusao = umJog.getImplusao();
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

    public double getImplusao(){
        return this.implusao;
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

    public void setImplusao(double implusao){
        this.implusao = implusao;
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
    
    
}
