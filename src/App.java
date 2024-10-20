import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        Scanner scan_eve = new Scanner(System.in); // Captura de eventos
        Scanner scan_part = new Scanner(System.in); // Captura de participantes

        Scanner limpa_Buffer = new Scanner(System.in);

        int opcao = -1;
        int tipo_part_palestrante = 3;  //Define o tipo de participante no cadastro de evento;
        int tipo_part_instrutor = 4;    //Define o tipo de participante no cadastro de evento;

        boolean moreThanOneExecution_cadastro_participante = false;


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
                        Evento dadosEvento = Evento.capturarDadosEvento(scan_eve);

                        List<String> temas = new ArrayList<>();
                        List<Participante> participantes_evento = new ArrayList<>();

                        System.out.print("~Cadastro de Palestrante~");

                        Participante dadosParticipante = Participante.capturarDadosParticipante(scan_part, false, tipo_part_palestrante, 0, false);//passado false, pois o participante é um Palestrante apenas;
                        
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
                            } else {
                                System.out.print("\nOpção inválida\n");
                                break;
                            }
                        }
                        palestras.add(new Palestra(dadosEvento.getNome(), 
                        dadosEvento.getData(), 
                        dadosEvento.getLocal(), 
                        dadosEvento.getCapacidadeMax(), 
                        participantes_evento, 
                        v_duracao, 
                        temas));
                    
                        System.out.println("Cadastrar mais Palestras? (1)Sim, (2)Não");
                        resposta = sc.nextInt();
                        if (resposta == 1) {
                            continue;
                        } else if (resposta == 2) {
                            cadastro = false;
                        } else {
                            System.out.print("\nOpção inválida\n");
                            break;
                        }
                    }
                    System.out.println("\n~Finalizado cadastro de Evento~\n");

                } else if (tipoEvento == 2) { //Workshop
                    boolean cadastro = true;
                    int resposta = 0;

                    while (cadastro) {
                        Evento dadosEvento = Evento.capturarDadosEvento(scan_eve);
                        List<String> instrutores = new ArrayList<>();
                        List<String> materiais = new ArrayList<>();
                        int v_cargaHoraria;

                        System.out.println("\nCarga Horária do Evento(em Minutos):");
                        v_cargaHoraria = sc.nextInt();
                        
                        int contador_ins = 0;
                        int int_instrutor = -1;

                        while (int_instrutor != 2) {
                            contador_ins++;
                            //String instrutorString;
                            System.out.format("(%d)Cadastro de Instrutor:", contador_ins);
                            List<Participante> participantes_instrutor = new ArrayList<>();

                            Participante dadosParticipante = Participante.capturarDadosParticipante(scan_part, false, tipo_part_instrutor, 0, false); //passado false, pois o participante é um instrutor apenas;

                            participantes_instrutor.add(new Participante(dadosParticipante.getNome(), 
                            dadosParticipante.getEmail(), 
                            dadosParticipante.getTipo()));

                            System.out.print("Cadastrar mais instrutor? (1)Sim, (2)Não\n");
                            int_instrutor = sc.nextInt();
                            if (int_instrutor == 1) {
                                continue;
                            } else if (int_instrutor == 2) {
                                System.out.print("Instrutores cadastrados!\n");
                            } else {
                                System.out.print("\nOpção inválida\n");
                                break;
                            }
                        }

                        int contador_mat = 0;
                        int int_material = -1;

                        while (int_material != 2 && cadastro == true) {
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
                            } else {
                                System.out.print("\nOpção inválida\n");
                                break;
                            }
                        }

                        if (cadastro == true){
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
                            } else {
                                System.out.print("\nOpção inválida\n");
                            }
                        }
                    }

                } else {
                    System.out.print("\nOpção inválida\n");
                }

            } else if (opcao == 2) {
                boolean cadastro_part = true;
                int contador_cadastro = 0;
            
                while (cadastro_part) {
                    contador_cadastro++;
                    Participante dadosParticipante = Participante.capturarDadosParticipante(scan_part, true, 0, contador_cadastro, moreThanOneExecution_cadastro_participante); //informando 0 pois o cadastro pode ser qualquer tipo(Normal/VIP/Palestrante/Instrutor);
            
                    boolean tipo_part = validaTipo(dadosParticipante.getTipo());
            
                    if (tipo_part) { // Validação do TIPO PARTICIPANTE se está dentro das opções sugeridas
                        participantes.add(new Participante(dadosParticipante.getNome(), 
                        dadosParticipante.getEmail(), 
                        dadosParticipante.getTipo()));
            
                        moreThanOneExecution_cadastro_participante = true; // Limpa buffer;
            
                        System.out.println("Participante cadastrado com sucesso!\n");
                        
                        System.out.println("Cadastrar mais Participantes? (1)Sim, (2)Não");
                        int resposta = sc.nextInt();
                        if (resposta == 1) {
                            continue;
                        } else if (resposta == 2) {
                            cadastro_part = false;
                        } else {
                            System.out.print("\nOpção inválida\n");
                            break;
                        }
                    } else {
                        System.out.println("Tipo de participante inválido! Tente novamente.");
                    }
                }
            
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
                // Sub-menu para escolha de tipo de relatório
                System.out.println("\nEscolha o Relatório que deseja visualizar:");
                System.out.println("1 - Relatório de Eventos");
                System.out.println("2 - Relatório de Participantes por Evento");
                int tipoRelatorio = sc.nextInt();

                if (tipoRelatorio == 1) {
                    gerarRelatorioEventos();  // Chamando o método que gera o relatório de eventos
                } else if (tipoRelatorio == 2) {
                    gerarRelatorioParticipantesPorEvento(sc);  // Chamando o método que gera o relatório de participantes por evento
                } else {
                    System.out.println("Opção inválida!");
                }
            } else if (opcao < 0 || opcao > 4) {
                System.out.print("Opção inválida");
            }

            System.out.println();
        }
        s.close();
        sc.close();
        scan_eve.close();
        scan_part.close();
        limpa_Buffer.close();
        System.out.println("\n~Finalizado~\n");
    }



    private static void gerarRelatorioEventos() {
        System.out.println("\n~Relatório de Eventos~");
    
        // Relatório de Palestras
        System.out.println("Palestras:");
        for (Palestra palestra : palestras) {
            System.out.printf("Evento: %s, Data: %s, Local: %s, Capacidade Máxima: %d\n",
                    palestra.getNome(), palestra.getData(), palestra.getLocal(), palestra.getCapacidadeMax());
            
            int totalParticipantes = contarParticipantesPorEvento(palestra); 
            System.out.printf("Total de Participantes: %d\n\n", totalParticipantes);
        }
    
        // Relatório de Workshops
        System.out.println("Workshops:");
        for (Workshop workshop : workshops) {
            System.out.printf("Evento: %s, Data: %s, Local: %s, Capacidade Máxima: %d\n",
                    workshop.getNome(), workshop.getData(), workshop.getLocal(), workshop.getCapacidadeMax());
            
            int totalParticipantes = contarParticipantesPorEvento(workshop); 
            System.out.printf("Total de Participantes: %d\n\n", totalParticipantes);
        }
    }
    
    

    private static void gerarRelatorioParticipantesPorEvento(Scanner sc) {
        System.out.println("\nSelecione o tipo de evento:");
        System.out.println("1 - Palestra");
        System.out.println("2 - Workshop");
        int tipoEvento = sc.nextInt();
    
        if (tipoEvento == 1) { // Relatório de Palestra
            if (palestras.isEmpty()) {
                System.out.println("Sem palestras cadastradas para emissão de relatório.");
            } else {
                System.out.println("\nSelecione a Palestra:");
                for (int i = 0; i < palestras.size(); i++) {
                    System.out.printf("%d - %s\n", i + 1, palestras.get(i).getNome());
                }
                int index = sc.nextInt() - 1;
    
                if (index >= 0 && index < palestras.size()) {
                    Palestra palestraSelecionada = palestras.get(index);
                    System.out.printf("\nPalestra Selecionada: %s\n", palestraSelecionada.getNome());
    
                    // Criar uma nova lista para todos os participantes
                    List<Participante> todosParticipantes = new ArrayList<>(palestraSelecionada.getParticipantes());
    
                    // Adicionar participantes que têm reservas para a palestra
                    for (Reserva reserva : reservas) {
                        if (reserva.getEvento().equals(palestraSelecionada)) {
                            todosParticipantes.add(reserva.getParticipante());
                        }
                    }
    
                    // Remover duplicatas da lista (se o mesmo participante estiver registrado de ambas as maneiras)
                    todosParticipantes = todosParticipantes.stream().distinct().collect(Collectors.toList());
    
                    listarParticipantes(todosParticipantes);
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } else if (tipoEvento == 2) { // Relatório de Workshop
            if (workshops.isEmpty()) {
                System.out.println("Sem workshops cadastrados para emissão de relatório.");
            } else {
                System.out.println("\nSelecione o Workshop:");
                for (int i = 0; i < workshops.size(); i++) {
                    System.out.printf("%d - %s\n", i + 1, workshops.get(i).getNome());
                }
                int index = sc.nextInt() - 1;
    
                if (index >= 0 && index < workshops.size()) {
                    Workshop workshopSelecionado = workshops.get(index);
                    System.out.printf("\nWorkshop Selecionado: %s\n", workshopSelecionado.getNome());
    
                    // Criar uma nova lista para todos os participantes
                    List<Participante> todosParticipantes = new ArrayList<>(workshopSelecionado.getParticipantes());
    
                    // Adicionar participantes que têm reservas para o workshop
                    for (Reserva reserva : reservas) {
                        if (reserva.getEvento().equals(workshopSelecionado)) {
                            todosParticipantes.add(reserva.getParticipante());
                        }
                    }
    
                    // Remover duplicatas da lista
                    todosParticipantes = todosParticipantes.stream().distinct().collect(Collectors.toList());
    
                    listarParticipantes(todosParticipantes);
                } else {
                    System.out.println("Opção inválida!");
                }
            }
        } else {
            System.out.println("Tipo de evento inválido!");
        }
    }
    
        

    // Método auxiliar para listar participantes, separando VIPs
    private static void listarParticipantes(List<Participante> participantes) {
        System.out.println("\n~Lista de Participantes~");
        for (Participante participante : participantes) {
            int tipo = participante.getTipo();// == 1 ? "Normal" : "VIP";
            String tipo_str;

            switch (tipo) {
                case 1 -> tipo_str = "Normal";
                case 2 -> tipo_str = "VIP";
                case 3 -> tipo_str = "Palestrante";
                case 4 -> tipo_str = "Instrutor";
                default -> tipo_str = "";
            }
            System.out.printf("Nome: %s, Email: %s, Tipo: %s\n", participante.getNome(), participante.getEmail(), tipo_str);
        }

        System.out.println("\n~Lista de Participantes VIP~");
        for (Participante participante : participantes) {
            if (participante.getTipo() == 2) { // Tipo 2 é VIP
                System.out.printf("Nome: %s, Email: %s\n", participante.getNome(), participante.getEmail());
            }
        }
    }

    private static int contarParticipantesPorEvento(Evento evento) {
        int contador = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getEvento().equals(evento)) {
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
            System.out.printf("%d - Palestra: %s (Capacidade Máxima: %d)\n", i + 1, palestra.getNome(), palestra.getCapacidadeMax());
        }
    
        for (int i = 0; i < workshops.size(); i++) {
            Workshop workshop = workshops.get(i);
            System.out.printf("%d - Workshop: %s (Capacidade Máxima: %d)\n", i + 1 + palestras.size(), workshop.getNome(), workshop.getCapacidadeMax());
        }
    
        int eventoEscolhido = sc.nextInt() - 1;
        Evento evento;
    
        if (eventoEscolhido < 0 || eventoEscolhido < palestras.size()) {
            evento = palestras.get(eventoEscolhido);
        } else if (eventoEscolhido < palestras.size() + workshops.size()) {
            evento = workshops.get(eventoEscolhido - palestras.size());
        } else {
            System.out.println("Evento inválido!");
            return;
        }
    
        // Verificar capacidade máxima
        int totalParticipantes = contarParticipantesPorEvento(evento); // Alterado para usar o método correto
        if (totalParticipantes >= evento.getCapacidadeMax()) {
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
            String tipo_str;
    
            switch (participante.getTipo()) {
                case 1 -> tipo_str = "Normal";
                case 2 -> tipo_str = "VIP";
                case 3 -> tipo_str = "Palestrante";
                case 4 -> tipo_str = "Instrutor";
                default -> tipo_str = "Desconhecido";
            }
    
            System.out.printf("%d - Nome: %s, Email: %s, Tipo: %s\n",
                    i + 1, participante.getNome(), participante.getEmail(), tipo_str);
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
    
    public static Boolean validaTipo(int tipo) {
        return tipo >= 1 && tipo <= 4; // Retorna true se for um tipo válido
    }    
}

