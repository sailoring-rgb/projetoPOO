package Exceptions;

/**
 * Classe que se encarrega de denotar o facto de uma equipa não ser válida e lança uma mensagem se tal acontecer.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class EquipaNaoValidaException extends Exception{
    
    public EquipaNaoValidaException(){
        super();
    }

    public EquipaNaoValidaException(String msg){
        super(msg);
    }
}
