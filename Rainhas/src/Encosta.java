public class Encosta {
    Tabuleiro atual, prox, melhorResult;
    int n;
    
    public Encosta(Tabuleiro atual) {
        n = atual.getTamanho();
        this.atual = atual;
        melhorResult = atual;
    }
    
    
}
