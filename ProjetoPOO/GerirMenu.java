import java.util.*;
import java.io.*;

/**
 * Escreva a descrição da classe GerirMenu aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GerirMenu extends Menu
{
    private int option;
    private Data data;
    
    public GerirMenu(Data dados)
    {
        this.data = dados;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduza a sua escolha:");
        System.out.println("1: Criar Equipa");
        System.out.println("2: Criar Jogador");
        System.out.println("3: Visualizar Jogadores/Equipas");
        System.out.println("4: Transferir Jogadores");
        System.out.println("5: Voltar");
    
        this.option = sc.nextInt();
        makeChoice(option);
    }
    
    public void makeChoice(int option)
    {
       switch (option) {
          case 1:
            // Criar uma equipa
            CriarEquipa equipa = new CriarEquipa();
            break;
          case 2:
            //Criar um jogador
            CriarJog aux = new CriarJog();
                int jogEscolhido = aux.qualJog();
                if(jogEscolhido < 1 || jogEscolhido > 5)
                    System.out.println("Não exite esta opção!");
                    else aux.escJogador(jogEscolhido);
            break;
          case 3:
            System.out.println("Equipas:");
            data.getEquipas().forEach((key, value) -> System.out.println(key + ":" + value));
            
            System.out.println("Jogadores:");
            data.getJogadores().forEach((key, value) -> System.out.println(key + ":" + value));
            break;
          case 4:
            // Transferir jogador entre equipas
            break;
          case 5:
            // Voltar
            MainMenu menu = new MainMenu();
            break;
          default: System.out.println("Opção Inválida");
        }
    }
}
