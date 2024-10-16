package Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade_max;
    protected List<Participante> participantes;

    public Evento(String nome, String data, String local, int capacidade_max) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade_max = capacidade_max;
        this.participantes = new ArrayList<>();
    }

    public static Evento capturarDadosEvento(Scanner s) {
        System.out.println("\nNome do Evento:");
        String nome = s.nextLine();

        System.out.println("\nData do Evento:");
        String data = s.nextLine();

        System.out.println("\nLocal:");
        String local = s.nextLine();

        System.out.println("\nCapacidade máxima:");
        int capacidadeMax = s.nextInt();

        return new Evento(nome, data, local, capacidadeMax);
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

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void adicionarParticipante(Participante participante) {
        if (participantes.size() < capacidade_max) {
            participantes.add(participante);
        } else {
            System.out.println("Capacidade máxima atingida para o evento: " + nome);
        }
    }
}
