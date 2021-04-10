
/**
 * Dados sobre um Jogador do tipo Avançado.
 *
 * @author grupo
 * @version 210402
 */
public class Avancado{
    
    public double habAvancado (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*1;
        habilidade += umJog.getResistencia()*0.5;
        habilidade += umJog.getDestreza()*1;
        habilidade += umJog.getImpulsao()*1;
        habilidade += umJog.getJogoCabeca()*1;
        habilidade += umJog.getRemate()*1;
        habilidade += umJog.getCapPasse()*0.5;
        
        return habilidade;
    }
}
