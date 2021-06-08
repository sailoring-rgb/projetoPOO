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
        
        loadGame();
        System.out.println("\n");
    
        while(true){
            System.out.println("Introduza a sua escolha:");
            System.out.println("1: Criar Partida");
            System.out.println("2: Gerir Jogadores/Equipas");
            System.out.println("3: Verificar Registo de Jogos");
            System.out.println("4: Guardar Jogo");
            System.out.println("5: Carregar Jogo");
            System.out.println("6: Sair");
            this.option = sc.nextInt();
            makeChoice(option);
        }
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

                // Jogo jogo = new Jogo(nomeEquipaCasa, nomeEquipaFora);
                // jogo.getGameState().equipasEmCampo(equipas, nomeEquipaCasa, nomeEquipaFora);
                EstadoJogo estado = new EstadoJogo(nomeEquipaCasa, nomeEquipaFora);
                JogMenu novoMenu = new JogMenu(estado);
                break;
                
            case 2:
                GerirMenu menu2 = new GerirMenu(dados);
                break;
                
            case 3:
                dados.apJogos();
                return;
                
            case 4:
                saveGame(dados);
                return;
                
            case 5:
                loadGame();
                return;
                
            case 6:
                System.out.println("The End!!");
                System.exit(0);
                break;
                
            default: 
                System.out.println("Opção Inválida! Digite a sua opção novamente");
                option = sc.nextInt();
                makeChoice(option);
                break;
        }
    }
    
    public void loadGame(){
        try{ System.out.println("A carregar dados..");
             this.dados = ParserMod.parse(); 
             System.out.println("Jogo carregado.");}
        catch(Exception exc){ 
            System.out.println("Erro a carregar! A criar nova base de dados..");
            this.dados = new Data(); 
            System.out.println("Base de dados criada.");}
    }
    
    public void saveGame(Data dados){
        try{ System.out.println("A guardar dados..");
             Saver.save(dados);
             System.out.println("Jogo guardado.");}
        catch(Exception exc) {System.out.println("Erro a guardar Jogo!");}
    }
}
