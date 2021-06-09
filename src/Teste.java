
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
