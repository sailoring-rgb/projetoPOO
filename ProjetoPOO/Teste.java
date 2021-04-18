
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
        int escolha;
        Scanner sc = new Scanner(System.in);
    
        System.out.println("O que pretende fazer?");

        System.out.println("1: Criar um novo jogador.");
        System.out.println("2: ...");
        System.out.println("3: ...");
    
        escolha = sc.nextInt();
        System.out.println("\n");
    
        switch(escolha){

            case 1:
                CriaJogTemp aux = new CriaJogTemp();
                aux.criaJogador();
                break;
        
            // case 2:
            // case 3:
        }    
    }
}
