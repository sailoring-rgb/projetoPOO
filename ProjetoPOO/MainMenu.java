import java.util.*;
import java.io.*;

/**
 * Escreva a descrição da classe MainMenu aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class MainMenu extends Menu
{
    private int option;
    private Data dados;
       
    public MainMenu()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Loading game...");
        loadGame();
        System.out.println("Done!");
        
        System.out.println("O que pretende fazer?");
        System.out.println("1: Criar Partida");
        System.out.println("2: Gerir Jogadores/Equipas");
        System.out.println("3: Guardar Jogo");
        System.out.println("4: Carregar Jogo");
        System.out.println("5: Sair");
    
        this.option = sc.nextInt();
        makeChoice(option);
    }
    
    public void makeChoice(int option)
    {
        Scanner sc = new Scanner(System.in);
        
        switch (option) {
            case 1:
                System.out.println("Que equipa que joga em casa?");
                String nomeEquipaCasa = sc.nextLine();
                System.out.println("Que equipa que joga fora?");
                String nomeEquipaFora = sc.nextLine();
            
                Map<String, Equipa> equipas = dados.getEquipas();

                Jogo jogo = new Jogo(nomeEquipaCasa, nomeEquipaFora);
                jogo.getGameState().equipasEmCampo(equipas, nomeEquipaCasa, nomeEquipaFora);
            
                JogMenu menu1 = new JogMenu();
                break;
            case 2:
                // Transferir jogador entre equipas, etc
                GerirMenu menu2 = new GerirMenu(dados);
                // System.out.println("stop");
                break;
            case 3:
                // jogo.saveGame();
                break;
            case 4:
                loadGame();
                new MainMenu();
                break;
            case 5:
                System.out.println("The End");
                System.exit(0);
                break;
            default: System.out.println("Opção Inválida");
        }
    }
    
    public void loadGame(){
        try{ this.dados = ParserMod.parse(); }
        catch(Exception exc){ this.dados = new Data(); }
    }
}
