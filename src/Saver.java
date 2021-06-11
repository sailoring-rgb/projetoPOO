import java.util.*;
import java.io.*;

/**
 * Escreva a descrição da classe Loader aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Saver{
    public static void save(Data dados)
    {
        Map<String, Equipa> equipas = dados.getEquipas(); //nome, equipa
        List<JogoRegisto> jogos = dados.getJogos();
        
        try{
            File file = new File("dadosteste.txt");
        
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
