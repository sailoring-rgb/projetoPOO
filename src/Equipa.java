 
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
import java.util.Random;

public class Equipa{

   private int nr_equipa;
   private int nr_tatica;
   private String nome;
   private Map<Integer, Jogador> jogadores; // numero de jogador, jogador
   private Map<Integer,Integer> titulares;
   private Map<Integer,Integer> suplentes;
   
   /**
     * Construtor por omissão.
     */
   public Equipa(){
       this.nr_equipa = 0;
       this.nr_tatica = 0;
       this.nome = "";
       this.jogadores = new HashMap<>();
       this.titulares = new HashMap<Integer,Integer>();
       this.suplentes = new HashMap<Integer,Integer>();
   }
   
   public Equipa(String nome){
       this.nr_equipa = 0;
       this.nr_tatica = 0;
       this.nome = nome;
       this.jogadores = new HashMap<>();
       this.titulares = new HashMap<Integer,Integer>();
       this.suplentes = new HashMap<Integer,Integer>();
   }
   
   public Equipa(String nome, Map<String, Equipa> equipas){
       this.nr_equipa = equipas.get(nome).getNrEquipa();
       this.nr_tatica = equipas.get(nome).getNrTatica();
       this.nome = nome;
       this.jogadores = new HashMap<>(equipas.get(nome).getJogadores());
       this.titulares = new HashMap<>(equipas.get(nome).getTitulares());
       this.suplentes = new HashMap<>(equipas.get(nome).getSuplentes());
   }
   
   /**
     * Construtor parametrizado.
     */
   public Equipa(int nr_equipa,int nr_tatica,String nome, Map<Integer, Jogador> jogadores, Map<Integer,Integer> titulares, Map<Integer,Integer> suplentes){
       this.nr_equipa = nr_equipa;
       this.nr_tatica = nr_tatica;
       this.nome = nome;
       this.jogadores = new HashMap<Integer, Jogador>(jogadores);
       this.titulares = titulares.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
       this.suplentes = suplentes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
   }
   
