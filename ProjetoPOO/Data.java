
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

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
    }
    
    public Map<String, Equipa> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
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
    }
    
    public void inserirEquipa(Equipa equipa){
        equipas.put(equipa.getNome(),equipa);
    }
    /*
    public void inserirJogo(List<JogoRegisto> jogos){
       this.jogos = new ArrayList<>();
       for(JogoRegisto registo : jogos) {
            this.jogos.add(registo);
       }
    }
    */
}
