package Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workshop extends Evento {
    private List<String> instrutores;  
    private List<String> materiais;     
    private int cargaHoraria;

    public Workshop(String nome, String data, String local, int capacidade_max, 
                    List<String> instrutores, List<String> materiais, int cargaHoraria) {
        super(nome, data, local, capacidade_max);
        this.instrutores = instrutores;
        this.materiais = materiais;
        this.cargaHoraria = cargaHoraria;
    }

    public List<String> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<String> instrutores) {
        this.instrutores = instrutores;
    }

    public List<String> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<String> materiais) {
        this.materiais = materiais;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // Método para capturar dados específicos do Workshop
    public static Workshop capturarDadosWorkshop(Scanner s) {
        System.out.println("\nNome do Workshop:");
        String nome = s.nextLine();

        System.out.println("\nData do Workshop:");
        String data = s.nextLine();

        System.out.println("\nLocal:");
        String local = s.nextLine();

        System.out.println("\nCapacidade máxima:");
        int capacidadeMax = s.nextInt();
        s.nextLine(); // Limpa o buffer

        System.out.println("\nCarga Horária:");
        int cargaHoraria = s.nextInt();
        s.nextLine(); // Limpa o buffer

        System.out.println("\nInstrutores (separados por vírgula):");
        String[] instrutoresArray = s.nextLine().split(",");
        List<String> instrutores = new ArrayList<>(); // Usando ArrayList para permitir modificações
        for (String instrutor : instrutoresArray) {
            instrutores.add(instrutor.trim()); // Remove espaços em branco
        }

        System.out.println("\nMateriais (separados por vírgula):");
        String[] materiaisArray = s.nextLine().split(",");
        List<String> materiais = new ArrayList<>(); // Usando ArrayList para permitir modificações
        for (String material : materiaisArray) {
            materiais.add(material.trim()); // Remove espaços em branco
        }

        return new Workshop(nome, data, local, capacidadeMax, instrutores, materiais, cargaHoraria);
    }
}
