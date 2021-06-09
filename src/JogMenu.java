import java.util.*;
import java.io.*;

/**
 * Escreva a descrição da classe JogMenu aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class JogMenu 
{
    private int option;
    private Jogo jogo;
    private EstadoJogo estado;
    
    public JogMenu(EstadoJogo novoEstado){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("Introduza a sua escolha:");
        System.out.println("1: Começar Jogo");
        System.out.println("2: Escolher tática");
        System.out.println("3: Sair");
    
        this.option = sc.nextInt();
        this.jogo = new Jogo(estado);
        this.estado = novoEstado;
        
        makeChoice(this.option);
    }
    
    public void makeChoice(int option){
       switch (option) {
          case 1:
            jogo.startGame(this.estado);
            jogo.iniciaJogada(this.estado);
            jogo.endGame(this.estado);            
            break;
            
          case 2:
            escTatica();
            break;
            
          case 3:
            exit();
            break;
            
          default: System.out.println("Opção Inválida");
        }
    }
    
    public void escTatica(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduza a tática:");
        System.out.println("1: 4-4-2");
        System.out.println("2: 4-3-3");
        System.out.println("3: 4-2-4");
        System.out.println("4: 3-4-3");
        
        Double tatica = sc.nextDouble();
        //setNrTatica(tatica-1);
        //Distribui jogadores
        //switch com um set na tatica da equipa 
    }
    
    public void exit(){
        System.out.println("The End");
        System.exit(0);
    }
}
