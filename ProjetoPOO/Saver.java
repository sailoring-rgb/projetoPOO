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
        Map<Integer, Jogador> jogadores = dados.getJogadores(); //numero, jogador
        List<EstadoJogo> jogos = dados.getJogos();

        var equipaSet = equipas.entrySet();
        
        try{
        File file = new File("dadosteste.txt");
        
        if(!file.exists()) file.createNewFile();
        
        PrintWriter print = new PrintWriter(file);
        
        for(var equipa : equipaSet){
            print.println("Equipa:"+ equipa.getKey() +":\n");
            Equipa EquipaValor = equipa.getValue();
            List<Jogador> jogadoresEquipa = EquipaValor.getJogadores();
            
            for (Jogador jogador : jogadoresEquipa) {
            print.println("Jogador:"+ jogador.getNome() +","
                                    + jogador.getNrCamisola() +","
                                    + jogador.getVelocidade() +","
                                    + jogador.getResistencia() +","
                                    + jogador.getDestreza() +","
                                    + jogador.getImpulsao() +","
                                    + jogador.getJogoCabeca() +","
                                    + jogador.getRemate() +","
                                    + jogador.getCapPasse() +"\n");
            }
            
        }
        
        for(EstadoJogo jogo : jogos){
            print.println("Jogo:"+ jogo.getEquipaCasa() +","
                                 + jogo.getEquipaFora() +","
                                 + jogo.getScoreCasa() +","
                                 + jogo.getScoreFora() +","
                                 + jogo.getData());
                                 
            List<Integer> jogadoresJogoC = jogo.getJogadoresCasa();
            Map<Integer,Integer> subsCasa = jogo.getSubstituicoesCasa();
            var subsCSet = subsCasa.entrySet();
            List<Integer> jogadoresJogoF = jogo.getJogadoresFora();
            Map<Integer,Integer> subsFora = jogo.getSubstituicoesFora();
            var subsFSet = subsFora.entrySet();
            
            for(int jogCasa : jogadoresJogoC) {
                print.println(jogCasa+",");
            }
            
            for(var subCasa : subsCSet) {
                print.println(subCasa.getKey() +"->"+ subCasa.getValue()+",");
            }
            
            for(int jogFora : jogadoresJogoF) {
                print.println(jogFora+",");
            }
            
            for(var subFora : subsFSet) {
                print.println(subFora.getKey() +"->"+ subFora.getValue()+",");
            }
        }
        

        print.close();
        }    
        catch(IOException e) {e.printStackTrace();}
    }
}
