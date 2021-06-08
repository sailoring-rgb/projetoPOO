
/**
 * Dados sobre um Jogador do tipo Avançado.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class Avancado extends Jogador{
    
    private int drible; // habilidade de evitar que adversio desarme o jogador que tem posse de bola
    
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
    public Avancado(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int drible,List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse, historico, 1);
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
    public int getDrible(){
        return this.drible;
    }
    
    /**
    * Método que muda o valor da capacidade de drible do avançado.
    * @param o novo valor da capacidade de drible
    */
    public void setDrible(int drible){
        this.drible = drible;
    }
    
    /**
    * Método que calcula a habilidade do avançado.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do avançado
    */
    public double habAvancado (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*0.5 + umJog.getDestreza()*1 + umJog.getImpulsao()*1 + 
                            umJog.getJogoCabeca()*1 + umJog.getRemate()*1 + umJog.getCapPasse()*0.5 + this.drible*1;
        // isto diminui (imenso) os acessos à memória
        return habilidade;
    }
    
    public void apresentarJogadorAvancado(){
        System.out.println("Posição: Avançado");
        apresentarJogador();
        
        apresentarHistorico();
    }
    
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                50,new ArrayList<>());
    }
}
