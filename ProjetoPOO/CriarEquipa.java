import java.util.*;

/**
 * Escreva a descrição da classe CriarEquipa aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CriarEquipa
{
    public void criarEq()
    {
        Scanner sc = new Scanner(System.in);
        Equipa eq = new Equipa();
        
        System.out.println("Nome da equipa: ");
        
        String nome = sc.nextLine();
        
        for(int i = 0; i < 15; i++) {
            CriarJog criar = new CriarJog();
        }
    }
}