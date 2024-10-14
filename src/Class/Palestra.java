package Class;

import java.util.List;

public class Palestra extends Evento {
    private int duracao;
    private List<String> temas;

    public Palestra(String nome, String data, String local, int capacidade_max, int duracao, List<String> temas){
        super(nome, data, local, capacidade_max);
        this.duracao = duracao;
        this.temas = temas;
    }


    public int getDuracao() {
        return duracao;
    }

    public List<String> getTemas() {
        return temas;
    }
}
