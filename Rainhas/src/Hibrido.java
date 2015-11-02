public class Hibrido {
    private int n;
    private Tabuleiro tab;
    private Genetico genetico;
    
    public Hibrido(int n) {
        System.out.println("\nSolução Híbrida\n");
        for (int i = 0; i < n; i++) {
            genetico = new Genetico(n);
            Tabuleiro mutacao = genetico.mutacao(n);
            Encosta encosta = new Encosta(mutacao);
            tab = encosta.executar();
            tab.imprimir();
        }
    }
}
