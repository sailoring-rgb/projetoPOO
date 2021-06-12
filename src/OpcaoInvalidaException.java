/**
 * Classe que se encarrega de denotar o facto da opção escolhida pelo o uário ser inválida e lança uma mensagem se tal acontecer.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class OpcaoInvalidaException extends Exception 
{
    public OpcaoInvalidaException(){
        super();
    }

    public OpcaoInvalidaException(String msg){
        super(msg);
    }
}