   /**
     * Construtor de cópia.
     */
   public Equipa(Equipa umaEquipa){
       this.nr_equipa = umaEquipa.getNrEquipa();
       this.nr_tatica = umaEquipa.getNrTatica();
       this.nome = umaEquipa.getNome();
       this.jogadores = umaEquipa.getJogadores();
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
    * Método que obtém um jogador pelo número da sua camisola.
    * @return o jogador com aquele número da camisola
    */
   public Jogador getJogador(int escJog) {
        Jogador jog = this.jogadores.get(escJog).clone();
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
   
   /**
     * Método que devolve a tática escolhida.
     * 
     * @param número da opção
     * @return tática escolhida
     */
    public int[] taticaEsc(int tacEscolhida)
    {
        switch(tacEscolhida){
            case 1:
                return new int[]{1,4,4,2};
            case 2:
                return new int[]{1,4,3,3};
        }
        return new int[]{1,4,4,2};
    } 

   /**
     * Método que cria, dependendo da tática selecionada, os conjuntos titulares e suplentes de uma equipa.
     * 
     * posição 1 -> guardaRedes
     * posição 2 -> defesa central
     * posição 3 -> defesa lateral
     * posição 4 -> medio / medio centro
     * posição 5 -> extremos
     * posição 6 -> avancado / avançado centro
     * posicao 7 -> não existe no jogo, é suplente
     * 
     * @param equipa cuja lista de suplentes queremos criar
     * @param número da tática
    */
    public void criaTitularesSuplentes(){ 
        int[] onzeT = taticaEsc(this.nr_tatica);
        
        List<Jogador> avancados = new ArrayList<Jogador>();
        List<Jogador> medios = new ArrayList<Jogador>();
        List<Jogador> defesas = new ArrayList<Jogador>();
        List<Jogador> laterais = new ArrayList<Jogador>();
        List<Jogador> guardaRedes = new ArrayList<Jogador>();
        
        adicionaJogPeloTipo(avancados, medios, defesas, laterais, guardaRedes);
        
        if(onzeT[2] == 4){
            
            paraPrimeiraTatica(avancados, medios, defesas, laterais, guardaRedes);
            
        }else{
            
            paraSegundaTatica(avancados, medios, defesas, laterais, guardaRedes);
            
        }
    }
    
    /**
     * Método que adiciona jogadores (de uma equipa) a uma lista do seu tipo.
     * 
     * Ou seja, se for um avançado, então este jogador será adicionada a uma lista de avançados.
     * 
     * @param equipa dos jogadores
     * @param lista de avançados (incialmente vazia) onde se adicionarão os avançados dessa equipa
     * @param lista de médios (incialmente vazia) onde se adicionarão os médios dessa equipa
     * @param lista de defesas (incialmente vazia) onde se adicionarão os defesas dessa equipa
     * @param lista de laterais (incialmente vazia) onde se adicionarão os laterais dessa equipa
     * @param lista de guarda redes (incialmente vazia) onde se adicionarão os guarda redes dessa equipa
     */
    public void adicionaJogPeloTipo(List<Jogador> avancados, List<Jogador> medios,         
                                    List<Jogador> defesas, List<Jogador> laterais, List<Jogador> guardaRedes){                           
        for(Jogador j: getJogadores().values()){
            int tipoJog = j.getTipoJogador();
            switch(tipoJog){
                case 1:
                    avancados.add(j.clone()); 
                    break;
                case 2:
                    medios.add(j.clone()); 
                    break;
                case 3:
                    laterais.add(j.clone()); 
                    break;
                case 4:
                    defesas.add(j.clone()); 
                    break;
                case 5:
                    guardaRedes.add(j.clone()); 
                    break;
            }
        }
    }
    
    /**
     * Método que, para a primeira tática, cria e adiciona, aos conjuntos titulares e suplentes (inicialmente vazios),
     * os titulares e os suplentes dessa equipa, respetivamente.
     * 
     * @param lista com os avançados dessa equipa
     * @param lista com os médios dessa equipa
     * @param lista com os defesas dessa equipa
     * @param lista com os laterais dessa equipa
     * @param lista com os guarda redes dessa equipa
     */
    public void paraPrimeiraTatica(List<Jogador> avancados, List<Jogador> medios,         
                                   List<Jogador> defesas, List<Jogador> laterais, List<Jogador> guardaRedes){
        int nrAvancados = 0, nrMedios = 0, nrDefesas = 0, nrGuardaRedes = 0, nrLaterais = 0;
        
        Map<Integer,Integer> titulares = new HashMap<Integer,Integer>();
        Map<Integer,Integer> suplentes = new HashMap<Integer,Integer>();
        
        for(Jogador j: avancados){ 
            if(nrAvancados < 2){
                    titulares.put(j.getNrCamisola(),6);
            }else{
                    suplentes.put(j.getNrCamisola(),7);
            }
            nrAvancados++;
        }
            
        for(Jogador j: medios){ 
            if(nrMedios < 2){
                titulares.put(j.getNrCamisola(),4);
            }
            else{
                if(nrMedios >= 2 && nrMedios < 4){
                 titulares.put(j.getNrCamisola(),5);
                }
                else{
                     suplentes.put(j.getNrCamisola(), 7);
                }
            }
            nrMedios++;
        }
            
        for(Jogador j: defesas){ 
            if(nrDefesas < 2){
                 titulares.put(j.getNrCamisola(),2);
            }else{
                 suplentes.put(j.getNrCamisola(),7);
            }
            nrDefesas++;
        }
            
        for(Jogador j: laterais){ 
            if(nrLaterais < 2){
                  titulares.put(j.getNrCamisola(),3);
            }else{
                  suplentes.put(j.getNrCamisola(),7);
            }
            nrLaterais++;
        }
            
        for(Jogador j: guardaRedes){ 
             if(nrGuardaRedes < 1){
                  titulares.put(j.getNrCamisola(),1);
             }else{
                  suplentes.put(j.getNrCamisola(),7);
             }
             nrGuardaRedes++;
        }
        
        setTitulares(titulares);
        setSuplentes(suplentes);
    }
    
    /**
     * Método que, para a segunda tática, cria e adiciona aos conjuntos titulares e suplentes (inicialmente vazios)
     * os titulares e os suplentes dessa equipa, respetivamente.
     * 
     * @param lista com os avançados dessa equipa
     * @param lista com os médios dessa equipa
     * @param lista com os defesas dessa equipa
     * @param lista com os laterais dessa equipa
     * @param lista com os guarda redes dessa equipa
     */
    public void paraSegundaTatica(List<Jogador> avancados, List<Jogador> medios,         
                                   List<Jogador> defesas, List<Jogador> laterais, List<Jogador> guardaRedes){
        int nrAvancados = 0, nrMedios = 0, nrDefesas = 0, nrGuardaRedes = 0, nrLaterais = 0;
        
        Map<Integer,Integer> titulares = new HashMap<Integer,Integer>();
        Map<Integer,Integer> suplentes = new HashMap<Integer,Integer>();
        
        for(Jogador j: avancados){ 
             if(nrAvancados < 2){
                  titulares.put(j.getNrCamisola(),5);
             }
             else
             {
                 if(nrAvancados >= 2 && nrAvancados < 3){
                     titulares.put(j.getNrCamisola(), 6);
                 }
                 else{
                     suplentes.put(j.getNrCamisola(),7);
                 }
            }
             nrAvancados++;
        }
            
        for(Jogador j: medios){ 
             if(nrMedios < 3){
                  titulares.put(j.getNrCamisola(),4);
             }else{
                  suplentes.put(j.getNrCamisola(), 7);
             }
             nrMedios++;
        }
            
        for(Jogador j: defesas){ 
             if(nrDefesas < 2){
                  titulares.put(j.getNrCamisola(),2);
             }else{
                  suplentes.put(j.getNrCamisola(),7);
             }
             nrDefesas++;
        }
            
        for(Jogador j: laterais){ 
             if(nrLaterais < 2){
                  titulares.put(j.getNrCamisola(),3);
             }else{
                  suplentes.put(j.getNrCamisola(),7);
             }
             nrLaterais++;
        }
            
        for(Jogador j: guardaRedes){ 
            if(nrGuardaRedes < 1){
                titulares.put(j.getNrCamisola(),1);
            }else{
                suplentes.put(j.getNrCamisola(),7);
            }
            nrGuardaRedes++;
        }
        
        setTitulares(titulares);
        setSuplentes(suplentes);
   }
    
   /**
    * Método que calcula a habilidade total de uma equipa.
    * 
    * Será percorrido o map de jogadores de uma equipa e, dependendo do tipo do jogador,
    * as habilidades de cada jogador (titular) serão somadas.
    * 
    * @param conjuntos dos titulares da equipa
    * @param a equipa cuja habilidade será calculada
    * @return a habilidade total da equipa
    */
   public double habEquipa(Map<Integer,Integer> titulares){
       double habGlobal = 0;  
       
       for(Jogador j: this.getJogadores().values()){
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
    
   public void troca(EstadoJogo estado, int nrCamisolaTit, int nrCamisolaSup, String nomeEquipa){
       int posTit = this.titulares.get(nrCamisolaTit); //guarda a posição do jogador titular
       this.titulares.remove(nrCamisolaTit);
       this.titulares.put(nrCamisolaSup, posTit);
       this.suplentes.remove(nrCamisolaSup);
       this.suplentes.put(nrCamisolaTit, 7);       
       String equipaCasa = estado.getEquipaCasa().getNome();
       if(nomeEquipa.equals(equipaCasa)){
           estado.getSubstituicoesCasa().putIfAbsent(nrCamisolaTit,nrCamisolaSup);
           estado.setNrSubstituicoesCasa(estado.getNrSubstituicoesCasa()+1);
       }
       else{
           estado.getSubstituicoesFora().putIfAbsent(nrCamisolaTit, nrCamisolaSup); 
           estado.setNrSubstituicoesFora(estado.getNrSubstituicoesFora()+1);
       }
   }
   
   public void substituirDentroEquipa(EstadoJogo estado, int nrCamisolaTit, int nrCamisolaSup, String nomeEquipa) throws JogadorNaoExisteException, SubstituicaoNaoValidaException, SubstituicaoNaoPermitidaException{
      if(!this.titulares.containsKey(nrCamisolaTit) && !this.suplentes.containsKey(nrCamisolaSup)){
        throw new JogadorNaoExisteException("titular e jogador suplente não existem");
      }
      
      if(!this.titulares.containsKey(nrCamisolaTit)){
          throw new JogadorNaoExisteException("titular não existe");
      }
      
      if(!this.suplentes.containsKey(nrCamisolaSup)){
          throw new JogadorNaoExisteException("suplente não existe");
      }
      
      Jogador jogSup = this.jogadores.get(nrCamisolaSup);
      int tipoJog = jogSup.getTipoJogador();
        
      int posTitular = this.titulares.get(nrCamisolaTit);
        
      switch(tipoJog){
        case 1: //Avancado
            if(posTitular == 5 || posTitular == 6){
                
                if(estado.getEquipaCasa().getNome().equals(nomeEquipa)){
                    if(estado.getNrSubstituicoesCasa() > 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                else {
                    if(estado.getNrSubstituicoesFora() > 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                
            }
            else throw new SubstituicaoNaoValidaException();
            break;
                
        case 2: //Medio
            if(posTitular == 4 || posTitular == 5){
                
                if(estado.getEquipaCasa().getNome().equals(nomeEquipa)){
                    if(estado.getNrSubstituicoesCasa() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                else {
                    if(estado.getNrSubstituicoesFora() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                
            }
            else throw new SubstituicaoNaoValidaException();
            break;
                
        case 3: //Lateral
            if(posTitular == 3 || posTitular == 5){
                
                if(estado.getEquipaCasa().getNome().equals(nomeEquipa)){
                    if(estado.getNrSubstituicoesCasa() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                else {
                    if(estado.getNrSubstituicoesFora() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
            }
            else throw new SubstituicaoNaoValidaException();
            break;
                
        case 4: // Defesa
            if(posTitular == 2 || posTitular == 6){
                
                if(estado.getEquipaCasa().getNome().equals(nomeEquipa)){
                    if(estado.getNrSubstituicoesCasa() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                else {
                    if(estado.getNrSubstituicoesFora() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
            }
            else throw new SubstituicaoNaoValidaException();
            break;
                
        case 5: //GuardaRedes
            if(posTitular == 1){
                
                if(estado.getEquipaCasa().getNome().equals(nomeEquipa)){
                    if(estado.getNrSubstituicoesCasa() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
                else {
                    if(estado.getNrSubstituicoesFora() >= 3){
                        throw new SubstituicaoNaoPermitidaException(nomeEquipa);
                    }
                    troca(estado, nrCamisolaTit, nrCamisolaSup, nomeEquipa);
                }
            }
            else throw new SubstituicaoNaoValidaException();
            break;
      }
   } 
   
   /**
    * Método que imprime o plantel de jogadores de uma equipa,
    * cada um identificado pelo número da sua camisola.
    */
   public void apresentarPlantel(){   
        System.out.println("  Jogadores:");
        for (var jogador : jogadores.entrySet()) {
            System.out.println("        Número " + jogador.getKey() + " : " + jogador.getValue().getNome());
        }
        apresentarTitulares();
        
        System.out.println("  Habilidade: " + habEquipa(titulares));
   }
   
   /**
    * Método que imprime os titulares de uma equipa,
    * cada um identificado pelo número da sua camisola.
    */
   public void apresentarTitulares(){   
        System.out.println("\n");
        System.out.println("Jogadores Titulares:");
        System.out.println("    Tipos: 1 - Avancado, 2 - Medio, 3 - Lateral, 4 - Defesa, 5 - Guarda-Redes\n");
        
        for (Jogador jog : this.jogadores.values()) {
            int numr = jog.getNrCamisola();
            String nome = jog.getNome();
            if(this.titulares.containsKey(numr)){
                System.out.println("    (Tipo "+jog.getTipoJogador() + ") Número " + numr + " : " + nome);
            }
        }
   }
   
   /**
    * Método que imprime os suplentes de uma equipa,
    * cada um identificado pelo número da sua camisola.
    */
   public void apresentarSuplentes(){  
        System.out.println("\n");
        System.out.println("Jogadores Suplentes:");
        System.out.println("    Tipos: 1 - Avancado, 2 - Medio, 3 - Lateral, 4 - Defesa, 5 - Guarda-Redes\n");
        
        for (Jogador jog : this.jogadores.values()) {
            int numr = jog.getNrCamisola();
            String nome = jog.getNome();
            if(this.suplentes.containsKey(numr)){
                System.out.println("    (Tipo "+jog.getTipoJogador() + ") Número " + numr + " : " + nome);
            }
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
        print.println("Equipa:"+ this.nome);
        
         for (Jogador j : jogadores.values()) {
            int tipo = j.getTipoJogador();
            Random rand = new Random();
            
            switch(tipo){
                case 1:
                    Jogador jogAvancado = new Avancado(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((Avancado) j).getDrible(), j.getHistorico());
                    ((Avancado) jogAvancado).saverAvancado(print,j);
                    break;
                case 2:
                    Jogador jogMedio = new Medio(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((Medio) j).getCapRecuperacao(), ((Medio) j).getImpulsao(), j.getHistorico());
                    ((Medio) jogMedio).saverMedio(print,j);
                    break;
                case 3:
                    Jogador jogLateral = new Lateral(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(),  ((Lateral) j).getCapCruzamento(), j.getHistorico());
                    ((Lateral) jogLateral).saverLateral(print,j);
                    break;
                case 4:
                    Jogador jogDefesa = new Defesa(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(),  ((Defesa) j).getDesarme(), j.getHistorico());
                    ((Defesa) jogDefesa).saverDefesa(print,j);
                    break;
                case 5:
                    Jogador jogGuardaRedes = new GuardaRedes(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                  j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((GuardaRedes) j).getElasticidade(), ((GuardaRedes) j).getLancamento(), j.getHistorico());
                    ((GuardaRedes) jogGuardaRedes).saverGuardaRedes(print,j);
                    break;
            }
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
