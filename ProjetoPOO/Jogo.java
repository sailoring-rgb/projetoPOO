/**
 * Jogo de futebol.
 *
 * @author grupo
 * @version 210402
 */

import java.time.LocalDateTime;

public class Jogo{
    
    private static final int POR_COMECAR = 0;
    private static final int A_DECORRER = 1;
    private static final int TERMINADO = 2;
   
    private int estadoJogo;
    private LocalDateTime data;
    private Equipa equipa1;
    private Equipa equipa2;
    
    /**
     * Construtor da classe Jogo.
     */
    public Jogo(){
        this.estadoJogo = POR_COMECAR;
        this.data = LocalDateTime.now();
    }
    
    /**
    * Método que obtém o estado atual do jogo.
    * @return o estado do jogo
    */
    public int getEstado(){
        return this.estadoJogo;
    }
    
    /**
    * Método que muda o estado atual do jogo.
    * @param o novo estado do jogo
    */
    public void setEstado(int estado){
        this.estadoJogo = estado;
    }
    
    /**
    * Método que começa o jogo.
    */
    public void startJogo(){
        if(this.estadoJogo == POR_COMECAR)
            this.estadoJogo = A_DECORRER; 
    }
    
    /**
    * Método que termina o jogo.
    */
    public void endJogo(){
        if(this.estadoJogo == A_DECORRER)
            this.estadoJogo = TERMINADO;
    }
    
    
    /*
    // FALTA AINDA:
    // Método que calcula o vencedor do jogo.
    // "pode arbitrar-se que em cada uma das divisões do tempo uma das equipas é responsável por atacar ...
    // ... e em função disso a jogada pode resultar em golo ou então em perda de bola para o adversário."
    // Indicar quem ganhou e qual o resultado.
    */
}
