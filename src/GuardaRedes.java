
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;

public class GuardaRedes extends Jogador{
    
    private int elasticidade;
    private int lancamento; // ato de lançar a bola para um companheiro distante consoante a distância a que está dele.
    
    /**
     * Construtor por omissão.
     */
    public GuardaRedes(){
        super();
        this.elasticidade = 0;
        this.lancamento = 0;
    }
    
    /**
     * Construtor parametrizado.
     */
    public GuardaRedes(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int elasticidade,List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse,historico, 5);
        this.elasticidade = elasticidade;
        this.lancamento = lancamento;
    }
    
    /**
     * Construtor de cópia.
     */
    public GuardaRedes(GuardaRedes umJog){
        super(umJog);
        this.elasticidade = umJog.getElasticidade();
    }
    
    /**
    * Método que obtém o valor da elasticidade do guarda-redes.
    * @return o valor da elasticidade
    */
    public int getElasticidade(){
        return this.elasticidade;
    }
    
    /**
    * Método que muda o valor da elasticidade do guarda-redes.
    * @param o novo valor da elasticidade
    */
    public void setElasticidade(int elasticidade){
        this.elasticidade = elasticidade;
    }
    
    
    /**
    * Método que calcula a habilidade do guarda-redes.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do guarda-redes
    */
    public double habGuardaRedes (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*1 + umJog.getDestreza()*0.5 + umJog.getImpulsao()*1 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*0.5 + this.elasticidade*1 +
                            this.lancamento*1;
        return habilidade;
    }
    
    public void apresentarJogadorLateral(){
        this.apresentarJogador();
        System.out.println("Elasticidade: " + elasticidade);
        
        this.apresentarHistorico();
    }
    
    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                new ArrayList<>());
    }
}
