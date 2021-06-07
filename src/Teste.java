
/**
 * Testa a criação de um jogador e as futuras escolhas (por criar).
 *
 * @author grupo
 * @version 210418
 */

import java.util.Scanner;
import java.io.*;

public class Teste{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem-vindo!");
        promptEnterKey();

        MainMenu menu = new MainMenu();
        
        /*
        switch(escolha){
            case 1:
                CriarJog aux = new CriarJog();
                int jogEscolhido = aux.qualJog();
                if(jogEscolhido < 1 || jogEscolhido > 5)
                    System.out.println("Não exite esta opção!");
                    else aux.escJogador(jogEscolhido);
                break;
        
            case 2:
                MainMenu menu = new MainMenu();
                break;
       
            default: 
                System.out.println("Não exite esta opção!");
                break;
                */
    }

    
    public static void promptEnterKey(){
        System.out.println("Presse \"ENTER\" para começar.");
        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
