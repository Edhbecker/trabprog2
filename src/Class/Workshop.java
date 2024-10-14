package Class;

import java.util.List;

public class Workshop extends Evento {
    private List<String> instrutor;
    private List<String> material;
    private int cargaHoraria;


    public Workshop(String nome, String data, String local, int capacidade_max, 
    List<String> instrutores, List<String> materiais, int cargaHoraria) {
        super(nome, data, local, capacidade_max);
        this.instrutor = instrutores;
        this.material = materiais;
        this.cargaHoraria = cargaHoraria;
        }
}
