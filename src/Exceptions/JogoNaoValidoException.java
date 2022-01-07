package Exceptions;
/**
 * Classe que se encarrega de denotar o facto de um jogo não ser válido (uma equipa não pode jogar com si própria) e lança uma mensagem se tal acontecer.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class JogoNaoValidoException extends Exception
{
    public JogoNaoValidoException(){
        super();
    }

    public JogoNaoValidoException(String msg){
        super(msg);
    }
}
