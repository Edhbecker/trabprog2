package Class;

import java.util.Scanner;

public class Participante {
    private String nome;
    private String email;
    private int tipo; // 1: Normal, 2: VIP

    public Participante(String nome, String email, int tipo) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public static Participante capturarDadosParticipante(Scanner s) {
        System.out.println("\nNome do Participante:");
        String nome = s.nextLine();
        s.nextLine();

        System.out.println("\nE-mail:");
        String email = s.nextLine();

        System.out.println("\nTipo do Participante:");
        System.out.println("1 - Normal");
        System.out.println("2 - VIP");
        int tipoParticipante = s.nextInt();

        return new Participante(nome, email, tipoParticipante);
    }
}
