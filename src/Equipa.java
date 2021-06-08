 
/**
 * Dados sobre uma Equipa.
 *
 * @author grupo
 * @version 210402
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Equipa{

   private int nr_equipa;
   private int nr_tatica;
   private String nome;
   private Map<Integer, Jogador> jogadores; // numero de jogador, jogador
   
   /**
     * Construtor por omissão.
     */
   public Equipa(){
       this.nr_equipa = 0;
       this.nr_tatica = 0;
       this.nome = "";
       this.jogadores = new HashMap<>();
   }
   
   public Equipa(String nome){
       this.nr_equipa = 0;
       this.nr_tatica = 0;
       this.nome = nome;
       this.jogadores = new HashMap<>();
   }
   
   /**
     * Construtor parametrizado.
     */
   public Equipa(int nr_equipa,int nr_tatica,String nome, Map<Integer, Jogador> jogadores){
       this.nr_equipa = nr_equipa;
       this.nr_tatica = nr_tatica;
       this.nome = nome;
       this.jogadores = new HashMap<Integer, Jogador>(jogadores);
   }
   
   /**
     * Construtor de cópia.
     */
   public Equipa(Equipa umaEquipa){
       this.nr_equipa = umaEquipa.getNrEquipa();
       this.nr_tatica = umaEquipa.getNrTatica();
       this.nome = umaEquipa.getNome();
       this.jogadores = umaEquipa.getJogadores();
   }
   
   /**
    * Método que obtém o número da equipa.
    * @return o número da equipa
    */
   public int getNrEquipa(){
       return this.nr_equipa;
   }
   
   /**
    * Método que obtém o número da tática.
    * @return o número da tática
    */
   public int getNrTatica(){
       return this.nr_tatica;
   }
   
   /**
    * Método que obtém o nome da Equipa.
    * @return o nome da Equipa
    */
   public String getNome(){
       return this.nome;
   }
   
   /**
    * Método que obtém a lista de jogadores que são titulares.
    * @return a lista de titulares
    */
   public Map<Integer, Jogador> getJogadores(){
       return this.jogadores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
   }
   
   /**
    * Método que muda o número da equipa.
    * @param o novo número da equipa
    */
   public void setNrEquipa(int nr_equipa){
       this.nr_equipa = nr_equipa;
    }
    
    /**
    * Método que muda o número da tatica.
    * @param o novo número da equipa
    */
   public void setNrTatica(int nr_tatica){
       this.nr_tatica = nr_tatica;
    }
    
   /**
    * Método que muda o nome da Equipa.
    * @param o novo nome da Equipa
    */
   public void setNome(String nome){
       this.nome = nome;
    } 
   
   /**
    * Método que muda a lista de jogadores.
    * @param a nova lista de jogores
    */
   public void setJogadores(Map<Integer, Jogador> jogadores){
       this.jogadores = new HashMap<>();
       for(var jog : jogadores.entrySet()) {
            this.jogadores.put(jog.getKey(),jog.getValue());
       }
   }
   
   public Jogador getJogador(int escJog) {
        Jogador jog = jogadores.get(escJog);
        return jog; 
    }
   
   public void insereJogador(Jogador jog) {
        jogadores.put(jog.clone().getNrCamisola(),jog.clone());
    }

   public void removeJogador(Jogador jog) {
        jogadores.remove(jog.clone().getNrCamisola());
    }
      
   public int[] taticaEsc(int tacEscolhida)
    {
        //Isto é muito suboptimal mas não encontrei melhor maneira
        switch(tacEscolhida){
            case 0:
                return new int[]{1,2,4,2,2};
            case 1:
                return new int[]{1,2,3,4,1};
            case 2:
                return new int[]{1,2,2,4,2};
            case 3:
                return new int[]{1,3,4,2,1};
        }
        
        return new int[]{1,2,4,2,2}; 
    }
     
   public double habEquipa(Equipa umaEquipa){
       double habGlobal = 0; // como recorremos a um loop, temos de declarar a var fora e igualá-la a 0 (ao contrário dos outros métodos hab)
       
       Jogador jog = new Jogador();
       GuardaRedes jogGR = new GuardaRedes();
       Defesa jogDefesa = new Defesa();
       Medio jogMedio = new Medio();
       Avancado jogAvancado = new Avancado();
       Lateral jogLateral = new Lateral();
       
       Iterator iter = umaEquipa.getJogadores().entrySet().iterator(); 
       
       int onzeT[] = taticaEsc(nr_tatica);//para saber quantos de cada
       
       while(iter.hasNext()){
           habGlobal += jogGR.habGuardaRedes(jog)*onzeT[0] + jogDefesa.habDefesa(jog)*onzeT[1] + jogMedio.habMedio(jog)*onzeT[2] +
                               jogAvancado.habAvancado(jog)*onzeT[3] + jogLateral.habLateral(jog)*onzeT[4];
       }
       
       return habGlobal;
    }
    
   public Equipa clone(){
       return new Equipa(this);
   }
   
   public void apresentarPlantel(){   
        System.out.println("  Jogadores:");
            for (var jogador : jogadores.entrySet()) {
                System.out.println("        Número " + jogador.getKey() + " : " + jogador.getValue().getNome());
        }
    }
   
   public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
   }
    
    // FALTA AINDA:   
    // Definir número de cada tipo de jogador numa equipa
    // Definir os titulares e os suplentes
    // Definir as substituições a fazer
    // Método que muda um jogador de equipa
    // Método que constroi o historial de um jogador (as equipas por onde passou)

}
