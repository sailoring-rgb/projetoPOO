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
    
    public MainMenu()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduza a sua escolha:");
        System.out.println("1: Criar Partida");
        System.out.println("2: Gerir Jogadores/Equipas");
        System.out.println("3: Guardar Jogo");
        System.out.println("4: Carregar Jogo");
        System.out.println("5: Sair");
    
        int option = sc.nextInt();
        makeChoice(option);
    }
    
    public void makeChoice(int option)
    {
        switch (option) {
          case 1:
            //Escolher duas equipas para jogar
            break;
          case 2:
            //Transferir jogador entre equipas, etc
            GerirMenu menu = new GerirMenu();
            break;
          case 3:
            //Save Game
            break;
          case 4:
            //loadGame();
            break;
          case 5:
             System.out.println("The End");
             System.exit(0);
            break;
          default: System.out.println("Opção Inválida");
        }
    }
}
