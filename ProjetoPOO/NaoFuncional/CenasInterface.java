/************************ ISTO É PARA A INTERFACE **************************/

public static void main(String[] args){
    // ..............
    int escolha;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("O que pretende fazer?");

    System.out.println("1: Criar um novo jogador.");
    System.out.println("2: ...");
    System.out.println("3: ...");
    
    escolha = sc.nextInt();
    System.out.println("\n");
    
    switch(escolha){

        case 1:
            CriaJogTemp aux = new CriaJogTemp();
            aux.criaJogador();
            break;
        
        // case 2:
        // case 3:
        }    
    }
}

/**
* Método que cria um jogador consoante os valores atribuídos (pelo usuário) para as características do mesmo.
*/
public void criaJogador(){

    Scanner sc = new Scanner(System.in);

    System.out.println("Que jogador pretende criar: ");
    String id = sc.nextLine();
    System.out.println("\n");
        
    Jogador jog = new Jogador();

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

    double habilidade = 0.0;

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