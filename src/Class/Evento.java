package Class;

import java.util.List;
import java.util.Date;

public class Evento {
    String nome;
    Date data;
    String local;
    int capacidade_max;
    List<String> participantes;


    public void criarEvento(String nome, Date data, String local, String participante){
        this.nome = nome;
        this.data = data;
        this.local = local;
        //this.participantes.append(participante);
    }
}
