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
        System.out.println("Introduza a sua escolha: \r\n 1 - Start new game \r\n 2 - Load Game \r\n 3 - Exit");
    
        Scanner option = new Scanner(System.in);
    }

    public void makeChoice(int option)
    {
        switch (option) {
          case 1:
            newGame();
            break;
          case 2:
            Loader load = new Loader();
            //load.loadGame();
            break;
          case 3:
            exitGame();
            break;
          default: System.out.println("Opção Inválida");
    }
    }
    
    public void newGame()
    {
        
    }
    
    public void exitGame()
    {
        System.out.println("The End");
        
        System.exit(0);
    }
}
