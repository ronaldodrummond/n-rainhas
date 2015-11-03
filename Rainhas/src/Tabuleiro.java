public class Tabuleiro {
    private int[] tabuleiro;
    private int numConf;
    private int tamanho;
    
    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        tabuleiro = new int[tamanho];
        
        for (int i = 0; i < tabuleiro.length; i++) {
           tabuleiro[i] = (int)(Math.random()*(tamanho)+1);
        }
    }

    public void conflitos() {
        int numAtaque = 0;
        int atual;
        int anterior;
        int i, j;
        for (i = 0; i < tamanho - 1; i++) {
            anterior = tabuleiro [i];
            for (j=i+1; j < tamanho; j++) {
                atual = tabuleiro [j];
                int dif = j - i;
                if((atual == anterior) || (atual == anterior + dif) || (atual == anterior - dif)) {
                    numAtaque++;
                }
            }    
        }
        numConf = numAtaque;
    }
    
    public void imprimir() {
        System.out.print("[ ");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(tabuleiro[i] + " ");
        }
        System.out.println("]");
    }
    
    public int[] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            this.tabuleiro[i] = tabuleiro[i];
        }
    }

    public int getNumConf() {
        return numConf;
    }

    public void setNumConf(int numConf) {
        this.numConf = numConf;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
  
}
