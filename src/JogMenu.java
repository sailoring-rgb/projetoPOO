import java.util.*;
import java.io.*;

/**
 * Apresenta um menu destinado ao jogo.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class JogMenu 
{
    private int option;
    private Jogo jogo;
    private EstadoJogo estado;
    private Data dados;
    private boolean fim = false;
    
    public JogMenu(EstadoJogo novoEstado, Data dados){
        this.dados = dados;
        Scanner sc = new Scanner(System.in);
        
        while(!fim){
        System.out.println("\n");
        System.out.println("Introduza a sua escolha:");
        System.out.println("1: Começar Jogo");
        System.out.println("2: Escolher tática");
        System.out.println("2: Escolher substituições");
        System.out.println("3: Sair");
    
        this.option = sc.nextInt();
        this.jogo = new Jogo(estado);
        this.estado = novoEstado;
        
        makeChoice(this.option);
        }
    }
    
    public void makeChoice(int option){
       switch (option) {
          case 1:
            jogo.startGame(this.estado);
            jogo.iniciaJogada(this.estado);
            jogo.endGame(this.estado);  
            dados.inserirJogo(this.estado);
            fim = true;
            break;
            
          case 2:
            escTatica();
            break;
                
          case 3:
            try{
                escSubs();
            }
            catch(OpcaoInvalidaException exc){
                  System.out.println("Opção introduzida é inválida");
            }
            break;
        
          case 4:
            exit();
            break;
            
          default: System.out.println("Opção Inválida");
        }
    }
    
    public void escTatica(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual equipa pretende que mude a tática:");
        System.out.println("1: " + estado.getEquipaCasa().getNome());
        System.out.println("2: " + estado.getEquipaFora().getNome());
        
        int equipa = sc.nextInt();
        
        
        System.out.println("Introduza a tática:");
        System.out.println("1: 4-4-2");
        System.out.println("2: 4-3-3");
        
        int tatica = sc.nextInt();
        switch(equipa){
            case 1:
                estado.setTaticaCasa(tatica);
                break;
            case 2:
                estado.setTaticaFora(tatica);
                break;
            default:
                break;
        }
        
        System.out.println("Tatica modificada com sucesso");
    }

    public void escSubs() throws OpcaoInvalidaException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual equipa que pretende definir as substituições:");
        System.out.println("1: " + estado.getEquipaCasa().getNome());
        System.out.println("2: " + estado.getEquipaFora().getNome());
        
        int equipa = sc.nextInt();
        
        switch(equipa){
            case 1: 
                estado.getEquipaCasa().apresentarTitulares();
                break;
            case 2: 
                estado.getEquipaCasa().apresentarTitulares();
                break;
            default:
                throw new OpcaoInvalidaException();
        }
        
        System.out.println("Escreva o número do Titular que pretende substituir:");
        int titular = sc.nextInt();
        
        switch(equipa){
            case 1:
                if(!(estado.getEquipaCasa().getTitulares().containsKey(titular)))
                    throw new OpcaoInvalidaException();
                break;
            case 2:
                if(!(estado.getEquipaFora().getTitulares().containsKey(titular)))
                    throw new OpcaoInvalidaException();
                break;
            default:
                throw new OpcaoInvalidaException();
        }
        
        switch(equipa){
            case 1:
                estado.getEquipaCasa().apresentarSuplentes();
                break;
            case 2:
                estado.getEquipaCasa().apresentarSuplentes();
                break;
            default:
                throw new OpcaoInvalidaException();
        }
        
        System.out.println("Escreva o número do Suplente que pretende que substitua o nr." + titular);
        int suplente = sc.nextInt();
        
        switch(equipa){
            case 1:
                if(!(estado.getEquipaCasa().getSuplentes().containsKey(suplente)))
                    throw new OpcaoInvalidaException();
                break;
            case 2: 
                if(!(estado.getEquipaFora().getSuplentes().containsKey(suplente)))
                    throw new OpcaoInvalidaException();
                break;
            default:
                throw new OpcaoInvalidaException();
        }
        
        //substituir aqui
        
        System.out.println("Substituição " + titular + " -> " + suplente +" planeada");
    }
    
    public void exit(){
        System.out.println("The End");
        System.exit(0);
    }
}
