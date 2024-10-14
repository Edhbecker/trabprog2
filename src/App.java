import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Class.Palestra;
import Class.Participante;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in); //Captura de string
        Scanner sc = new Scanner(System.in); //Captura de inteiros
        int opcao = -1;
        

        while (opcao != 0){
            //ArrayList<Participante> participantes = new ArrayList<>();
            ArrayList<Palestra> palestras = new ArrayList<>();
        
            System.out.println("\nMenu");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Cadastrar Participante");
            System.out.println("3 - Gerenciar Reservas");
            System.out.println("4 - Visualizar Relatório");
            System.out.println("0 - Sair\n");
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();

            if (opcao == 1){  //Implementar -> o palestrante também é um participante)
                System.out.println("\n~Inicializando cadastro de Evento~\n");

                System.out.println("Tipo do Evento:");
                System.out.println("1 - Palestra");
                System.out.println("2 - Workshop");
                int tipoEvento = 0;
                tipoEvento = sc.nextInt();

                if (tipoEvento == 1){
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
                            temaString = s.nextLine();
                            temas.add(temaString);

                            System.out.print("Cadastrar mais temas? (1)Sim, (2)Não\n");
                            int_temas = sc.nextInt();
                            if (int_temas == 1){
                                continue;
                            }
                            else if (int_temas == 2){
                                System.out.print("Temas cadastrados!\n");
                            }
                            else if (int_temas < 1 || int_temas > 2){
                                System.out.print("\nOpção inválida\n");
                            }
                        }
                        palestras.add(new Palestra(v_Nome, v_Data, v_Local, v_capacidade_max, v_duracao, temas));

                        System.out.println("Cadastrar mais Palestras? (1)Sim, (2)Não");
                        resposta = sc.nextInt();
                        if (resposta == 1){
                            continue;
                        }
                        else if (resposta == 2){
                            cadastro = false;
                        }
                        else if (resposta < 1 || resposta > 2){
                            System.out.print("\nOpção inválida\n");
                        }
                    }
                    System.out.println("\n~Finalizado cadastro de Evento~\n");
                }
                else if (tipoEvento == 2){
                    //Implementar
                }
                else {
                    System.out.print("\nOpção inválida\n");
                }

            }
            else if (opcao == 2){
                System.out.print(opcao);
                //Implementar
            }
            else if (opcao == 3){
                System.out.print(opcao);
                //Implementar
            }
            else if (opcao == 4){
                System.out.print(opcao);
                //Implementar
            }

            else if (opcao < 0 || opcao > 4){
                System.out.print("Opção inválida");
            }

            System.out.println();
        }
        s.close();
        sc.close();
        System.out.println("\n~Finalizado~\n");
    }
}    
 

