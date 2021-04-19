import java.util.*;
import java.io.*;

/**
 * Escreva a descrição da classe Start aqui.
 * 
 * @author Its me again
 * @version 210413
 */
public class Start extends Menu
{
    private int option;
    
    public Start()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduza a sua escolha:");
        System.out.println("1: Start new game");
        System.out.println("2: Load Game");
        System.out.println("3: Exit");
    
        Double option = sc.nextDouble();
    }

    public void makeChoice(int option)
    {
        switch (option) {
          case 1:
            newGame();
            break;
          case 2:
            loadGame();
            break;
          case 3:
            exitGame();
            break;
          default: System.out.println("Opção Inválida");
    }
    }
    
    public void newGame()
    {
        CriarJog criar = new CriarJog();
    }
    
    public void loadGame()
    {
        Loader load = new Loader();
        load.loadG();
    }
    
    public void exitGame()
    {
        System.out.println("The End");
        
        System.exit(0);
    }
}
