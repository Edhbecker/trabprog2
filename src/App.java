import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.Palestra;
import Class.Participante;

public class App {
    private static ArrayList<Palestra> palestras = new ArrayList<>();
    private static ArrayList<Participante> participantes = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in); // Captura de string
        Scanner sc = new Scanner(System.in); // Captura de inteiros
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

            if (opcao == 1) {  // Implementar -> o palestrante também é um participante
                System.out.println("\n~Inicializando cadastro de Evento~\n");

                System.out.println("Tipo do Evento:");
                System.out.println("1 - Palestra");
                System.out.println("2 - Workshop");
                int tipoEvento = sc.nextInt();

                if (tipoEvento == 1) {
                    boolean cadastro = true;
                    int resposta = 0;

                    while (cadastro) {
                        List<String> temas = new ArrayList<>();
                        String v_Nome;
                        String v_Data;
                        String v_Local;
                        int v_capacidade_max;
                        int v_duracao;

                        System.out.println("\nNome do Evento:");
                        s.nextLine(); // Limpar o buffer do scanner
                        v_Nome = s.nextLine();

                        System.out.println("\nData do Evento:");
                        v_Data = s.nextLine();

                        System.out.println("\nLocal:");
                        v_Local = s.nextLine();

                        System.out.println("\nCapacidade máxima:");
                        v_capacidade_max = sc.nextInt();

                        System.out.println("Duração do Evento(em Minutos):");
                        v_duracao = sc.nextInt();

                        int contador = 0;
                        int int_temas = -1;

                        while (int_temas != 2) {
                            contador++;
                            String temaString;
                            System.out.format("Tema(%d):", contador);
                            s.nextLine(); // Limpar o buffer do scanner
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
                        palestras.add(new Palestra(v_Nome, v_Data, v_Local, v_capacidade_max, v_duracao, temas));

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
                } else if (tipoEvento == 2) {
                    // Implementar cadastro de workshop
                } else {
                    System.out.print("\nOpção inválida\n");
                }

            } else if (opcao == 2) {
                cadastrarParticipante(s, sc);
            } else if (opcao == 3) {
                // Implementar gerenciar reservas
            } else if (opcao == 4) {
                gerarRelatorios();
            } else if (opcao < 0 || opcao > 4) {
                System.out.print("Opção inválida");
            }

            System.out.println();
        }
        s.close();
        sc.close();
        System.out.println("\n~Finalizado~\n");
    }

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
