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

public class Jogo{
    
    private static final int POR_COMECAR = 0;
    private static final int A_DECORRER = 1;
    private static final int TERMINADO = 2;
   
    private int gameProgress;
    // private LocalDateTime data;
    private EstadoJogo gameState;
    
    /**
     * Construtores da classe Jogo.
     */
    
    public Jogo(){
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.gameState = new EstadoJogo();
    }
    
    public Jogo(String nomeEquipaCasa, String nomeEquipaFora){
        this.gameProgress = POR_COMECAR;
        // this.data = LocalDateTime.now();
        this.gameState = new EstadoJogo(nomeEquipaCasa, nomeEquipaFora);
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
    
    /**
     * Construir método saveGame();
     */
    
    /**
     * Construir método loadGame();
     */
    
    /*
    // FALTA AINDA:
    // Método que calcula o vencedor do jogo.
    // "pode arbitrar-se que em cada uma das divisões do tempo uma das equipas é responsável por atacar ...
    // ... e em função disso a jogada pode resultar em golo ou então em perda de bola para o adversário."
    // Indicar quem ganhou e qual o resultado.
    */
}
