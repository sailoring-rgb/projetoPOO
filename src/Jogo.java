/**
 * Jogo de futebol.
 *
 * @author grupo
 * @version 210402
 */

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.Random;

public class Jogo{
    
    private static final int POR_COMECAR = 0;
    private static final int A_DECORRER = 1;
    private static final int TERMINADO = 2;
    
    private String equipaAtual;   
    private int gameProgress;
    // private LocalDateTime data;
    private EstadoJogo estado;
    
    /**
     * Construtores da classe Jogo.
     */
    
    public Jogo(){
        this.equipaAtual = "";
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.estado = new EstadoJogo();
    }
    
    public Jogo(String nomeEquipaCasa, String nomeEquipaFora, Map<String, Equipa> equipas){
        this.equipaAtual = "";
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.estado = new EstadoJogo(nomeEquipaCasa, nomeEquipaFora, equipas);
    }
    
    public Jogo(EstadoJogo estado){
        this.equipaAtual = "";
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.estado = estado;
    }
    
    /**
    * Método que obtém o nome da equipa com posse de bola.
    * @return o nome da equipa atual
    */
    public String getEquipaAtual(){
        return this.equipaAtual;
    }
    
    /**
    * Método que obtém como se encontra o jogo (por começar, a decorrer ou terminado).
    * @return o progresso do jogo
    */
    public int getGameProgress(){
        return this.gameProgress;
    }
    
    /**
    * Método que obtém o estado do jogo.
    * @return o estado do jogo
    */
    public EstadoJogo getEstado(){
        return this.estado;
    }
    
    /**
    * Método que altera o nome da equipa com posse de bola.
    * @param o novo nome da equipa atual
    */
    public void setEquipaAtual(String equipaAtual){
        this.equipaAtual = equipaAtual;
    }
    
    /**
    * Método que altera como se encontra o jogo (por começar, a decorrer ou terminado).
    * @param o novo progresso do jogo
    */
    public void setGameProgress(int gameProgress){
        this.gameProgress = gameProgress;
    }
    
    /**
    * Método que muda o estado do jogo.
    * @param o novo estado do jogo
    */
    public void setEstado(EstadoJogo estado){
        this.estado = estado;
    }
    
    /**
    * Método que começa o jogo.
    */
    public void startGame(EstadoJogo estado){
        if(this.gameProgress == POR_COMECAR)
            this.gameProgress = A_DECORRER;
        this.estado = estado;
    }
    
    /**
    * Método que termina o jogo.
    */
    public void endGame(EstadoJogo estado){
        if(this.gameProgress == A_DECORRER)
            this.gameProgress = TERMINADO;
        
        this.estado = estado;
        
        System.out.println("\n");
        System.out.println("JOGO ACABOU");
        System.out.println("    Pontuação final: " + estado.getEquipaCasa().getNome() + " - " + estado.getScoreCasa() + " | " + estado.getScoreFora() + " - " + estado.getEquipaFora().getNome());
        
        if(estado.getScoreCasa() > estado.getScoreFora()){
            System.out.println("    " + estado.getEquipaCasa().getNome() + " ganhou o jogo!");
        }
        else{
            System.out.println("    " + estado.getEquipaFora().getNome() + " ganhou o jogo!");
        }
        
        System.out.println("\n");
    }
    
    public void iniciaJogada(EstadoJogo estado){

        Random rand = new Random();

        Equipa equipa1 = new Equipa(estado.getEquipaCasa());
        Equipa equipa2 = new Equipa(estado.getEquipaFora());
           
        double habilidadeEquipa1 = equipa1.habEquipa(equipa1);
        double habilidadeEquipa2 = equipa2.habEquipa(equipa2);

        //regra de 3 simples
        double total = habilidadeEquipa1 + habilidadeEquipa2;
        double hipoteseEquipa1 = (habilidadeEquipa1 * 4) / total;
        double hipoteseEquipa2 = (habilidadeEquipa2 * 4) / total;

        for(int tempo = 0; tempo < 90; tempo++){

            int value = rand.nextInt(10);
            // System.out.println(value);
            
            // se o valor random estiver entre 5 e 9, então uma das equipas inciará uma jogada.
            // se o valor estiver neste intervalo, é a equipa 1 que jogará.
            if(value > 5 && value <= 5 + hipoteseEquipa1) {
                System.out.println("\n");
                this.equipaAtual = equipa1.getNome();
                System.out.println("Minuto " + tempo + ": " + equipaAtual + " inicia uma jogada.");
                constroiJogada(equipaAtual, estado);
            }
            
            // se o valor estiver neste intervalo, é a equipa 2 que jogará.
            if(value > 5 + hipoteseEquipa1 && value <= 5 + hipoteseEquipa1 + hipoteseEquipa2) {
                System.out.println("\n");
                this.equipaAtual = equipa2.getNome();
                System.out.println("Minuto " + tempo + ": " + equipaAtual + " inicia uma jogada.");
                constroiJogada(equipaAtual, estado);
            }
            
        }
    }
    
    public void constroiJogada(String equipaAtual, EstadoJogo estado){
        
        Random rand = new Random();
        int r = 1;
        
        while(r==1){
            
            int value = rand.nextInt(10);
            
            if(value <= 2){
                System.out.println("    " + equipaAtual + " perde a bola para a equipa adversária");
                r=0;
            } 
            
            if(value >= 3 && value <= 6){
                System.out.println("    Passe de bola entre os jogadores");
            }
            
            if(value >= 7 && value <= 8){
                System.out.println("    A equipa adversária pressiona os jogadores de " + equipaAtual);
            }
            
            if(value == 9){
                remate(equipaAtual, estado);
                r=0;
            }
        }
        
    }
    
    public void remate(String equipaAtual, EstadoJogo estado){
        Random rand = new Random();
        
        int value = rand.nextInt(10);
        
        if(value < 4){
            System.out.println("    " + equipaAtual + "remata e marca golo");
            if(equipaAtual.equals(estado.getEquipaCasa())){
                estado.setScoreCasa(estado.getScoreCasa() + 1);
                System.out.println("    Pontuação: " + equipaAtual + " - " + estado.getScoreCasa() + " | " + estado.getScoreFora() + " - " + estado.getEquipaFora().getNome());
            } else{
                estado.setScoreFora(estado.getScoreFora() + 1);
                System.out.println("    Pontuação: " + estado.getEquipaCasa().getNome() + " - " + estado.getScoreCasa() + " | " + estado.getScoreFora() + " - " + equipaAtual);
            }
        }
        
        if(value >= 4 && value <= 6){
            System.out.println("    " + equipaAtual + "remata, mas o guarda redes defende");
        }
        
        if(value >= 7 && value <= 8){
            System.out.println("    " + equipaAtual + "remata, mas falha baliza");
        }
    }
}