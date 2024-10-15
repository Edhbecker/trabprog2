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

    public List<String> getInstrutores() {
        return instrutor;
    }

    public void setInstrutores(List<String> instrutor) {
        this.instrutor = instrutor;
    }

    public List<String> getMateriais() {
        return material;
    }

    public void setMateriais(List<String> material) {
        this.material = material;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
