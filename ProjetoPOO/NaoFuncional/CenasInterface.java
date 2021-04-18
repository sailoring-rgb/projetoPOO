// o usuário cria o jogador
public void criaJogador(){

    System.out.println("Que jogador pretende criar: ");
    String id = sc.nextLine();

    Jogador jog = new Jogador();

    System.out.println("Os valores atribuídos as carateristicas tem estar entre 0 e 10");

    System.out.println("Velocidade: ");
    double velocidade = sc.nextLine();
    jog.setVelocidade(velocidade);

    System.out.println("Resistência: ");
    double resistencia = sc.nextLine();
    jog.setResistencia(resistencia);

    System.out.println("Destreza: ");
    double destreza = sc.nextLine();
    jog.setDestreza(destreza);

    System.out.println("Impulsão: ");
    double impulsao = sc.nextLine();
    jog.setImpulsao(impulsao);

    System.out.println("Jogo de Cabeça: ");
    double jogoCabeca = sc.nextLine();
    jog.setJogoCabeca(jogoCabeca);

    System.out.println("Remate: ");
    double remate = sc.nextLine();
    jog.setRemate(remate);

    System.out.println("Capaciadade de passe: ");
    double capPasse= sc.nextLine();
    jog.setCapPasse(capPasse);

    double habilidade = 0.0;

    switch(id){

        case "avançado":
            System.out.println("Drible: ");
            double drible = sc.nextLine();
            jog.setDrible(drible);

            habilidade = jog.habAvancado(jog);
            System.out.println("Habilidade do jogador: " + habilidade);
            break;
    
        case "lateral":
            System.out.println("Capaciadade de cruzamento: ");
            double capCruzamento = sc.nextLine();
            jog.setCapCruzamento(capCruzamento);

            habilidade = jog.habLateral(jog);
            System.out.println("Habilidade do jogador: " + habilidade);
            break;

        case "médio":
            System.out.println("Capacidade de recuperação: ");
            double capRecuperacao = sc.nextLine();
            jog.setCapRecuperacao(capRecuperacao);

            System.out.println("Dominio de bola: ");
            double dominioBola = sc.nextLine();
            jog.setDominioBola(dominioBola);

            habilidade = jog.habMedio(jog);
            System.out.println("Habilidade do jogador: " + habilidade);
            break;

        case "defesa":
            System.out.println("Desarme: ");
            double desarme = sc.nextLine();
            jog.setDesarme(desarme);

            habilidade = jog.habDefesa(jog);
            System.out.println("Habilidade do jogador: " + habilidade);
            break;

        case "guarda redes":
            System.out.println("Elastecidade: ");
            double elasticidade = sc.nextLine();
            jog.setElasticidade(elasticidade);

            System.out.println("Lançamento: ");
            double lancamento = sc.nextLine();
            jog.setLancamento(lancamento);

            habilidade = jog.habGuardaRedes(jog);
            System.out.println("Habilidade do jogador: " + habilidade);
            break;
    }
}