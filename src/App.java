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
        //implementar lógica para contar quantos participantes estão inscritos na palestra
        return 0; // Retorne o número real de participantes inscritos quando a lógica for implementada
    }
}
