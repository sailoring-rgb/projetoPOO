
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
import java.time.*;
import java.time.temporal.*;

public class EstadoJogo{
    private LocalDate data;
    private Equipa equipaCasa;
    private Equipa equipaFora;
    private int scoreCasa;
    private int scoreFora;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    private Map<Integer,Integer> substituicoesCasa;
    private Map<Integer,Integer> substituicoesFora;
    
    /**
     * Construtores da classe EstadoJogo.
     */
    
    public EstadoJogo(){
        this.data = LocalDate.now();
        this.equipaCasa = new Equipa();
        this.equipaFora = new Equipa();
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new ArrayList<Integer>();
        this.jogadoresFora = new ArrayList<Integer>();
        this.substituicoesCasa = new HashMap<Integer,Integer>();
        this.substituicoesFora = new HashMap<Integer,Integer>();
    }
    
    public EstadoJogo(String nomeEquipaCasa, String nomeEquipaFora){
        this.data = LocalDate.now();
        this.equipaCasa = new Equipa(nomeEquipaCasa);
        this.equipaFora = new Equipa(nomeEquipaFora);
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new ArrayList<Integer>();
        this.jogadoresFora = new ArrayList<Integer>();
        this.substituicoesCasa = new HashMap<Integer,Integer>();
        this.substituicoesFora = new HashMap<Integer,Integer>();
    }
    
    public EstadoJogo(LocalDate data, Equipa equipaCasa, Equipa equipaFora, int scoreCasa, int scoreFora, 
                      List<Integer> jogadoresCasa, List<Integer> jogadoresFora, Map<Integer, Integer> substituicoesCasa, Map<Integer, Integer> substituicoesFora){
        this.data = data;
        this.equipaCasa = equipaCasa;
        this.equipaFora = equipaFora;
        this.scoreCasa = scoreCasa;
        this.scoreFora = scoreCasa;
        this.jogadoresCasa = jogadoresCasa.stream().collect(Collectors.toList());
        this.jogadoresFora = jogadoresFora.stream().collect(Collectors.toList());
        this.substituicoesCasa.putAll(substituicoesCasa);
        this.substituicoesFora.putAll(substituicoesFora);
    }
   
    public EstadoJogo(EstadoJogo estado){
        this.data = estado.getData();
        this.equipaCasa = estado.getEquipaCasa();
        this.equipaFora = estado.getEquipaFora();
        this.scoreCasa = estado.getScoreCasa();
        this.scoreFora = estado.getScoreFora();
        this.jogadoresCasa = estado.getJogadoresCasa();
        this.jogadoresFora = estado.getJogadoresFora();
        this.substituicoesCasa = estado.getSubstituicoesCasa();
        this.substituicoesFora = estado.getSubstituicoesFora();
    }
    
    /**
    * Método que obtém a data e instância do jogo.
    * @return a data e instância do jogo
    */
    public LocalDate getData(){
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
    public List<Integer> getJogadoresCasa(){
        return this.jogadoresCasa;
    }
    
    /**
    * Método que obtém a lista de pares das substituições que foram feitas em casa
    * @return a lista de pares das substituições que foram feitas em casa
    */
    public Map<Integer,Integer> getSubstituicoesCasa(){
        return this.substituicoesCasa;
    }
    
    /**
    * Método que obtém o conjunto de jogadores que joga fora.
    * @return o conjunto de jogadores que joga fora
    */
    public List<Integer> getJogadoresFora(){
        return this.jogadoresFora;
    }

    /**
    * Método que obtém a lista de pares das substituições que foram feitas fora
    * @return a lista de pares das substituições que foram feitas fora
    */
    public Map<Integer,Integer> getSubstituicoesFora(){
        return this.substituicoesFora;
    }
    
    /**
    * Método que muda a data e instância do jogo.
    * @param a nova data
    */
    public void setData(LocalDate data){
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
    public void setJogadoresCasa(List<Integer> jogadoresCasa){
        this.jogadoresCasa = jogadoresCasa;
    }
    
    /**
    * Método que muda as substituições feitas em casa.
    * @param as novas substituições
    */
    public void setSubstituicoesCasa(Map<Integer,Integer> substituicoesCasa){
        this.substituicoesCasa = substituicoesCasa;
    }
    
    /**
    * Método que muda o conjunto de jogadores que joga fora.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresFora(List<Integer> jogadoresFora){
        this.jogadoresFora = jogadoresFora;
    }

    /**
    * Método que muda as substituições feitas fora.
    * @param as novas substituições
    */
    public void getSubstituicoesFora(Map<Integer,Integer> substituicoesFora){
        this.substituicoesFora = substituicoesFora;
    }
    
    /**
     * Método que define que equipa é que joga em casa e que equipa joga fora.
     * @param equipas - o conjunto de todas as equipas
     * @param nomeEquipaCasa - o nome da equipa selecionada para jogar em casa
     * @param nomeEquipaFora - o nome da equipa selecionada para jogar fora
     */
    public void equipasEmCampo(Map<String, Equipa> equipas, String nomeEquipaCasa, String nomeEquipaFora){
        if(equipas.containsKey(nomeEquipaCasa))
            this.equipaCasa = equipas.get(nomeEquipaCasa).clone();
            
        if(equipas.containsKey(nomeEquipaFora))
            this.equipaFora = equipas.get(nomeEquipaFora).clone();
    }
}

