import java.util.*;

/**
 * Esta classe destina-se a criar uma equipa.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class CriarEquipa
{
    /**
     * Método que pergunta ao usuário o nome da nova equipa, criando-a.
     * @return a nova equipa criada
     */
    public static Equipa criarEq(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nome da equipa: ");
        
        String nome = sc.nextLine();
        Equipa eq = new Equipa(nome);
        
        return eq;
    }
}