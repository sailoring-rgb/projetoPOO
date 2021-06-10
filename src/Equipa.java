 
/**
 * Dados sobre uma Equipa.
 *
 * @author grupo 3
 * @version 210402
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.*;

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
   
   public Equipa(String nome, Map<String, Equipa> equipas){
       this.nr_equipa = 0;
       this.nr_tatica = 0;
       this.nome = nome;
       this.jogadores = new HashMap<>(equipas.get(nome).getJogadores());
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
    * Método que obtém o conjunto de jogadores.
    * @return conjunto de jogadores
    */
   public Map<Integer, Jogador> getJogadores(){
       return this.jogadores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
   }
   
   /**
    * Método que obtém a lista de jogadores que são titulares.
    * @return a lista de titulares
    */
   public List<Jogador> getJogadoresList(){
        return this.jogadores.values().stream().map(Jogador::clone).collect(Collectors.toList());
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
    * Método que muda o conjunto de jogadores.
    * @param o novo conjunto de jogores
    */
   public void setJogadores(Map<Integer, Jogador> jogadores){
       this.jogadores = new HashMap<>();
       for(var jog : jogadores.entrySet()) {
            this.jogadores.put(jog.getKey(),jog.getValue());
       }
   }
   
   /**
    * Método que obtém um jogador pelo número da sua camisola.
    * @return o jogador com aquele número da camisola
    */
   public Jogador getJogador(int escJog) {
        Jogador jog = jogadores.get(escJog);
        return jog; 
    }
   
   /**
    * Método que insere um jogador no conjunto de jogadores.
    * @param o novo jogador a inserir
    */
   public void insereJogador(Jogador jog) {
        jogadores.put(jog.clone().getNrCamisola(),jog.clone());
    }

   /**
    * Método que remove um jogador dum conjunto de jogadores.
    * @param o jogador a remover
    */
   public void removeJogador(Jogador jog) {
        jogadores.remove(jog.clone().getNrCamisola());
    }
      
   public int[] taticaEsc(int tacEscolhida)
    {
        //Isto é muito suboptimal mas não encontrei melhor maneira
        switch(tacEscolhida){
            case 0:
                return new int[]{1,4,4,2};
            case 1:
                return new int[]{1,4,3,3};
        }
        
        return new int[]{1,2,4,2,2}; 
    }
   
   /**
    * Método que calcula a habilidade total de uma equipa.
    * 
    * Será percorrido o map de jogadores e, dependendo do tipo do jogador e da quantidade de
    * cada posição (defesa, lateral, médio, avançado, guarda-redes), as habilidades de cada jogador serão somadas.
    * 
    * @param a equipa cuja habilidade será calculada
    * @return a habilidade total da equipa
    */
   public double habEquipa(Map <Integer,Integer> titulares, Equipa equipa){
       double habGlobal = 0;  
       
       for(Jogador j: equipa.getJogadores().values()){
           int nrCamisola = j.getNrCamisola();
           if(titulares.containsKey(nrCamisola)){
               int tipoJog = j.getTipoJogador();
               switch(tipoJog){
                   case 1:
                       Jogador jog = new Avancado(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), 90, j.getHistorico());
                       habGlobal += ((Avancado) jog).habAvancado(j);
                       break;
                   
                   case 2:
                       Jogador jog1 = new Medio(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), 90, 90, j.getHistorico());
                       habGlobal += ((Medio) jog1).habMedio(j);
                       break;
                   
                   case 3:
                       Jogador jog2 = new Lateral(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), 90, j.getHistorico());
                       habGlobal += ((Lateral) jog2).habLateral(j);
                       break;
                       
                   case 4:
                       Jogador jog3 = new Defesa(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), 90, j.getHistorico());
                       habGlobal += ((Defesa) jog3).habDefesa(j);
                       break;
                       
                   case 5:
                       Jogador jog4 = new GuardaRedes(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), 90, 90, j.getHistorico());
                       habGlobal += ((GuardaRedes) jog4).habGuardaRedes(j);
                       break;
                   
               }
           }
        
       }
       
       return habGlobal;
    }
    
/**
    * Método que imprime o plantel de jogadores, cada um identificado pelo número da sua camisola.
    */
   public void apresentarPlantel(){   
        System.out.println("  Jogadores:");
        for (var jogador : jogadores.entrySet()) {
            System.out.println("        Número " + jogador.getKey() + " : " + jogador.getValue().getNome());
        }
   }
   
   /**
    * Método que preenche os campos de um objeto de tipo Equipa (e dos seus campos)
    * com o conteúdo de uma string separado por vírgulas.
    */
   public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
   }

   /**
    * Método que guarda um objeto de tipo Equipa.
    */
   public void saver(PrintWriter print){
        print.println("Equipa:"+ nome);
            
        for (var jogador : jogadores.entrySet()) {
            jogador.getValue().saver(print);
        }
   }
   
   /**
    * Método que faz o clone de um objeto de tipo Equipa.
    */
   public Equipa clone(){
       return new Equipa(this);
   }
   
   /**
    * Método que reescreve o equals de um objeto de tipo Equipa.
    */
   public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || ! obj.getClass().equals(this.getClass())) return false;
        Equipa equipa = (Equipa) obj;
        return this.nr_equipa == equipa.getNrEquipa() &&
            this.nr_tatica == equipa.getNrTatica() &&
            this.nome.equals(equipa.getNome()) &&
            this.jogadores.equals(equipa.getJogadores());
    }
}
