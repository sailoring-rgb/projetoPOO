import java.util.*;
import java.io.*;

/**
 * Apresenta o menu destinado às equipas e aos jogadores.
 * 
 * @author grupo 3 
 * @version (número de versão ou data)
 */
public class GerirMenu 
{
    private int option;
    private Data data;
    Scanner sc = new Scanner(System.in);
    
    public GerirMenu(Data dados)
    {
        this.data = dados;
        
        while(true){
            System.out.println("\n");
            System.out.println("Introduza a sua escolha:");
            System.out.println("1: Criar Equipa");
            System.out.println("2: Criar Jogador");
            System.out.println("3: Visualizar Jogadores/Equipas");
            System.out.println("4: Transferir Jogadores");
            System.out.println("5: Voltar");
    
            this.option = sc.nextInt();
            if(option < 1 || option > 5)System.out.println("Não exite esta opção!");
            else {if(option == 5) return; else makeChoice(option);}
        }
    }
    
    public void makeChoice(int option)
    {
       switch (option) {
          case 1:
            try{
                gerarEquipa();
            }
            catch(EquipaJaExisteException exc){
                System.out.println("Esta equipa já existe!");
            }
            return;
            
          case 2:
            gerarJogador();
            return;
            
          case 3:
            apresentarEquipas();
            return;
            
          case 4:
            try{
                transferirJog();
            }
            catch(EquipaNaoExisteException exc){
                System.out.println("Esta equipa não existe!");
            }
            catch(JogadorNaoExisteException exc){
                System.out.println("Este jogador não existe!");
            }
            return;
          
          default: System.out.println("Opção Inválida");
       }
    }
    
    public void gerarEquipa() throws EquipaJaExisteException
    {
        Equipa equipa = new Equipa(CriarEquipa.criarEq());
        if(data.getEquipas().containsKey(equipa.getNome()))
            throw new EquipaJaExisteException();
        data.inserirEquipa(equipa);
        System.out.println("Equipa criada: "+ (data.getEquipa(equipa.getNome()).getNome()));
    }
    
    public void gerarJogador()
    {
        CriarJog aux = new CriarJog();
        int jogEscolhido = aux.escJogador();
        Jogador novoJog = new Jogador(aux.criarJogador(jogEscolhido));
        System.out.println("Jogador: " + novoJog.getNome());
        
        data.apEquipas();
        aux.atribEq(novoJog,data);
    }

    public void apresentarEquipas()
    {
        data.apEquipas();
        System.out.println("Escreva a equipa para inspecionar");
        sc.nextLine(); // flush
        String escEq = sc.nextLine();
        try {
            if(escEq.equals("voltar")) return;
            apresentarPlantel(escEq);
        } catch (NullPointerException e) {
            System.out.println("Opção inválida, escolha novamente.");
        }
    }
    
    public void apresentarPlantel(String escEquipa)
    {
        data.apPlantel(escEquipa);

        System.out.println("Escreva o número do jogador para inspecionar");
        sc.nextLine(); // flush
        int escJog = sc.nextInt();
        try {
            apresentarJogador(escJog,escEquipa);
        } catch (NullPointerException e) {
            System.out.println("Opção inválida, escolha novamente.");
        }
    }
    
    public void apresentarJogador(int escJog, String escEquipa)
    {
        try {data.apJogador(escEquipa, escJog);
             int esc = sc.nextInt();
             System.out.println("Presse Enter para voltar ao Menu");
             try {
            int read = System.in.read(new byte[2]);
            } catch (IOException e) {
            e.printStackTrace();
            }
        } catch (NullPointerException e) {
            System.out.println("Opção inválida, escolha novamente.");
        }
    }
    
    public void transferirJog() throws EquipaNaoExisteException, JogadorNaoExisteException 
    {

        //fazer os trys e ver os nulls ainda
        data.apEquipas();
        System.out.println("Escolha a origem do jogador");
        sc.nextLine(); //flush
        
        String escEquipaO = sc.nextLine();
        
        if(!(data.getEquipas().containsKey(escEquipaO)))
            throw new EquipaNaoExisteException(escEquipaO);
        
        Equipa equipaOrigem = data.getEquipas().get(escEquipaO);
        data.apPlantel(escEquipaO);
        System.out.println("Escolha o jogador que pretende transferir");
        int nr = sc.nextInt();
        
        if(!(equipaOrigem.getJogadores().containsKey(nr)))
            throw new JogadorNaoExisteException(escEquipaO);
            
        Jogador jogTransf = equipaOrigem.getJogadores().get(nr);
    
        data.apEquipas();
        
        System.out.println("Escolha o destino do jogador");
        sc.nextLine();
        String escEquipaD = sc.nextLine();
                
        Equipa equipaDestino = new Equipa();
            
        if(!(data.getEquipas().containsKey(escEquipaD)))
            throw new EquipaNaoExisteException(escEquipaD);
        
        equipaDestino = data.getEquipas().get(escEquipaD);
        
        //para ser arranjado num futuro proximo
        equipaOrigem.removeJogador(jogTransf);
        data.inserirEquipa(equipaOrigem);
        
        int nr_inserido = 0;
        
        while(equipaDestino.getJogadores().containsKey(nr_inserido)){
            nr_inserido +=1;
        }
        
        //Mudar no jogador
        jogTransf.setNrCamisola(nr_inserido);
        jogTransf.addHistorico(escEquipaO);
        
        equipaOrigem.criaTitularesSuplentes();
        equipaDestino.insereJogador(jogTransf);
        data.inserirEquipa(equipaDestino);
            
        System.out.println("Transferencia concluida");
        
        System.out.println(jogTransf.getNome() + " faz agora parte de " + escEquipaD);
        
        jogTransf.apresentarHistorico();
    }
}