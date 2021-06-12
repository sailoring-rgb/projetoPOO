
/**
 * Classe que se encarrega de denotar o facto de não ser permitida uma susbtituição entre titular e suplente
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class SubstituicaoNaoPermitidaException extends Exception
{
    public SubstituicaoNaoPermitidaException(){
        super();
    }

   public SubstituicaoNaoPermitidaException(String msg){
        super(msg);
   }
}
