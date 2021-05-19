import java.util.*;

/**
 * Escreva a descrição da classe CriarEquipa aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CriarEquipa
{
    /**
     * Método que pergunta ao usuário o nome da nova equipa, criando-a.
     * @return a nova equipa criada
     */
    public Equipa criarEq(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nome da equipa: ");
        
        String nome = sc.nextLine();
        Equipa eq = new Equipa(nome);
        
        return eq;
    }
}