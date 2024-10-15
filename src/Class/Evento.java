package Class;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade_max;
    private List<Participante> participantes;

    public Evento(String nome, String data, String local, int capacidade_max) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade_max = capacidade_max;
        this.participantes = new ArrayList<>();  // Inicializa a lista de participantes
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public int getCapacidadeMax() {
        return capacidade_max;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void adicionarParticipante(Participante participante) {
        if (participantes.size() < capacidade_max) {
            participantes.add(participante);
        } else {
            System.out.println("Capacidade máxima atingida para o evento: " + nome);
        }
    }
}
