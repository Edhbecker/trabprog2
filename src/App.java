import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.Evento;
import Class.Palestra;
import Class.Participante;
import Class.Workshop;

public class App {
    static ArrayList<Palestra> palestras = new ArrayList<>();
    static ArrayList<Workshop> workshops = new ArrayList<>();
    static ArrayList<Participante> participantes = new ArrayList<>();

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
                List<Participante> participante = new ArrayList<>();

                Participante dadosParticipante = Participante.capturarDadosParticipante(scan);
                participante.add(new Participante(dadosParticipante.getNome(), dadosParticipante.getEmail(), dadosParticipante.getTipo()));

            } else if (opcao == 3) {
                // Implementar gerenciar reservas
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
    private static void gerarRelatorioEventos() {
        System.out.println("\n~Relatório de Eventos~");

        // Relatório de Palestras
        System.out.println("Palestras:");
        for (Palestra palestra : palestras) {
            System.out.printf("Evento: %s, Data: %s, Local: %s, Capacidade Máxima: %d\n",
                    palestra.getNome(), palestra.getData(), palestra.getLocal(), palestra.getCapacidadeMax());
            System.out.printf("Total de Participantes: %d\n\n", palestra.getParticipantes().size());
        }

        // Relatório de Workshops (se necessário incluir participantes nos workshops)
        System.out.println("Workshops:");
        for (Workshop workshop : workshops) {
            System.out.printf("Evento: %s, Data: %s, Local: %s, Capacidade Máxima: %d\n",
                    workshop.getNome(), workshop.getData(), workshop.getLocal(), workshop.getCapacidadeMax());
            System.out.println("Participantes: (implementação necessária para vincular participantes a workshops)\n");
        }
    }

    private static void gerarRelatorioParticipantesPorEvento(Scanner sc) {
        System.out.println("\nSelecione o tipo de evento:");
        System.out.println("1 - Palestra");
        System.out.println("2 - Workshop");
        int tipoEvento = sc.nextInt();

        if (tipoEvento == 1) { // Relatório de Palestra
            System.out.println("\nSelecione a Palestra:");
            for (int i = 0; i < palestras.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, palestras.get(i).getNome());
            }
            int index = sc.nextInt() - 1;

            if (index >= 0 && index < palestras.size()) {
                Palestra palestraSelecionada = palestras.get(index);
                System.out.printf("\nPalestra Selecionada: %s\n", palestraSelecionada.getNome());
                listarParticipantes(palestraSelecionada.getParticipantes());
            } else {
                System.out.println("Opção inválida!");
            }
        } else if (tipoEvento == 2) { // Relatório de Workshop
            System.out.println("\nSelecione o Workshop:");
            for (int i = 0; i < workshops.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, workshops.get(i).getNome());
            }
            int index = sc.nextInt() - 1;

            if (index >= 0 && index < workshops.size()) {
                Workshop workshopSelecionado = workshops.get(index);
                System.out.printf("\nWorkshop Selecionado: %s\n", workshopSelecionado.getNome());
                // Aqui podemos adicionar a lógica para listar participantes, quando implementado.
                System.out.println("Participantes: (implementação necessária)\n");
            } else {
                System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Tipo de evento inválido!");
        }
    }

    // Método auxiliar para listar participantes, separando VIPs
    private static void listarParticipantes(List<Participante> participantes) {
        System.out.println("\n~Lista de Participantes~");
        for (Participante participante : participantes) {
            String tipo = participante.getTipo() == 1 ? "Normal" : "VIP";
            System.out.printf("Nome: %s, Email: %s, Tipo: %s\n", participante.getNome(), participante.getEmail(), tipo);
        }

        System.out.println("\n~Lista de Participantes VIP~");
        for (Participante participante : participantes) {
            if (participante.getTipo() == 2) { // Tipo 2 é VIP
                System.out.printf("Nome: %s, Email: %s\n", participante.getNome(), participante.getEmail());
            }
        }
    }
}
