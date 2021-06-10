
/**
 * Dados sobre um Jogador do tipo Avançado.
 *
 * @author grupo 3
 * @version 210402
 */

import java.util.*;
import java.io.PrintWriter;

public class Avancado extends Jogador{
    
    private int drible;
    
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
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse, historico,1);
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
    * Método que obtém o valor do drible do avançado.
    * @return o valor do drible
    */
    public int getDrible(){
        return this.drible;
    }
    
    /**
    * Método que muda o valor do drible do avançado.
    * @param o novo valor do drible
    */
    public void setDrible(int drible){
        this.drible = drible;
    }
    
    /**
    * Método que calcula a habilidade do avançado.
    * @param o jogador cuja habilidade será calculada
    * @return a habilidade do avançado
    */
    public double habAvancado (Jogador umJog){
        double habilidade = umJog.getVelocidade()*0.5 + umJog.getResistencia()*0.5 + umJog.getDestreza()*1 + umJog.getImpulsao()*1 + 
                            umJog.getJogoCabeca()*1 + umJog.getRemate()*1 + umJog.getCapPasse()*0.5 + getDrible()*1;
        return habilidade;
    }
    
    /**
    * Método que imprime a informação de um avançado, incluindo o seu histórico
    * (ou seja, as equipas onde já esteve).
    */
    public void apresentarJogadorAvancado(){
        System.out.println("Posição: Avançado");
        apresentarJogador();
        System.out.println("Drible: " + getDrible());
        
        System.out.println("Habilidade geral:" + habAvancado(this));
        
        apresentarHistorico();
    }
    
    /**
    * Método que preenche os campos de um objeto de tipo Avancado (e dos seus campos)
    * com o conteúdo de uma string separado por vírgulas.
    */
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),1,
                new ArrayList<>());
    }
    
    public void saverAvancado(PrintWriter print,Jogador umJog){
        print.print("Avancado:");
        saver(print);
        }
}
