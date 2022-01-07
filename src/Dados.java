import GestInfo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;
import java.util.Random;

/**
 * Classe do objeto cujo propósito é guardar toda a informação.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class Dados {
    private Map<String, Equipa> equipas; //nome, equipa
    private List<JogoRegisto> jogos;
    /**
     * Construtor por omissão
     */
    public Dados(){
        this.equipas = new HashMap<>(); //nome, equipa
        this.jogos = new ArrayList<>();
    }
    
    /**
     * Construtor de um objeto data com parametros
     * @param equipas todas as equipas presentes
     * @param jogos todo o registo de jogos
     */
    public Dados(Map<String, Equipa> equipas, List<JogoRegisto> jogos){
        this.equipas = equipas.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e-> e.getValue().clone()));
        this.jogos = jogos;
        this.jogos.sort(Comparator.comparing(JogoRegisto::getData));  
        Collections.reverse(this.jogos);
    }
    
    /**
    * Método que obtém todas as equipas.
    * @return as equipas
    */
    public Map<String, Equipa> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }
    
    /**
    * Método que obtém apenas uma equipa.
    * @param escEquipa o nome da equipa escolhida.
    * @return a equipa
    */
    public Equipa getEquipa(String escEquipa){
        return this.equipas.get(escEquipa).clone();
    }
    
    /**
    * Método que obtém todos os jogos da data.
    * @return uma lista de todos os jogos registados.
    */
    public List<JogoRegisto> getJogos(){
        return this.jogos;
    }
    
    /**
    * Método que muda as equipas no objeto
    * @param equipas as novas equipas
    */
    public void setEquipas(Map<String, Equipa> equipas){
        this.equipas = equipas.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    /**
    * Método que muda os jogos no objeto
    * @param jogos os novos jogos recebidos
    */
    public void setJogos(List<JogoRegisto> jogos){
       this.jogos = new ArrayList<>();
       for(JogoRegisto registo : jogos) {    
            this.jogos.add(registo);
       }
       this.jogos.sort(Comparator.comparing(JogoRegisto::getData));     
    }
    
    /**
    * Método que insere uma equipa na lista de equipas
    * @param equipa equipa que vai ser inserida
    */
    public void inserirEquipa(Equipa equipa){
        equipas.put(equipa.getNome(),equipa.clone());
    }
    
    /**
    * Método que insere um jogo na lista de registo de jogos e os ordena seguidamente.
    * @param jogo jogo que vai ser inserido
    */
    public void inserirJogo(EstadoJogo jogo){
        JogoRegisto jR = new JogoRegisto(jogo.getEquipaCasa().getNome(),jogo.getEquipaFora().getNome(),
                                         jogo.getScoreCasa(),jogo.getScoreFora(),jogo.getData(),
                                         jogo.getJogadoresCasa(),jogo.getSubstituicoesCasa(),
                                         jogo.getJogadoresFora(),jogo.getSubstituicoesFora());
        jogos.add(jR);
        this.jogos.sort(Comparator.comparing(JogoRegisto::getData)); 
        Collections.reverse(jogos);
    }
    
    /**
    * Método que apresenta uma lista de equipas do objeto.
    */
    public void apEquipas()
    {
        System.out.println("  Equipas:");
            for(var eq : equipas.entrySet()){
                System.out.println("    " + eq.getKey());
        }
    }
    
    /**
    * Método que apresenta o plantel de uma equipa.
    * @param escEquipa nome da equipa para apresentar
    */
    public void apPlantel(String escEquipa)
    {
        Equipa eq = equipas.get(escEquipa).clone();
        eq.apresentarPlantel();
    }
    
    /**
    * Método que apresenta um jogador de acordo com a sua equipa e número.
    * @param escEquipa nome da equipa
    * @param escJog o número do jogo a apresentar
    */
    public void apJogador(String escEquipa, int escJog)
    {
        Random rand = new Random();
        Equipa eq = equipas.get(escEquipa).clone();
        Jogador j = eq.getJogador(escJog).clone();
        
        switch(j.getTipoJogador()){
            case 1: Jogador jogAvancado = new Avancado(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                       j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((Avancado) j).getDrible(), j.getHistorico());
                    ((Avancado) jogAvancado).apresentarJogadorAvancado();
                    break;
            
            case 2:Jogador jogMedio = new Medio(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((Medio) j).getCapRecuperacao(), ((Medio) j).getImpulsao(), j.getHistorico());
                    ((Medio) jogMedio).apresentarJogadorMedio();
                    break;
            
            case 3:Jogador jogLateral = new Lateral(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                    j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((Lateral) j).getCapCruzamento(), j.getHistorico());
                    ((Lateral) jogLateral).apresentarJogadorLateral();
                    break;
            
            case 4:Jogador jogDefesa = new Defesa(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                               j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((Defesa) j).getDesarme(), j.getHistorico());
                    ((Defesa) jogDefesa).apresentarJogadorDefesa();
                    break;
            
            case 5:Jogador jogGuardaRedes = new GuardaRedes(j.getNome(), j.getNrCamisola(), j.getVelocidade(), j.getResistencia(), j.getDestreza(),
                                                            j.getImpulsao(), j.getJogoCabeca(), j.getRemate(), j.getCapPasse(), ((GuardaRedes) j).getElasticidade(), ((GuardaRedes) j).getLancamento(), j.getHistorico());
                    ((GuardaRedes) jogGuardaRedes).apresentarJogadorGR();
                    break;
        }
    }
    
    /**
    * Método que apresenta o registo de jogos presente no objeto.
    * @param pag a página atual do resgito de jogos
    */
    public void apJogos(int pag)
    {
        for(int i = pag*10; i < pag*10+10 && i < jogos.size(); i++) {
            JogoRegisto jogo = jogos.get(i);
            jogo.apresentarJogo();
        }
    }
    
    /**
    * Método que divide uma equipa em titulares e suplentes
    */
    public void divisao()
    {
        for(Equipa eq : equipas.values()){
            eq.criaTitularesSuplentes();
        }
    } 
}
