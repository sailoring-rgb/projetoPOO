import GestInfo.Equipa;
import GestInfo.JogoRegisto;

import java.util.*;
import java.io.*;

/**
 * Classe do saver do Jogo.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class Saver{
    /**
     * Método que transfere toda a informação de um ficheiro para o jogo
     * @param dados objeto onde se vai guardar a informação
     */
    public static void save(Data dados)
    {
        Map<String, Equipa> equipas = dados.getEquipas(); //nome, equipa
        List<JogoRegisto> jogos = dados.getJogos();
        
        try{
            File file = new File("dados.txt");
        
            if(!(file.exists())) file.createNewFile();
            
            PrintWriter print = new PrintWriter(file);
        
            for(Equipa equipa : equipas.values()){
                equipa.saver(print);
            }
            
            for(JogoRegisto jogo : jogos){
                jogo.saver(print);
            }

            print.close();
        }    
        catch(IOException e) {e.printStackTrace();}
        
        System.out.println("\n");
    }
}
