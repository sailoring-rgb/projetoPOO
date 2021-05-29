
/**
 * Dados sobre um Jogador do tipo Defesa.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class Defesa extends Jogador{
    
    private int desarme; // abordagem ao oponente, buscando obter a posse de bola
    
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
    public Defesa(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int desarme, List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse, historico, 4);
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
    public int getDesarme(){
        return this.desarme;
    }
    
    /**
    * Método que muda o valor da capacidade de desarme do defesa.
    * @param o novo valor da capacidade de desarme
    */
    public void setDesarme(int desarme){
        this.desarme = desarme;
    }
    
    /**
    * Método que calcula a habilidade do defesa.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do defesa
    */
    public double habDefesa (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*1 + umJog.getDestreza()*1 + umJog.getImpulsao()*1 +
                            umJog.getJogoCabeca()*1 + umJog.getRemate()*0.5 + umJog.getCapPasse()*0.5 + this.desarme*1;
        return habilidade;
    }
    
    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                10,new ArrayList<>());
    }
}
