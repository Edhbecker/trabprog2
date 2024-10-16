import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.Evento;
import Class.Palestra;
import Class.Participante;
import Class.Reserva;
import Class.Workshop;

public class App {
    static ArrayList<Palestra> palestras = new ArrayList<>();
    static ArrayList<Workshop> workshops = new ArrayList<>();
    static ArrayList<Participante> participantes = new ArrayList<>();
    static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in); // Captura de string
        Scanner sc = new Scanner(System.in); // Captura de inteiros
        Scanner scan = new Scanner(System.in); // Captura de eventos
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nMenu");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Cadastrar Participante");
            System.out.println("3 - Gerenciar Reservas");
            System.out.println("4 - Visualizar Relatório");
            System.out.println("0 - Sair\n");
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();

            if (opcao == 1) {  // Implementar -> o palestrante também é um participante -- IMPLEMENTADO
                System.out.println("\n~Inicializando cadastro de Evento~\n");

                System.out.println("Tipo do Evento:");
                System.out.println("1 - Palestra");
                System.out.println("2 - Workshop");
                int tipoEvento = sc.nextInt();

                if (tipoEvento == 1) { //Palestra
                    boolean cadastro = true;
                    int resposta = 0;

                    while (cadastro) {
                        Evento dadosEvento = Evento.capturarDadosEvento(scan);
                        List<String> temas = new ArrayList<>();
                        List<Participante> participantes_evento = new ArrayList<>();

                        Participante dadosParticipante = Participante.capturarDadosParticipante(scan);
                        participantes_evento.add(new Participante(dadosParticipante.getNome(), dadosParticipante.getEmail(), dadosParticipante.getTipo()));

                        int v_duracao;

                        System.out.println("\nDuração do Evento(em Minutos):");
                        v_duracao = sc.nextInt();
                        
                        int contador = 0;
                        int int_temas = -1;

                        while (int_temas != 2) {
                            contador++;
                            String temaString;
                            System.out.format("Tema(%d):", contador);
                            temaString = s.nextLine();
                            temas.add(temaString);

                            System.out.print("Cadastrar mais temas? (1)Sim, (2)Não\n");
                            int_temas = sc.nextInt();
                            if (int_temas == 1) {
                                continue;
                            } else if (int_temas == 2) {
                                System.out.print("Temas cadastrados!\n");
                            } else if (int_temas < 1 || int_temas > 2) {
                                System.out.print("\nOpção inválida\n");
                            }
                        }
                        palestras.add(new Palestra(dadosEvento.getNome(), 
                        dadosEvento.getData(), 
                        dadosEvento.getLocal(), 
                        dadosEvento.getCapacidadeMax(), 
                        participantes_evento, 
                        v_duracao, 
                        temas));
                        //palestras.add(new Palestra(v_Nome, v_Data, v_Local, v_capacidade_max, v_duracao, temas));

                        System.out.println("Cadastrar mais Palestras? (1)Sim, (2)Não");
                        resposta = sc.nextInt();
                        if (resposta == 1) {
                            continue;
                        } else if (resposta == 2) {
                            cadastro = false;
                        } else if (resposta < 1 || resposta > 2) {
                            System.out.print("\nOpção inválida\n");
                        }
                    }
                    System.out.println("\n~Finalizado cadastro de Evento~\n");

                } else if (tipoEvento == 2) { //Workshop
                    boolean cadastro = true;
                    int resposta = 0;

                    while (cadastro) {
                        Evento dadosEvento = Evento.capturarDadosEvento(scan);
                        List<String> instrutores = new ArrayList<>();
                        List<String> materiais = new ArrayList<>();
                        int v_cargaHoraria;

                        System.out.println("\nCarga Horária do Evento(em Minutos):");
                        v_cargaHoraria = sc.nextInt();
                        
                        int contador_ins = 0;
                        int int_instrutor = -1;

                        while (int_instrutor != 2) {
                            contador_ins++;
                            String instrutorString;
                            System.out.format("Instrutor(%d):", contador_ins);
                            instrutorString = s.nextLine();
                            instrutores.add(instrutorString);

                            System.out.print("Cadastrar mais instrutor? (1)Sim, (2)Não\n");
                            int_instrutor = sc.nextInt();
                            if (int_instrutor == 1) {
                                continue;
                            } else if (int_instrutor == 2) {
                                System.out.print("Instrutores cadastrados!\n");
                            } else if (int_instrutor < 1 || int_instrutor > 2) {
                                System.out.print("\nOpção inválida\n");
                            }
                        }

                        int contador_mat = 0;
                        int int_material = -1;

                        while (int_material != 2) {
                            contador_mat++;
                            String materialString;
                            System.out.format("Material(%d):", contador_mat);
                            materialString = s.nextLine();
                            materiais.add(materialString);

                            System.out.print("Cadastrar mais material? (1)Sim, (2)Não\n");
                            int_material = sc.nextInt();
                            if (int_material == 1) {
                                continue;
                            } else if (int_material == 2) {
                                System.out.print("Materiais cadastrados!\n");
                            } else if (int_material < 1 || int_material > 2) {
                                System.out.print("\nOpção inválida\n");
                            }
                        }
                        workshops.add(new Workshop(dadosEvento.getNome(), 
                        dadosEvento.getData(), 
                        dadosEvento.getLocal(), 
                        dadosEvento.getCapacidadeMax(), 
                        instrutores, 
                        materiais, 
                        v_cargaHoraria));

                        System.out.println("Cadastrar mais Workshop's? (1)Sim, (2)Não");
                        resposta = sc.nextInt();
                        if (resposta == 1) {
                            continue;
                        } else if (resposta == 2) {
                            cadastro = false;
                        } else if (resposta < 1 || resposta > 2) {
                            System.out.print("\nOpção inválida\n");
                        }
                    }

                } else {
                    System.out.print("\nOpção inválida\n");
                }

            } else if (opcao == 2) {
                //cadastrarParticipante(s, sc);
                Participante dadosParticipante = Participante.capturarDadosParticipante(scan);
                participantes.add(new Participante(dadosParticipante.getNome(), dadosParticipante.getEmail(), dadosParticipante.getTipo()));
                System.out.println("Participante cadastrado com sucesso!\n");
            
            } else if (opcao == 3) {
                    System.out.println("\n~Gerenciamento de Reservas~\n");
                    System.out.println("1 - Adicionar Reserva");
                    System.out.println("2 - Cancelar Reserva");
                    System.out.println("3 - Listar Reservas");
                    int opcaoReserva = sc.nextInt();
                
                    if (opcaoReserva == 1) {
                        adicionarReserva(s);
                    } else if (opcaoReserva == 2) {
                        cancelarReserva(sc);
                    } else if (opcaoReserva == 3) {
                        listarReservas();
                    } else {
                        System.out.print("\nOpção inválida\n");
                    }
                
            } else if (opcao == 4) {
                gerarRelatorios();
                //int resposta = -1;  //Implementar
                //if (resposta == 1){} // Gerar relatórios com a lista de eventos cadastrados e a quantidade de participantes em cada um
                //else if (resposta == 2) {} // - Implementar métodos para listar todos os participantes de um evento específico e também os participantes VIP.

            } else if (opcao < 0 || opcao > 4) {
                System.out.print("Opção inválida");
            }

            System.out.println();
        }
        s.close();
        sc.close();
        scan.close();
        System.out.println("\n~Finalizado~\n");
    }



    
