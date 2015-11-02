
import java.util.Scanner;

public class Executar {
    public static void main(String[] args) {
        int tamanho, op;
        Tabuleiro tabuleiro;
        Encosta encosta;
        Genetico genetico;
        Hibrido hibrido;

        do{
            System.out.println("\n N-Rainhas \n");
            System.out.print("\n1-Subida de Encosta\n2-Genético\n3-Híbrido\n4-Sair\nDigite a opção desejada: ");
            Scanner ler = new Scanner(System.in);
            op = ler.nextInt();
        
            switch (op){
                case 1:
                    System.out.print("Digite o tamanho do tabuleiro: ");
                    tamanho = ler.nextInt();   
                    tabuleiro = new Tabuleiro(tamanho);
                    encosta = new Encosta(tabuleiro);
                    encosta.executar(); 
                    break;
                case 2:
                    System.out.print("Digite o tamanho do tabuleiro: ");
                    tamanho = ler.nextInt(); 
                    genetico = new Genetico(tamanho);
                    genetico.mutacao(tamanho);
                    break;
                case 3:
                    System.out.print("Digite o tamanho do tabuleiro: ");
                    tamanho = ler.nextInt(); 
                    hibrido = new Hibrido(tamanho);
                    break;
                case 4:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nErro: Opção incorreta!"); 
                    break;
            }
        }while(op!=4);
    }   
}
