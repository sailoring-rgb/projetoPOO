import java.util.*;

/**
 * Escreva a descrição da classe CriarJog aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CriarJog
{
    private int id;
    private double habilidade;
    
    /**
     * COnstrutor para objetos da classe CriarJog
     */
    public CriarJog()
    {
        Scanner sc = new Scanner(System.in);
        Jogador jog = new Jogador();
        
        System.out.println("Que jogador pretende criar?");
        System.out.println("1: Guarda-Redes");
        System.out.println("2: Defesa");
        System.out.println("3: Médio");
        System.out.println("4: Lateral");
        System.out.println("5: Avançado");
        
        Double id = sc.nextDouble();
    }

    public int DivHabilidade(int id)
    {
        System.out.println("Os valores atribuídos as carateristicas tem estar entre 0 e 10");

        System.out.println("Velocidade: ");
        double velocidade = sc.nextDouble();
        jog.setVelocidade(velocidade);

        System.out.println("Resistência: ");
        double resistencia = sc.nextDouble();
        jog.setResistencia(resistencia);

        System.out.println("Destreza: ");
        double destreza = sc.nextDouble();
        jog.setDestreza(destreza);

        System.out.println("Impulsão: ");
        double impulsao = sc.nextDouble();
        jog.setImpulsao(impulsao);

        System.out.println("Jogo de Cabeça: ");
        double jogoCabeca = sc.nextDouble();
        jog.setJogoCabeca(jogoCabeca);

        System.out.println("Remate: ");
        double remate = sc.nextDouble();
        jog.setRemate(remate);

        System.out.println("Capaciadade de passe: ");
        double capPasse= sc.nextDouble();
        jog.setCapPasse(capPasse);
        
    }
    
    public int DivHabilidade(int id)
    {
                switch(id){
        
                    case "Avançado":
                        Avancado jogAvancado = new Avancado();
                    
                        System.out.println("Drible: ");
                        double drible = sc.nextDouble();
                        jogAvancado.setDrible(drible);
        
                        habilidade = jogAvancado.habAvancado(jog);
                        System.out.println("Habilidade do avançado: " + habilidade);
                        break;
            
                        case "Lateral":
                        Lateral jogLateral = new Lateral();
        
                        System.out.println("Capaciadade de cruzamento: ");
                        double capCruzamento = sc.nextDouble();
                        jogLateral.setCapCruzamento(capCruzamento);
        
                        habilidade = jogLateral.habLateral(jog);
                        System.out.println("Habilidade do lateral: " + habilidade);
                        break;
        
                    case "Médio":
                        Medio jogMedio = new Medio();
        
                        System.out.println("Capacidade de recuperação: ");
                        double capRecuperacao = sc.nextDouble();
                        jogMedio.setCapRecuperacao(capRecuperacao);
        
                        System.out.println("Dominio de bola: ");
                        double dominioBola = sc.nextDouble();
                        jogMedio.setDominioBola(dominioBola);
        
                        habilidade = jogMedio.habMedio(jog);
                        System.out.println("Habilidade do médio: " + habilidade);
                        break;
        
                    case "Defesa":
                        Defesa jogDefesa = new Defesa();
        
                        System.out.println("Desarme: ");
                        double desarme = sc.nextDouble();
                        jogDefesa.setDesarme(desarme);
        
                        habilidade = jogDefesa.habDefesa(jog);
                        System.out.println("Habilidade do defesa: " + habilidade);
                        break;
        
                    case "Guarda-redes":
                        GuardaRedes jogGR = new GuardaRedes();
        
                        System.out.println("Elastecidade: ");
                        double elasticidade = sc.nextDouble();
                        jogGR.setElasticidade(elasticidade);
        
                        System.out.println("Lançamento: ");
                        double lancamento = sc.nextDouble();
                        jogGR.setLancamento(lancamento);
        
                        habilidade = jogGR.habGuardaRedes(jog);
                        System.out.println("Habilidade do guarda-redes: " + habilidade);
                        break;
        } 
    }
