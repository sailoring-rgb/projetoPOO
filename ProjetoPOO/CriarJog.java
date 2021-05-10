/**
 * Escreva a descrição da classe CriarJog aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.*;

public class CriarJog
{
    /**
     * Método que pergunta ao usuário que tipo de jogador pretende criar.
     * @return o número da opção
     */
    public int qualJog()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Que jogador pretende criar?");
        System.out.println("1: Avançado");
        System.out.println("2: Lateral");
        System.out.println("3: Médio");
        System.out.println("4: Defesa");
        System.out.println("5: Guarda Redes");
        
        int jogEscolhido = sc.nextInt();
        return jogEscolhido;
    }

    /**
     * Método que pede ao usuário valores para as características do tipo de jogador que escolheu.
     * Este método calcula, ainda, a habilidade do dito jogador consoante os valores dados.
     * @param o número da opção
     */
    public void escJogador(int jogEscolhido)
    {
        Jogador jog = new Jogador();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Os valores atribuídos as carateristicas tem estar entre 0 e 100");
        
        System.out.println("Velocidade: ");
        double velocidade = sc.nextDouble();
        if (velocidade < 0 || velocidade > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            velocidade = sc.nextDouble();
        }
        jog.setVelocidade(velocidade);
        
        System.out.println("Resistência: ");
        double resistencia = sc.nextDouble();
        if (resistencia < 0 || resistencia > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            resistencia = sc.nextDouble();
        }
        jog.setResistencia(resistencia);

        System.out.println("Destreza: ");
        double destreza = sc.nextDouble();
        if (destreza < 0 || destreza > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            destreza = sc.nextDouble();
        }
        jog.setDestreza(destreza);

        System.out.println("Impulsão: ");
        double impulsao = sc.nextDouble();
        if (impulsao < 0 || impulsao > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            impulsao = sc.nextDouble();
        }
        jog.setImpulsao(impulsao);

        System.out.println("Jogo de Cabeça: ");
        double jogoCabeca = sc.nextDouble();
        if (jogoCabeca < 0 || jogoCabeca > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            jogoCabeca = sc.nextDouble();
        }
        jog.setJogoCabeca(jogoCabeca);

        System.out.println("Remate: ");
        double remate = sc.nextDouble();
        if (remate < 0 || remate > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            remate = sc.nextDouble();
        }
        jog.setRemate(remate);

        System.out.println("Capaciadade de passe: ");
        double capPasse = sc.nextDouble();
        if (capPasse < 0 || capPasse > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            capPasse = sc.nextDouble();
        }
        jog.setCapPasse(capPasse);
        
        double habilidade = 0;
        
              switch(jogEscolhido){
        
                    case 1:
                        Avancado jogAvancado = new Avancado();
                    
                        System.out.println("Drible: ");
                        double drible = sc.nextDouble();
                        if (drible < 0 || drible > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            drible = sc.nextDouble();
                        }
                        jogAvancado.setDrible(drible);
        
                        habilidade = jogAvancado.habAvancado(jog);
                        System.out.println("Habilidade do avançado: " + habilidade);
                        break;
            
                    case 2:
                        Lateral jogLateral = new Lateral();
        
                        System.out.println("Capaciadade de cruzamento: ");                       
                        double capCruzamento = sc.nextDouble();
                        if (capCruzamento < 0 || capCruzamento > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            capCruzamento = sc.nextDouble();
                        }                         
                        jogLateral.setCapCruzamento(capCruzamento);
        
                        habilidade = jogLateral.habLateral(jog);
                        System.out.println("Habilidade do lateral: " + habilidade);
                        break;
        
                    case 3:
                        Medio jogMedio = new Medio();
        
                        System.out.println("Capacidade de recuperação: ");
                        double capRecuperacao = sc.nextDouble();
                        if (capRecuperacao < 0 || capRecuperacao > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            capRecuperacao = sc.nextDouble();
                        }                        
                        jogMedio.setCapRecuperacao(capRecuperacao);
        
                        System.out.println("Dominio de bola: ");
                        double dominioBola = sc.nextDouble();
                        if (dominioBola < 0 || dominioBola > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            dominioBola = sc.nextDouble();
                        }                        
                        jogMedio.setDominioBola(dominioBola);
        
                        habilidade = jogMedio.habMedio(jog);
                        System.out.println("Habilidade do médio: " + habilidade);
                        break;
        
                    case 4:
                        Defesa jogDefesa = new Defesa();
        
                        System.out.println("Desarme: ");
                        double desarme = sc.nextDouble();
                        if (desarme < 0 || desarme > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            desarme = sc.nextDouble();
                        }                        
                        jogDefesa.setDesarme(desarme);
        
                        habilidade = jogDefesa.habDefesa(jog);
                        System.out.println("Habilidade do defesa: " + habilidade);
                        break;
        
                    case 5:
                        GuardaRedes jogGR = new GuardaRedes();
        
                        System.out.println("Elastecidade: ");
                        double elasticidade = sc.nextDouble();
                        if (elasticidade < 0 || elasticidade > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            elasticidade = sc.nextDouble();
                        }                        
                        jogGR.setElasticidade(elasticidade);
        
                        System.out.println("Lançamento: ");
                        double lancamento = sc.nextDouble();
                        if (lancamento < 0 || lancamento > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            lancamento = sc.nextDouble();
                        }                        
                        jogGR.setLancamento(lancamento);
        
                        habilidade = jogGR.habGuardaRedes(jog);
                        System.out.println("Habilidade do guarda-redes: " + habilidade);
                        break;
        }
    }
    
    public void atribEq(Jogador jog)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("A que equipa pretende associar este jogador?");
        //Verificar todas as equipas existentes
        
    }
}