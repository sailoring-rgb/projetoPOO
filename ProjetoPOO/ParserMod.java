import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserMod {
    public static Data parse() throws LinhaIncorretaMod {
        List<String> linhas = lerFicheiro("dados.txt");
        Map<String, Equipa> equipas = new HashMap<>(); //nome, equipa
        Map<Integer, Jogador> jogadores = new HashMap<>(); //numero, jogador
        List<EstadoJogo> jogos = new ArrayList<>();
        Equipa ultima = null; Jogador j = null;
        String[] linhaPartida;
        
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = GuardaRedes.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaMod(); //we need to insert the player into the team
                    ultima.insereJogadores(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaMod(); //we need to insert the player into the team
                    ultima.insereJogadores(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaMod(); //we need to insert the player into the team
                    ultima.insereJogadores(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaMod(); //we need to insert the player into the team
                    ultima.insereJogadores(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaMod(); //we need to insert the player into the team
                    ultima.insereJogadores(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    EstadoJogo jo = EstadoJogo.parse(linhaPartida[1]);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaMod();

            }
        }

        //debug
        for (Equipa e: equipas.values()){
            System.out.println(e.toString());
        }
        for (EstadoJogo jog: jogos){
            System.out.println(jog.toString());
        }

        Data data = new Data(equipas,jogadores,jogos);
        return data;
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }


}
