
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
    private Map<Integer,Integer> titulares;
    private Map<Integer, Integer> suplentes;
    
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
        this.titulares = new HashMap<Integer,Integer>();
        this.suplentes = new HashMap<Integer,Integer>();
    }
    
    public EstadoJogo(String nomeEquipaCasa, String nomeEquipaFora, Map<String, Equipa> equipas){
        this.data = LocalDate.now();
        this.equipaCasa = new Equipa(nomeEquipaCasa, equipas);
        this.equipaFora = new Equipa(nomeEquipaFora, equipas);
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new ArrayList<Integer>();
        this.jogadoresFora = new ArrayList<Integer>();
        this.substituicoesCasa = new HashMap<Integer,Integer>();
        this.substituicoesFora = new HashMap<Integer,Integer>();
        this.titulares = new HashMap<Integer,Integer>();
        this.suplentes = new HashMap<Integer,Integer>();
    }
    
    public EstadoJogo(LocalDate data, Equipa equipaCasa, Equipa equipaFora, int scoreCasa, int scoreFora, 
                      List<Integer> jogadoresCasa, List<Integer> jogadoresFora, Map<Integer, Integer> substituicoesCasa, Map<Integer, Integer> substituicoesFora,
                      Map<Integer,Integer> titulares, Map<Integer,Integer> suplentes){
        this.data = data;
        this.equipaCasa = equipaCasa;
        this.equipaFora = equipaFora;
        this.scoreCasa = scoreCasa;
        this.scoreFora = scoreCasa;
        this.jogadoresCasa = jogadoresCasa.stream().collect(Collectors.toList());
        this.jogadoresFora = jogadoresFora.stream().collect(Collectors.toList());
        this.substituicoesCasa.putAll(substituicoesCasa);
        this.substituicoesFora.putAll(substituicoesFora);
        this.titulares.putAll(titulares);
        this.suplentes.putAll(suplentes);
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
        this.titulares = estado.getTitulares();
        this.suplentes = estado.getSuplentes();
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
    * Método que obtém a lista de jogadores que joga em casa.
    * @return a lista de jogadores que joga em casa
    */
    public List<Integer> getJogadoresCasa(){
        return this.jogadoresCasa;
    }
    
    /**
    * Método que obtém um conjunto de pares das substituições que foram feitas em casa
    * @return um conjunto de pares das substituições que foram feitas em casa
    */
    public Map<Integer,Integer> getSubstituicoesCasa(){
        return this.substituicoesCasa;
    }
    
    /**
    * Método que obtém a lista de jogadores que joga fora.
    * @return a lista de jogadores que joga fora
    */
    public List<Integer> getJogadoresFora(){
        return this.jogadoresFora;
    }

    /**
    * Método que obtém um conjunto de pares das substituições que foram feitas fora
    * @return um conjunto de pares das substituições que foram feitas fora
    */
    public Map<Integer,Integer> getSubstituicoesFora(){
        return this.substituicoesFora;
    }
    
    /**
    * Método que obtém um conjunto de jogadores titulares
    * @return um conjunto de jogadores titulares
    */
    public Map<Integer,Integer> getTitulares(){
        return this.titulares;
    }
    
    /**
    * Método que obtém um conjunto de jogadores suplentes
    * @return um conjunto de jogadores suplenetes
    */
    public Map<Integer,Integer> getSuplentes(){
        return this.suplentes;
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
        this.jogadoresCasa = new ArrayList<>();
        for(Integer numCamisola : jogadoresCasa) {
            this.jogadoresCasa.add(numCamisola);
        }
    }
    
    /**
    * Método que muda as substituições feitas em casa.
    * @param as novas substituições
    */
    public void setSubstituicoesCasa(Map<Integer,Integer> substituicoesCasa){
        this.substituicoesCasa = substituicoesCasa.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
    * Método que muda o conjunto de jogadores que joga fora.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresFora(List<Integer> jogadoresFora){
        this.jogadoresFora = new ArrayList<>();
        for(Integer numCamisola : jogadoresFora) {
            this.jogadoresFora.add(numCamisola);
        }
    }

    /**
    * Método que muda as substituições feitas fora.
    * @param as novas substituições
    */
    public void setSubstituicoesFora(Map<Integer,Integer> substituicoesFora){
        this.substituicoesFora = substituicoesFora.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
    * Método que muda os titulares de uma equipa.
    * @param os novos titulares
    */
    public void setTitulares(Map<Integer,Integer> titulares){
        this.titulares = titulares.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }

    /**
    * Método que muda os suplentes de uma equipa.
    * @param os novos suplentes
    */
    public void setSuplentes(Map<Integer,Integer> suplentes){
        this.suplentes = suplentes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
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
     * posição 1 -> guardaRedes
     * posição 2 -> defesa central
     * posição 3 -> defesa lateral
     * posição 4 -> medio / medio centro
     * posição 5 -> extremos
     * posição 6 -> avancado / avançado centro
     * posicao 7 -> não existe no jogo, é suplente
    */
    public void criaTitularesSuplentes(Equipa equipa, int nr_tatica){
        int onzeT[] = taticaEsc(nr_tatica);
        
        this.titulares = new HashMap<Integer,Integer>();
        this.suplentes = new HashMap<Integer,Integer>();
        
        List<Jogador> avancados = new ArrayList<Jogador>();
        List<Jogador> medios = new ArrayList<Jogador>();
        List<Jogador> defesas = new ArrayList<Jogador>();
        List<Jogador> laterais = new ArrayList<Jogador>();
        List<Jogador> guardaRedes = new ArrayList<Jogador>();
        
        for(Jogador j: equipa.getJogadores().values()){
            int tipoJog = j.getTipoJogador();
            switch(tipoJog){
                case 1:
                    avancados.add(j);                
                case 2:
                    medios.add(j); 
                case 3:
                    laterais.add(j); 
                case 4:
                    defesas.add(j); 
                case 5:
                    guardaRedes.add(j); 
            }
        }
        
        if(onzeT[2] == 4){
            int nrAvancados = 0, nrMedios = 0, nrDefesas = 0, nrGuardaRedes = 0, nrLaterais = 0;
            
            for(Jogador j: avancados){ 
                if(nrAvancados < 2){
                    this.titulares.put(j.getNrCamisola(),6);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrAvancados++;
            }
            
            for(Jogador j: medios){ 
                if(nrMedios < 2){
                    this.titulares.put(j.getNrCamisola(),4);
                }
                if(nrMedios >= 2 && nrMedios < 4){
                    this.titulares.put(j.getNrCamisola(),7);
                }
                else{
                    this.suplentes.put(j.getNrCamisola(), 7);
                }
                nrMedios++;
            }
            
            for(Jogador j: defesas){ 
                if(nrDefesas < 2){
                    this.titulares.put(j.getNrCamisola(),2);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrDefesas++;
            }
            
            for(Jogador j: laterais){ 
                if(nrLaterais < 2){
                    this.titulares.put(j.getNrCamisola(),3);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrLaterais++;
            }
            
            for(Jogador j: guardaRedes){ 
                if(nrGuardaRedes < 1){
                    this.titulares.put(j.getNrCamisola(),1);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrGuardaRedes++;
            }
            
        }else{
            int nrAvancados = 0, nrMedios = 0, nrDefesas = 0, nrGuardaRedes = 0, nrLaterais = 0;
            
            for(Jogador j: avancados){ 
                if(nrAvancados < 2){
                    this.titulares.put(j.getNrCamisola(),5);
                }
                if(nrAvancados >= 2 && nrAvancados < 3){
                    this.titulares.put(j.getNrCamisola(), 6);
                }
                else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrAvancados++;
            }
            
            for(Jogador j: medios){ 
                if(nrMedios < 3){
                    this.titulares.put(j.getNrCamisola(),3);
                }else{
                    this.suplentes.put(j.getNrCamisola(), 7);
                }
                nrMedios++;
            }
            
            for(Jogador j: defesas){ 
                if(nrDefesas < 2){
                    this.titulares.put(j.getNrCamisola(),2);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrDefesas++;
            }
            
            for(Jogador j: laterais){ 
                if(nrLaterais < 2){
                    this.titulares.put(j.getNrCamisola(),3);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrLaterais++;
            }
            
            for(Jogador j: guardaRedes){ 
                if(nrGuardaRedes < 1){
                    this.titulares.put(j.getNrCamisola(),1);
                }else{
                    this.suplentes.put(j.getNrCamisola(),7);
                }
                nrGuardaRedes++;
            }
            
        
        }
    }
}

