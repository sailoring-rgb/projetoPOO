 
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

public class Equipa{
    
   private int nr_equipa;
   private List<Jogador> titulares;
   private List<Jogador> suplentes;
   
   /**
     * Construtor por omissão.
     */
   public Equipa(){
       this.nr_equipa = 0;
       this.titulares = new ArrayList<>();
       this.suplentes = new ArrayList<>();
   }
   
   /**
     * Construtor parametrizado.
     */
   public Equipa(int nr_equipa, List<Jogador> titulares, List<Jogador> suplentes){
       this.nr_equipa = nr_equipa;
       this.titulares = titulares.stream().map(Jogador::new).collect(Collectors.toList());
       this.suplentes = suplentes.stream().map(Jogador::new).collect(Collectors.toList());
   }
   
   /**
     * Construtor de cópia.
     */
   public Equipa(Equipa umaEquipa){
       this.nr_equipa = umaEquipa.getNrEquipa();
       this.titulares = umaEquipa.getTitulares();
       this.suplentes = umaEquipa.getSuplentes();
   }
   
   /**
    * Método que obtém o número da equipa.
    * @return o número da equipa
    */
   public int getNrEquipa(){
       return this.nr_equipa;
   }
   
   /**
    * Método que obtém a lista de jogadores que são titulares.
    * @return a lista de titulares
    */
   public List<Jogador> getTitulares(){
       return this.titulares;
   }
   
   /**
    * Método que obtém a lista de jogadores que são suplentes.
    * @return a lista de suplentes
    */
   public List<Jogador> getSuplentes(){
       return this.suplentes;
   }
   
   /**
    * Método que muda o número da equipa.
    * @param o novo número da equipa
    */
   public void setNrEquipa(int nr_equipa){
       this.nr_equipa = nr_equipa;
    }
    
   /**
    * Método que muda a lista de jogadores que são titulares.
    * @param a nova lista de titulares
    */
   public void setTitulares(List<Jogador> titulares){
       this.titulares = titulares;
   }
   
   /**
    * Método que muda a lista de jogadores que são suplentes.
    * @param a nova lista de suplentes
    */
   public void setSuplentes(List<Jogador> suplentes){
       this.suplentes = suplentes;
   }
  
   /**public double habEquipa(Equipa umaEquipa){
       double habGlobal = 0;
       Jogador jogador;
       Avancado avancado;
       Lateral lateral;
       Medio medio;
       Defesa defesa;
       GuardaRedes guardaRedes;
       
       while(umaEquipa.getTitulares() != null){
           habGlobal += guardaRedes.habGuardaRedes(jogador)*1;
           habGlobal += defesa.habDefesa(jogador)*4;
           habGlobal += medio.habMedio(jogador)*3;
           habGlobal += avancado.habAvancado(jogador)*1;
           habGlobal += lateral.habLateral(jogador)*2;
       }
       return habGlobal;
    }
    */
    
    // FALTA AINDA:   
    // Definir número de cada tipo de jogador numa equipa
    // Definir os titulares e os suplentes
    // Definir as substituições a fazer
    // Método que muda um jogador de equipa
    // Método que constroi o historial de um jogador (as equipas por onde passou)

}
