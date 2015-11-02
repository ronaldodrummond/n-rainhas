
import java.util.Scanner;

public class Executar {
    public static void main(String[] args) {
        int tamanho, op;
        Tabuleiro tabuleiro;
        Encosta encosta;
        Genetico genetico;
        Hibrido hibrido;
        System.out.println("\n N-Rainhas \n");
        System.out.print("\n1-Subida de Encosta\n2-Genético\n3-Híbrido\nDigite a opção desejada: ");
        Scanner ler = new Scanner(System.in);
        op = ler.nextInt();
        System.out.print("Digite o tamanho do tabuleiro: ");
        tamanho = ler.nextInt();   
        
        tabuleiro = new Tabuleiro(tamanho);
        
        switch (op){
            case 1:
                encosta = new Encosta(tabuleiro);
                encosta.executar(); 
                break;
            case 2:
                genetico = new Genetico(tamanho);
                genetico.mutacao(tamanho);
                break;
            case 3:
                //hibrido = new Hibrido(tamanho);
                break;
            default:
                System.out.println("Opção invalida!");
                break;                
        }
    }   
}
