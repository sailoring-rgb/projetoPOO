
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
    
    public LocalDateTime getData(){
        return this.data;
    }
    
    public Equipa getEquipaCasa(){
        return this.equipaCasa;
    }

    public List<Equipa> getEquipaFora(){
        return this.equipaFora;
    }

    public int getScoreCasa(){
        return this.scoreCasa;
    }

    public int getScoreFora(){
        return this.scoreFora;
    }

    public List<Jogador> getJogadoresCasa(){
        return this.jogadoresCasa;
    }
    
    public ... getSubstituicoesCasa(){
        return this.substituicoesCasa;
    }
    
    public List<Jogador> getJogadoresFora(){
        return this.jogadoresFora;
    }

    public ... getSubstituicoesFora(){
        return this.substituicoesFora;
    }
    
    public void setData(LocalDateTime data){
        this.data = data;
    }
    
    public void setEquipaCasa(Equipa equipaCasa){
        this.equipaCasa = equipaCasa;
    }

    public void setEquipaFora(Equipa equipaFora){
        this.equipaFora = equipaFora;
    }

    public void setScoreCasa(int scoreCasa){
        this.scoreCasa = scoreCasa;
    }

    public void setScoreFora(int scoreFora){
        this.scoreFora = scoreFora;
    }

    public void setJogadoresCasa(List<Jogador> jogadoresCasa){
        this.jogadoresCasa = jogadoresCasa;
    }
    
    public void setSubstituicoesCasa(...){
        this.substituicoesCasa = substituicoesCasa;
    }
    
    public void setJogadoresFora(List<Jogador> jogadoresFora){
        this.jogadoresFora = jogadoresFora;
    }

    public void getSubstituicoesFora(...){
        this.substituicoesFora = substituicoesFora;
    }
}
