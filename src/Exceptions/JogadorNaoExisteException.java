package Exceptions;
/**
 * Classe que se encarrega de denotar o facto de um jogador não existir.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class JogadorNaoExisteException extends Exception{
    
    public JogadorNaoExisteException(){
        super();
    }

    public JogadorNaoExisteException(String msg){
        super(msg);
    }
}
