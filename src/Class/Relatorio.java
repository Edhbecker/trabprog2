package Class;

import java.util.List;

public class Relatorio {

    // Método para emitir o relatório de eventos e participantes
    public static void emitirRelatorio(List<Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("Sem eventos cadastrados para emissão de relatório.");
            return;
        }

        for (Evento evento : eventos) {
            emitirRelatorioEvento(evento);
        }
    }

    // Método privado para emitir o relatório de um evento específico
    private static void emitirRelatorioEvento(Evento evento) {
        System.out.println("Evento: " + evento.getNome());
        System.out.println("Data: " + evento.getData());
        System.out.println("Local: " + evento.getLocal());
        System.out.println("Capacidade Máxima: " + evento.getCapacidadeMax());
        System.out.println("Total de Participantes: " + evento.getTotalParticipantes());
        System.out.println("Participantes:");

        // Obter todos os participantes do evento (cadastrados e vinculados por reservas)
        List<Participante> todosParticipantes = evento.getTodosParticipantes();
        if (todosParticipantes.isEmpty()) {
            System.out.println("Nenhum participante cadastrado.");
        } else {
            for (Participante participante : todosParticipantes) {
                System.out.println(" - " + participante.getNome() + " (Tipo: " + tipoParticipante(participante.getTipo()) + ")");
            }
        }

        System.out.println(); // Linha em branco para separar os eventos
    }

    // Método privado para retornar o tipo do participante em formato de string
    private static String tipoParticipante(int tipo) {
        switch (tipo) {
            case 1:
                return "Normal";
            case 2:
                return "VIP";
            case 3:
                return "Palestrante";
            case 4:
                return "Instrutor";
            default:
                return "Desconhecido";
        }
    }
}
