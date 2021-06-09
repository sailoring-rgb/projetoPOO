
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

/**
 * Escreva a descrição da classe Data aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Data {
    private Map<String, Equipa> equipas; //nome, equipa
    private List<JogoRegisto> jogos;
    
    public Data(){
        this.equipas = new HashMap<>(); //nome, equipa
        this.jogos = new ArrayList<>();
    }
    
    public Data (Map<String, Equipa> equipas,List<JogoRegisto> jogos){
        this.equipas = equipas.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e-> e.getValue().clone()));
        this.jogos = jogos;
        this.jogos.sort(Comparator.comparing(JogoRegisto::getData));  
        Collections.reverse(this.jogos);
    }
    
    public Map<String, Equipa> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }
    
    public Equipa getEquipa(String escEquipa){
        return this.equipas.get(escEquipa);
    }
    
    public List<JogoRegisto> getJogos(){
        return this.jogos;
    }
    
    public void setEquipas(Map<String, Equipa> equipas){
        this.equipas = equipas.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    public void setJogos(List<JogoRegisto> jogos){
       this.jogos = new ArrayList<>();
       for(JogoRegisto registo : jogos) {    
            this.jogos.add(registo);
       }
       this.jogos.sort(Comparator.comparing(JogoRegisto::getData));     
    }
    
    public void inserirEquipa(Equipa equipa){
        equipas.put(equipa.getNome(),equipa);
    }
    
    public void inserirJogo(JogoRegisto jogo){
        //coisas e tal
    }
    
    public void apEquipas()
    {
        System.out.println("  Equipas:");
            for(var eq : equipas.entrySet()){
                System.out.println("    " + eq.getKey());
        }
    }
    
    public void apPlantel(String escEquipa)
    {
        Equipa eq = equipas.get(escEquipa);
        eq.apresentarPlantel();
    }
    
    public void apJogador(String escEquipa, int escJog)
    {
        Equipa eq = equipas.get(escEquipa);
        Jogador jog = eq.getJogador(escJog);
        switch(jog.getTipoJogador()){
            case 1:
            jog.apresentarJogador(); break;
            
            case 2:
            jog.apresentarJogador(); break;
            
            case 3:
            jog.apresentarJogador(); break;
            
            case 4:
            jog.apresentarJogador(); break;
            
            case 5:
            jog.apresentarJogador(); break;
        }
    }
    
    public void apJogos(int pag)
    {
        for(int i = pag*10; i < pag*10+10 && i < jogos.size(); i++) {
            JogoRegisto jogo = jogos.get(i);
            jogo.apresentarJogo();
        }
    }
}
