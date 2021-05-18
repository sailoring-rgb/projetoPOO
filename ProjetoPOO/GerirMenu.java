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
        
        System.out.println("\n");
        System.out.println("Introduza a sua escolha:");
        System.out.println("1: Criar Equipa");
        System.out.println("2: Criar Jogador");
        System.out.println("3: Visualizar Jogadores/Equipas");
        System.out.println("4: Transferir Jogadores");
        System.out.println("5: Voltar");
    
        this.option = sc.nextInt();
        if(option < 1 || option > 5)
            System.out.println("Não exite esta opção!");
        else makeChoice(option);
    }
    
    public void makeChoice(int option)
    {
       switch (option) {
          case 1:
            CriarEquipa equipa = new CriarEquipa();
            Equipa novaEq = equipa.criarEq();
            this.data.getEquipas().put(novaEq.getNome(), novaEq);
            
            new GerirMenu(data);
            break;
            
          case 2:
            CriarJog aux = new CriarJog();
            int jogEscolhido = aux.escJogador();
            Jogador novoJog = aux.criarJogador(jogEscolhido);
            this.data.getJogadores().put(novoJog.getNrCamisola(),novoJog);
            
            new GerirMenu(data);
            break;
            
          case 3:
            System.out.println("Equipas:");
            this.data.getEquipas().forEach((key, value) -> System.out.println("    " + key + " : " + value));
            System.out.println("\n");
            
            System.out.println("Jogadores:");
            this.data.getJogadores().forEach((key, value) -> System.out.println("    Número " + key + " : " + value));
            
            new GerirMenu(data);
            break;
            
          case 4:
            // Transferir jogador entre equipas
            // ...
            new GerirMenu(data);
            break;
            
          case 5:
            MainMenu menu = new MainMenu();
            break;
            
          default: System.out.println("Opção Inválida");
       }
    }
}
