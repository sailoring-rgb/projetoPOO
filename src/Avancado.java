
/**
 * Dados sobre um Jogador do tipo Avançado.
 *
 * @author grupo 3
 * @version 210402
 */

import java.util.*;
import java.io.PrintWriter;

public class Avancado extends Jogador{
    /**
     * Construtor por omissão.
     */
    public Avancado(){
        super();
    }
    
    /**
     * Construtor parametrizado.
     */
    public Avancado(String nome, int nr_camisola, int velocidade, int resistencia, int destreza, int impulsao, int jogoCabeca, int remate, int capPasse,List<String> historico){
        super(nome, nr_camisola, velocidade, resistencia, destreza, impulsao, jogoCabeca, remate, capPasse, historico,1);
    }
    
    /**
     * Construtor de cópia.
     */
    public Avancado(Avancado umJog){
        super(umJog);
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
                Integer.parseInt(campos[8]),
                new ArrayList<>());
    }
    
    public void saverAvancado(PrintWriter print,Jogador umJog){
        print.print("Avancado:");
        saver(print);
        }
}
