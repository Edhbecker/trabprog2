package Class;

import java.util.Scanner;

public class Participante {
    private String nome;
    private String email;
    private int tipo; // 1: Normal, 2: VIP / 3: Palestrante 4: Instrutor

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

    public static Participante capturarDadosParticipante(Scanner s, boolean cadastro_part_participante, int valida_tipo, int contador_cadastro, boolean exec_limpaBuffer) {
        int tipoParticipante = 0; //Inicializado com 0, pois não estava aceitando a inicialização sem a atribuição de valor

        System.out.println("\nNome do Participante:");
        String nome = s.nextLine();

        limpaBuffer_func(s, contador_cadastro, exec_limpaBuffer);

        System.out.println("\nE-mail:");
        String email = s.nextLine();

        if (cadastro_part_participante == true){
            System.out.println("\nTipo do Participante:");
            System.out.println("1 - Normal");
            System.out.println("2 - VIP");
            System.out.println("3 - Palestrante");
            System.out.println("4 - Instrutor");
            tipoParticipante = s.nextInt();

            if (tipoParticipante < 1 || tipoParticipante > 4){
                System.out.println("\n~Tipo informado é inexistente~");
            } 
        }
        else {
            if (cadastro_part_participante == false && valida_tipo == 3) {
                System.out.println("Palestrante");
                tipoParticipante = 3;
            }
            else if (cadastro_part_participante == false && valida_tipo == 4){
                System.out.println("Instrutor");
                tipoParticipante = 4;
            }
        }

        return new Participante(nome, email, tipoParticipante);
    }

    public static void limpaBuffer_func(Scanner s, int contador, boolean exec){
        if (contador > 1 || exec) {
            s.nextLine();
        }
    }
}
