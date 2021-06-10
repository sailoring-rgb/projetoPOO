
/**
 * Classe que se encarrega de denotar o facto de uma equipa não existir e lança uma mensagem se tal acontecer.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class EquipaJaExisteException extends Exception{
    
    public EquipaJaExisteException(){
        super();
    }

    public EquipaJaExisteException(String msg){
        super(msg);
    }
}