/*  Removido
    private static void cadastrarParticipante(Scanner s, Scanner sc) {
        System.out.println("\n~Inicializando cadastro de Participante~\n");

        String nome;
        String email;
        int tipo;

        System.out.println("Nome do Participante:");
        s.nextLine(); // Limpar o buffer do scanner
        nome = s.nextLine();

        System.out.println("Email do Participante:");
        email = s.nextLine();

        System.out.println("Tipo do Participante:");
        System.out.println("1 - Normal");
        System.out.println("2 - VIP");
        tipo = sc.nextInt();

        Participante participante = new Participante(nome, email, tipo);
        participantes.add(participante);

        System.out.println("\nParticipante cadastrado com sucesso!\n");
    }
*/
    private static void gerarRelatorios() {
        System.out.println("\n~Relatório de Eventos~");
        for (Palestra palestra : palestras) {
            System.out.printf("Evento: %s, Data: %s, Local: %s, Capacidade Máxima: %d, Duração: %d minutos\n",
                    palestra.getNome(), palestra.getData(), palestra.getLocal(), palestra.getCapacidadeMax(), palestra.getDuracao());
            System.out.printf("Total de Participantes: %d\n", contarParticipantesPorEvento(palestra));
            System.out.println();
        }

        System.out.println("~Participantes~");
        for (Participante participante : participantes) {
            System.out.printf("Nome: %s, Email: %s, Tipo: %s\n", 
                participante.getNome(), participante.getEmail(), participante.getTipo() == 1 ? "Normal" : "VIP");
        }
    }

    private static int contarParticipantesPorEvento(Palestra palestra) {
        int contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getEvento().equals(palestra)) {
                contador++;
            }
        }
        return contador;
    }    

    private static void adicionarReserva(Scanner sc) {
        // Listar os eventos disponíveis
        System.out.println("Selecione um evento para reservar:");
        for (int i = 0; i < palestras.size(); i++) {
            Palestra palestra = palestras.get(i);
            System.out.printf("%d - %s (Capacidade Máxima: %d)\n", i + 1, palestra.getNome(), palestra.getCapacidadeMax());
        }
    
        int eventoEscolhido = sc.nextInt() - 1;
        if (eventoEscolhido < 0 || eventoEscolhido >= palestras.size()) {
            System.out.println("Evento inválido!");
            return;
        }
    
        Evento evento = palestras.get(eventoEscolhido);
        if (contarParticipantesPorEvento((Palestra) evento) >= evento.getCapacidadeMax()) {
            System.out.println("Não é possível adicionar reserva. Capacidade máxima atingida.");
            return;
        }
    
        // Listar participantes já cadastrados
        if (participantes.isEmpty()) {
            System.out.println("Não há participantes cadastrados.");
            return;
        }
    
        System.out.println("Selecione um participante cadastrado:");
        for (int i = 0; i < participantes.size(); i++) {
            Participante participante = participantes.get(i);
            System.out.printf("%d - Nome: %s, Email: %s, Tipo: %s\n",
                    i + 1, participante.getNome(), participante.getEmail(), participante.getTipo() == 1 ? "Normal" : "VIP");
        }
    
        int participanteEscolhido = sc.nextInt() - 1;
        if (participanteEscolhido < 0 || participanteEscolhido >= participantes.size()) {
            System.out.println("Participante inválido!");
            return;
        }
    
        Participante participante = participantes.get(participanteEscolhido);
        Reserva novaReserva = new Reserva(participante, evento);
        reservas.add(novaReserva);
        System.out.println("Reserva adicionada com sucesso!");
    }
    
    

private static void cancelarReserva(Scanner sc) {
    System.out.println("Lista de Reservas:");
    for (int i = 0; i < reservas.size(); i++) {
        Reserva reserva = reservas.get(i);
        System.out.printf("%d - Participante: %s, Evento: %s\n", i + 1, reserva.getParticipante().getNome(), reserva.getEvento().getNome());
    }

    System.out.print("Digite o número da reserva a ser cancelada: ");
    int reservaEscolhida = sc.nextInt() - 1;
    if (reservaEscolhida < 0 || reservaEscolhida >= reservas.size()) {
        System.out.println("Reserva inválida!");
        return;
    }

    reservas.remove(reservaEscolhida);
    System.out.println("Reserva cancelada com sucesso!");
}

private static void listarReservas() {
    System.out.println("\n~Reservas Atuais~");
    for (Reserva reserva : reservas) {
        System.out.printf("Participante: %s, Evento: %s\n", reserva.getParticipante().getNome(), reserva.getEvento().getNome());
    }
}

}

