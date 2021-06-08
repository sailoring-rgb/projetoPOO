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
    private EstadoJogo gameState;
    
    /**
     * Construtores da classe Jogo.
     */
    
    public Jogo(){
        this.equipaAtual = "";
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.gameState = new EstadoJogo();
    }
    
    public Jogo(String nomeEquipaCasa, String nomeEquipaFora){
        this.equipaAtual = "";
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.gameState = new EstadoJogo(nomeEquipaCasa, nomeEquipaFora);
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
    public EstadoJogo getGameState(){
        return this.gameState;
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
    public void setGameState(EstadoJogo gameState){
        this.gameState = gameState;
    }
    
    /**
    * Método que começa o jogo.
    */
    public void startGame(){
        if(this.gameProgress == POR_COMECAR)
            this.gameProgress = A_DECORRER; 
    }
    
    /**
    * Método que termina o jogo.
    */
    public void endGame(){
        if(this.gameProgress == A_DECORRER)
            this.gameProgress = TERMINADO;
    }
    
    public void iniciaJogada(){

        Random rand = new Random();

        EstadoJogo estado = new EstadoJogo();

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

            // se o valor random estiver entre 5 e 9, então uma das equipas inciará uma jogada.
            // se o valor estiver neste intervalo, é a equipa 1 que jogará.
            if(value > 5 && value <= 5 + hipoteseEquipa1) {

                this.equipaAtual = equipa1.getNome();
                System.out.println(tempo + ": " + equipaAtual + "inicia uma jogada.");
                constroiJogada();
            }
            // se o valor estiver neste intervalo, é a equipa 2 que jogará.
            if(value > 5 + hipoteseEquipa1 && value <= 5 + hipoteseEquipa1 + hipoteseEquipa2) {

                this.equipaAtual = equipa2.getNome();
                System.out.println(tempo + ": " + equipaAtual + "inicia uma jogada.");
                constroiJogada();
            }
        }
    // acaba o jogo.
    }
    
    public void constroiJogada();
}
