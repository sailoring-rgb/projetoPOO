
/**
 * Testa a criação de um jogador e as futuras escolhas (por criar).
 *
 * @author grupo
 * @version 210418
 */
import java.util.Scanner;

public class Teste
{
    public static void main(String[] args){
        // ..............
        Scanner sc = new Scanner(System.in);
    
        System.out.println("O que pretende fazer?");

        System.out.println("1: Criar um novo jogador.");
        System.out.println("2: Entrar Main Menu");
        System.out.println("3: ...");
    
        int escolha = sc.nextInt();
        System.out.println("\n");
        
        //É mais facil fazer com switch default 
        switch(escolha){

            case 1:
                CriarJog aux = new CriarJog();
                int jogEscolhido = aux.qualJog();
                if(jogEscolhido < 1 || jogEscolhido > 5)
                    System.out.println("Não exite esta opção!");
                else aux.divHabilidade(jogEscolhido);
                break;
            
            case 2:
                MainMenu menu = new MainMenu();
                break;
                    // case 3:
            default: 
                System.out.println("Não exite esta opção!");
                break;
        }
    }
}
