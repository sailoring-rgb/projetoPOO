
/**
 * Estado jogo.
 *
 * @author grupo
 * @version 210402
 */

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class EstadoJogo{
    private LocalDateTime data;
    private Equipa equipaCasa;
    private Equipa equipaFora;
    private int scoreCasa;
    private int scoreFora;
    private Map<Integer,Jogador> jogadoresCasa;
    private List<SimpleEntry<Integer,Integer>> substituicoesCasa;
    private Map<Integer,Jogador> jogadoresFora;
    private List<SimpleEntry<Integer,Integer>> substituicoesFora;
    
    public EstadoJogo(){
        this.data = LocalDateTime.now();
        this.equipaCasa = new Equipa();
        this.equipaFora = new Equipa();
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new HashMap<>();
        this.substituicoesCasa = new ArrayList<SimpleEntry<Integer,Integer>>();
        this.jogadoresFora = new HashMap<>();
        this.substituicoesFora = new ArrayList<SimpleEntry<Integer,Integer>>();
    }
    
    public EstadoJogo(LocalDateTime data, Equipa equipaCasa, Equipa equipaFora, int scoreCasa, int scoreFora, 
                      Collection<Jogador> jogadoresCasa, List<SimpleEntry<Integer,Integer>> substituicoesCasa, Collection<Jogador> jogadoresFora, List<SimpleEntry<Integer,Integer>> substituicoesFora){
        this.data = data;
        this.equipaCasa = equipaCasa;
        this.equipaFora = equipaFora;
        this.scoreCasa = scoreCasa;
        this.scoreFora = scoreCasa;
        this.jogadoresCasa = new HashMap<>();
        for(Jogador jogC: jogadoresCasa)
            this.jogadoresCasa.put(jogC.getNrCamisola(), jogC.clone());
        this.substituicoesCasa = substituicoesCasa;
        this.jogadoresFora = new HashMap<>();
        for(Jogador jogF: jogadoresCasa)
            this.jogadoresFora.put(jogF.getNrCamisola(), jogF.clone());
        this.substituicoesFora = substituicoesFora;
    }
    
    public EstadoJogo(EstadoJogo estado){
        this.data = estado.getData();
        this.equipaCasa = estado.getEquipaCasa();
        this.equipaFora = estado.getEquipaFora();
        this.scoreCasa = estado.getScoreCasa();
        this.scoreFora = estado.getScoreFora();
        this.jogadoresCasa = estado.getJogadoresCasa();
        this.substituicoesCasa = estado.getSubstituicoesCasa();
        this.jogadoresFora = estado.getJogadoresFora();
        this.substituicoesFora = estado.getSubstituicoesFora();
    }
    
    /**
    * Método que obtém a data e instância do jogo.
    * @return a data e instância do jogo
    */
    public LocalDateTime getData(){
        return this.data;
    }
    
    /**
    * Método que obtém a equipa que joga em casa.
    * @return a equipa que joga em casa
    */
    public Equipa getEquipaCasa(){
        return this.equipaCasa;
    }

    /**
    * Método que obtém a equipa que joga fora.
    * @return a equipa que joga fora
    */
    public Equipa getEquipaFora(){
        return this.equipaFora;
    }

    /**
    * Método que obtém o score da equipa que joga em casa.
    * @return o score da equipa que joga em casa
    */
    public int getScoreCasa(){
        return this.scoreCasa;
    }

    /**
    * Método que obtém o score da equipa que joga fora.
    * @return o score da equipa que joga fora
    */
    public int getScoreFora(){
        return this.scoreFora;
    }

    /**
    * Método que obtém o conjunto de jogadores que joga em casa.
    * @return o conjunto de jogadores que joga em casa
    */
    public Map<Integer,Jogador> getJogadoresCasa(){
        return this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }
    
    /**
    * Método que obtém a lista de pares das substituições que foram feitas em casa
    * @return a lista de pares das substituições que foram feitas em casa
    */
    public List<SimpleEntry<Integer,Integer>> getSubstituicoesCasa(){
        return this.substituicoesCasa;
    }
    
    /**
    * Método que obtém o conjunto de jogadores que joga fora.
    * @return o conjunto de jogadores que joga fora
    */
    public Map<Integer,Jogador> getJogadoresFora(){
        return this.jogadoresFora.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }

    /**
    * Método que obtém a lista de pares das substituições que foram feitas fora
    * @return a lista de pares das substituições que foram feitas fora
    */
    public List<SimpleEntry<Integer,Integer>> getSubstituicoesFora(){
        return this.substituicoesFora;
    }
    
    /**
    * Método que muda a data e instância do jogo.
    * @param a nova data
    */
    public void setData(LocalDateTime data){
        this.data = data;
    }
    
    /**
    * Método que muda a equipa que joga em casa.
    * @param a nova equipa que joga em casa
    */
    public void setEquipaCasa(Equipa equipaCasa){
        this.equipaCasa = equipaCasa;
    }

    /**
    * Método que muda a equipa que joga fora.
    * @param a nova equipa que joga fora
    */
    public void setEquipaFora(Equipa equipaFora){
        this.equipaFora = equipaFora;
    }

    /**
    * Método que muda o score da equipa que joga em casa.
    * @param o novo score
    */
    public void setScoreCasa(int scoreCasa){
        this.scoreCasa = scoreCasa;
    }

    /**
    * Método que muda o score da equipa que joga fora.
    * @param o novo score
    */
    public void setScoreFora(int scoreFora){
        this.scoreFora = scoreFora;
    }

    /**
    * Método que muda o conjunto de jogadores que joga em casa.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresCasa(Map<Integer,Jogador> jogadoresCasa){
        this.jogadoresCasa = jogadoresCasa;
    }
    
    /**
    * Método que muda as substituições feitas em casa.
    * @param as novas substituições
    */
    public void setSubstituicoesCasa(List<SimpleEntry<Integer,Integer>> substituicoesCasa){
        this.substituicoesCasa = substituicoesCasa;
    }
    
    /**
    * Método que muda o conjunto de jogadores que joga fora.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresFora(Map<Integer,Jogador> jogadoresFora){
        this.jogadoresFora = jogadoresFora;
    }

    /**
    * Método que muda as substituições feitas fora.
    * @param as novas substituições
    */
    public void getSubstituicoesFora(List<SimpleEntry<Integer,Integer>> substituicoesFora){
        this.substituicoesFora = substituicoesFora;
    }
}
