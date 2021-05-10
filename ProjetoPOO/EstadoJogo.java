
/**
 * Estado jogo.
 *
 * @author grupo
 * @version 210402
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class EstadoJogo{
    
    private LocalDateTime data;
    private Equipa equipaCasa;
    private Equipa equipaFora;
    private int scoreCasa;
    private int scoreFora;
    private Map<int,Jogador> jogadoresCasa;
    private ... substituicoesCasa;
    private Map<int,Jogador> jogadoresFora;
    private ... substituicoesFora;
    
    public EstadoJogo(){
        this.data = LocalDateTime.now();
        this.equipaCasa = new Equipa();
        this.equipaFora = new Equipa();
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new HashMap<>();
        this.substituicoesCasa = ...;
        this.jogadoresFora = new HashMap<>();
        this.substituicoesFora = ...;
    }
    
    public EstadoJogo(LocalDateTime data, Equipa equipaCasa, Equipa equipaFora, int scoreCasa, int scoreFora, 
                      Collection<Jogador> jogadoresCasa, ... substituicoesCasa, Collection<Jogador> jogadoresFora, ... substituicoesFora){
        this.data = data;
        this.equipaCasa = equipaCasa;
        this.equipaFora = equipaFora;
        this.scoreCasa = scoreCasa;
        this.scoreFora = scoreCasa;
        this.jogadoresCasa = new HashMap<>();
        for(Jogador jogC: jogadoresCasa)
            this.jogadoresCasa.put(jogC.getNumCamisola(), jogC.clone());
        this.substituicoesCasa = substituicoesCasa;
        this.jogadoresFora = new HashMap<>();
        for(Jogador jogF: jogadoresCasa)
            this.jogadoresFora.put(jogF.getNumCamisola(), jogF.clone());
        this.substituicoesFora = substituicoesFora;
    }
    
    public EstadoJogo(EstadoJogo estado){
        this.data = estado.getData();
        this.equipaCasa = estado.getEquipaCasa();
        this.equipaFora = estado.getEquipaFora();
        this.scoreCasa = estado.getScoreCasa();
        this.scoreFora = estado.jogScoreCasa();
        this.jogadoresCasa = estado.getJogadoresCasa();
        this.substituicoesCasa = estado.getSubstituicoesCasa();
        this.jogadoresFora = estado.getJogadoresFora();
        this.substituicoesFora = estado.getSubstituicoesFora();
    }
    
    /**
    * Método que muda o número da camisola do jogador.
    * @param o novo número da camisola
    */
    public LocalDateTime getData(){
        return this.data;
    }
    
    public Equipa getEquipaCasa(){
        return this.equipaCasa;
    }

    public Equipa getEquipaFora(){
        return this.equipaFora;
    }

    public int getScoreCasa(){
        return this.scoreCasa;
    }

    public int getScoreFora(){
        return this.scoreFora;
    }

    public Map<int,Jogador> getJogadoresCasa(){
        return this.jogadoresCasa.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }
    
    public ... getSubstituicoesCasa(){
        return this.substituicoesCasa;
    }
    
    public Map<int,Jogador> getJogadoresFora(){
        return this.jogadoresFora.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }

    public ... getSubstituicoesFora(){
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
    public void setJogadoresCasa(Map<int,Jogador> jogadoresCasa){
        this.jogadoresCasa = jogadoresCasa;
    }
    
    /**
    * Método que muda as substituições feitas em casa.
    * @param as novas substituições
    */
    public void setSubstituicoesCasa(...){
        this.substituicoesCasa = substituicoesCasa;
    }
    
    /**
    * Método que muda o conjunto de jogadores que joga fora.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresFora(Map<int,Jogador> jogadoresFora){
        this.jogadoresFora = jogadoresFora;
    }

    /**
    * Método que muda as substituições feitas fora.
    * @param as novas substituições
    */
    public void getSubstituicoesFora(...){
        this.substituicoesFora = substituicoesFora;
    }
}
