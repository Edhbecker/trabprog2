import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        int opcao = -1;
        

        while (opcao != 0){

            String[] participantes = {};
        
            System.out.println("\nMenu");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Cadastrar Participante");
            System.out.println("3 - Gerenciar Reservas");
            System.out.println("4 - Visualizar Relatório");
            System.out.println("0 - Sair\n");
            System.out.print("Digite o número da opção desejada: ");
            opcao = s.nextInt();

            //System.out.print(opcao);
            if (opcao == 1){
                participantes[0] = "opcao 1";
                System.out.print(participantes[0]);
            }
            if (opcao == 2){
                System.out.print(opcao);
            }
            if (opcao == 3){
                System.out.print(opcao);
            }
            if (opcao == 4){
                System.out.print(opcao);
            }

            System.out.println();
            }
        s.close();
        System.out.println("\n~Finalizado~\n");
        }
        
        
}
