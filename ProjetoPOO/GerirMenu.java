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
    Scanner sc = new Scanner(System.in);
    
    public GerirMenu(Data dados)
    {
        this.data = dados;
        
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
            gerarEquipa();
            
            new GerirMenu(data);
            break;
            
          case 2:
            gerarJogador();
            
            new GerirMenu(data);
            break;
            
          case 3:
            apresentarData();
            
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
    
    public void gerarEquipa()
    {
        Equipa equipa = new Equipa(CriarEquipa.criarEq());
        data.inserirEquipa(equipa);
        System.out.println("Criada Equipa: "+ (data.getEquipas().get(equipa.getNome())));
    }
    
    public void gerarJogador()
    {
        CriarJog aux = new CriarJog();
        int jogEscolhido = aux.escJogador();
        Jogador novoJog = new Jogador(aux.criarJogador(jogEscolhido));
        System.out.println("Jogador: " + novoJog.getNome());
        aux.atribEq(novoJog,data);
    }
    
    public void apresentarData()
    {
        var equipaSet = data.getEquipas().entrySet();
        System.out.println("  Equipas:");
            for(var eq : equipaSet){
                System.out.println("    " + eq.getKey());
                for (var jogador : eq.getValue().getJogadores().entrySet()) {
                    System.out.println("        Número " + jogador.getKey() + " : " + jogador.getValue().getNome());
            }
        }
    }
}
