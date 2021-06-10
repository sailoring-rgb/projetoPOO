
/**
 * Classe que se encarrega de denotar o facto de uma equipa não existir e lança uma mensagem se tal acontecer.
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
