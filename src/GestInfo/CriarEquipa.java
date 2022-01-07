package GestInfo;

import java.util.*;
/**
 * Esta classe destina-se a criar uma equipa.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class CriarEquipa {
    /**
     * Método que pergunta ao usuário o nome da nova equipa, criando-a.
     * @return a nova equipa criada
     */
    public static Equipa criarEq(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nome da equipa: ");
        
        String nome = sc.nextLine();
        Equipa eq = new Equipa(nome);
        
        System.out.println("Pretende criar os 20 jogadores para esta equipa? Y/N");
        String resposta = sc.nextLine();
        
        switch(resposta){
            case "Y":
                System.out.println("É preciso ter em conta o seguinte:");
                System.out.println("    Avançados: no mínimo 3");
                System.out.println("    Laterais: no mínimo 2");
                System.out.println("    Médios: no mínimo 4");
                System.out.println("    Defesas: no mínimo 2");
                System.out.println("    Guarda Redes: no mínimo 1");
                
                for(int num = 0; num < 20; num++){
                    System.out.println("\n");
            
                    CriarJog aux = new CriarJog();
                    int jogEscolhido = aux.escJogador();
                    Jogador novoJog = new Jogador(aux.criarJogador(jogEscolhido));
            
                    eq.getJogadores().put(novoJog.getNrCamisola(), novoJog.clone());
                }
                break;
                
            case "N":
                break;
                
            default:
                System.out.println("A sua resposta não é válida");
                break;
        }
        
        return eq;
    }
}