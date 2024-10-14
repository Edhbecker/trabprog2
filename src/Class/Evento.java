package Class;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade_max;


    public Evento(String nome, String data, String local, int capacidade_max){
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade_max = capacidade_max;     
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
}
