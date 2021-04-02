
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

public class Equipa
{
   private int nr_equipa;
   private List<Jogador> equipa;
   
   /**
     * Construtor por omissão.
     */
   public Equipa(){
       this.nr_equipa = 0;
       this.equipa = new ArrayList<>();
   }
   
   /**
     * Construtor parametrizado.
     */
   public Equipa(int nr_equipa, List<Jogador> equipa){
       this.nr_equipa = nr_equipa;
       this.equipa = equipa.stream().map(Jogador::new).collect(Collectors.toList());
   }
   
   /**
     * Construtor de cópia.
     */
   public Equipa(Equipa umaEquipa){
       this.nr_equipa = umaEquipa.getNrEquipa();
       this.equipa = umaEquipa.getEquipa();
   }
   
   public int getNrEquipa(){
       return this.nr_equipa;
   }
   
   public List<Jogador> getEquipa(){
       return this.equipa;
   }
   
   public void setNrEquipa(int nr_equipa){
       this.nr_equipa = nr_equipa;
    }
    
   public void setEquipa(List<Jogador> equipa){
       this.equipa = equipa;
   }
  
   public double habEquipa(Equipa umaEquipa){
       double habGlobal = 0;
       for(Jogador j: this.equipa){
           //habGlobal += j.habGuardaRedes()*1;
           habGlobal += j.habDefesa()*4;
           habGlobal += j.habMedio()*3;
           habGlobal += j.habAvancado()*1;
           habGlobal += j.habLateral()*2;
       }
       return habGlobal;
    }
   
}
