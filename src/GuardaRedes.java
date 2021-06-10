
/**
 * Dados sobre um Jogador do tipo Guarda Redes.
 *
 * @author grupo 3
 * @version 210402
 */

import java.util.*;
import java.io.PrintWriter;
import java.util.Random;

public class GuardaRedes extends Jogador{
    
    private int elasticidade;
    private int lancamento;
    
    /**
     * Construtor por omissão.
     */
    public GuardaRedes(){
        super();
        this.elasticidade = 0;
        Random rand = new Random();
        this.lancamento = rand.nextInt(101);
    }
    
    /**
     * Construtor parametrizado.
     */
    public GuardaRedes(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse, int elasticidade, int lancamento, List<String> historico){
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
        this.lancamento = umJog.getLancamento();
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
    * Método que obtém o valor do lançamento do guarda-redes.
    * @return o valor do lançamento
    */
    public int getLancamento(){
        return this.lancamento;
    }
    
    /**
    * Método que muda o valor do lançamento do guarda-redes.
    * @param o novo valor do lançamento
    */
    public void setLancamento(int lancamento){
        this.lancamento = lancamento;
    }
    
    /**
    * Método que calcula a habilidade do guarda-redes.
    * @param umJog O jogador cuja habilidade será calculada
    * @return a habilidade do guarda-redes
    */
    public double habGuardaRedes (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*1 + umJog.getDestreza()*0.5 + umJog.getImpulsao()*1 +
                            umJog.getJogoCabeca()*0.5 + umJog.getRemate()*0.5 + umJog.getCapPasse()*0.5 + getElasticidade()*1 +
                            getLancamento()*1;
        return habilidade;
    }
    
    /**
    * Método que imprime a informação de um guarda redes, incluindo o seu histórico
    * (ou seja, as equipas onde já esteve).
    */
    public void apresentarJogadorGR(){
        System.out.println("Posição: Guarda-Redes");
        apresentarJogador();
        System.out.println("     Elasticidade: " + getElasticidade());
        System.out.println("     Lançamento: " + getLancamento());
        
        System.out.println("Habilidade geral:" + habGuardaRedes(this));
        
        apresentarHistorico();
    }
    
    /**
    * Método que preenche os campos de um objeto de tipo GuardaRedes (e dos seus campos)
    * com o conteúdo de uma string separado por vírgulas.
    */
    public static GuardaRedes parse(String input){
        Random rand = new Random();
        
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0],
                Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                rand.nextInt(101),
                new ArrayList<>());
    }
    
    public void saverGuardaRedes(PrintWriter print,Jogador umJog){
        print.print("Guarda-Redes:");
        saver(print);
        print.println(","+elasticidade);
        }
}
