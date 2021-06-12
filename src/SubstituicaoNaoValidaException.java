/**
 * Classe que se encarrega de denotar o facto de não ser válida uma susbtituição entre titular e suplente
 * 
 * @author grupo 3 
 * @version (número de versão ou data)
 */
public class SubstituicaoNaoValidaException extends Exception 
{
    public SubstituicaoNaoValidaException(){
        super();
    }

    public SubstituicaoNaoValidaException(String msg){
        super(msg);
    }
}