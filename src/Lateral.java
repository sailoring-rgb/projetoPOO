
/**
 * Dados sobre um Jogador do tipo Lateral.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class Lateral extends Jogador{

    private int capCruzamento;
    
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
    public Lateral(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int capCruzamento, List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse,historico, 3);
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
    public int getCapCruzamento(){
        return this.capCruzamento;
    }
    
    /**
    * Método que muda o valor da capacidade de cruzamento do lateral.
    * @param o novo valor da capacidade de cruzamento
    */
    public void setCapCruzamento(int capCruzamento){
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
    
    public void apresentarJogadorLateral(){
        this.apresentarJogador();
        System.out.println("Cruzamento: " + capCruzamento);
        
        this.apresentarHistorico();
    }
    
    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),new ArrayList<>());
    }
}
