package Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidadeMax;
    protected List<Participante> participantes; // Lista de participantes diretos
    protected List<Reserva> reservas; // Lista para armazenar reservas

    public Evento(String nome, String data, String local, int capacidadeMax) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMax = capacidadeMax;
        this.participantes = new ArrayList<>();
        this.reservas = new ArrayList<>(); // Inicializa a lista de reservas
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
        s.nextLine(); // Limpar o buffer após ler um número

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
        return capacidadeMax;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void adicionarParticipante(Participante participante) {
        if (participantes.size() < capacidadeMax) {
            participantes.add(participante);
        } else {
            System.out.println("Capacidade máxima atingida para o evento: " + nome);
        }
    }

    // Método para adicionar uma reserva
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Método para obter todos os participantes (diretos e por reservas)
    public List<Participante> getTodosParticipantes() {
        List<Participante> todosParticipantes = new ArrayList<>(participantes);
        for (Reserva reserva : reservas) {
            if (!todosParticipantes.contains(reserva.getParticipante())) { // Evita duplicatas
                todosParticipantes.add(reserva.getParticipante());
            }
        }
        return todosParticipantes;
    }

    // Método para obter o total de participantes (diretos e por reservas)
    public int getTotalParticipantes() {
        return getTodosParticipantes().size();
    }
}
