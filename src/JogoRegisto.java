
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
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substituicoesFora;

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

      public void apresentarJogo(){
        System.out.println(date+": " + equipaCasa + " " + golosCasa + " - " + golosFora + " " + equipaFora);
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
    
    public void saver(PrintWriter print){
        print.print("Jogo:"+ equipaCasa + ","
                             + equipaFora + ","
                             + golosCasa + ","
                             + golosFora + ","
                             + date);
                             
        for(int jogC : jogadoresCasa) {
                print.print("," + Integer.toString(jogC));
            }
        
        for(var subsC : substituicoesCasa.entrySet()){
                print.print("," + Integer.toString(subsC.getKey()) + "->" 
                                  + Integer.toString(subsC.getValue()));
            }
        
        for(int jogF : jogadoresFora) {
                print.print("," + Integer.toString(jogF));
            }
        
        for(var subsFSav : substituicoesCasa.entrySet()){
                print.print("," + Integer.toString(subsFSav.getKey()) + "->" 
                                  + Integer.toString(subsFSav.getValue()));
        }
        print.print("\r");
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
