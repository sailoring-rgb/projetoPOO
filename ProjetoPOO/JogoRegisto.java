
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class JogoRegisto {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substituicoesFora = new HashMap<>();

    public JogoRegisto (String ec, String ef, int gc, int gf, LocalDate d,  List<Integer> jc, Map<Integer, Integer> sc,  List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substituicoesFora = new HashMap<>(sf);
    }

    public static JogoRegisto parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new JogoRegisto (campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                        LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        jc, subsC, jf, subsF);
    }
    
    public static void saver(JogoRegisto jogReg, PrintWriter print){
        
        String equipaCasaSav = jogReg.getEquipaCasa();
        String equipaForaSav = jogReg.getEquipaFora();
        String golosCasaSav = Integer.toString(jogReg.getGolosCasa());
        String golosForaSav = Integer.toString(jogReg.getGolosCasa());
        String dateSav = jogReg.getData().toString();
        List<Integer> jogCasaSav = jogReg.getJogadoresCasa();
        List<Integer> jogForaSav = jogReg.getJogadoresFora();
        Map<Integer, Integer> subsCasa = jogReg.getSubstituicoesCasa();
        Map<Integer, Integer> subsFora = jogReg.getSubstituicoesFora();
        
        var subsCasaSet = subsCasa.entrySet();
        var subsForaSet = subsFora.entrySet();
        
        print.println("Jogo:"+ equipaCasaSav + ","
                             + equipaForaSav + ","
                             + golosCasaSav + ","
                             + golosCasaSav + ","
                             + dateSav);
                             
        for(int jogCSav : jogCasaSav) {
                print.println("," + Integer.toString(jogCSav));
            }
        
        for(var subsCSav : subsCasaSet){
                print.println("," + Integer.toString(subsCSav.getKey()) + "->" 
                                  + Integer.toString(subsCSav.getValue()));
            }
        
        for(int jogFSav : jogForaSav) {
                print.println("," + Integer.toString(jogFSav));
            }
        
        for(var subsFSav : subsForaSet){
                print.println("," + Integer.toString(subsFSav.getKey()) + "->" 
                                  + Integer.toString(subsFSav.getValue()));
        }
    }
    
    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
                //+ " -> " + substituicoesCasa.toString()
                //+ " -> " + substitucoesFora.toString();
    }
       
    /**
    * Método que obtém a equipa que joga em casa.
    * @return a equipa que joga em casa
    */
    public String getEquipaCasa(){
        return this.equipaCasa;
    }

    /**
    * Método que obtém a equipa que joga fora.
    * @return a equipa que joga fora
    */
    public String getEquipaFora(){
        return this.equipaFora;
    }

    /**
    * Método que obtém o score da equipa que joga em casa.
    * @return o score da equipa que joga em casa
    */
    public int getGolosCasa(){
        return this.golosCasa;
    }

    /**
    * Método que obtém o score da equipa que joga fora.
    * @return o score da equipa que joga fora
    */
    public int getGolosFora(){
        return this.golosFora;
    }

        /**
    * Método que obtém a data e instância do jogo.
    * @return a data e instância do jogo
    */
    public LocalDate getData(){
        return this.date;
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
    
}
