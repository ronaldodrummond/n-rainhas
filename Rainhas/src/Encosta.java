public class Encosta {
    Tabuleiro atual, prox, melhorResult;
    int n;
    
    public Encosta(Tabuleiro atual) {
        n = atual.getTamanho();
        this.atual = atual;
        melhorResult = atual;
    }
    
    public Tabuleiro executar () {
        Tabuleiro novo = new Tabuleiro(atual.getTamanho());
        novo.setTabuleiro(atual.getTabuleiro());
        novo.conflitos();
        melhorResult = new Tabuleiro(atual.getTamanho());
        melhorResult.setTabuleiro(atual.getTabuleiro());
        melhorResult.conflitos();
        System.out.println("\nA solução inicial tem: " + melhorResult.getNumConf() + " conflitos.");
        melhorResult.imprimir();
        System.out.println("\nExecução subida de encosta\n");
        
        for (int i = 0; i < novo.getTamanho() && novo.getNumConf()!=0; i++) {
            for (int j = 1; j < novo.getTamanho(); j++) {
                if(novo.getTabuleiro()[i]!=j) {
                    novo.getTabuleiro()[i] = j;
                    novo.conflitos();
                    novo.imprimir();
                    System.out.println("Conflitos solução atual: " + melhorResult.getNumConf() + "\nConflitos vizinho: " + novo.getNumConf());
                    if(melhorResult.getNumConf()>novo.getNumConf()) {
                        System.out.println("\nTroca...");
                        melhorResult = new Tabuleiro(novo.getTamanho());
                        melhorResult.setTabuleiro(novo.getTabuleiro());
                        melhorResult.conflitos();                
                    }
                } else {
                    novo.imprimir();
                }
            }
            System.out.println("\nSolução Final");
            melhorResult.imprimir();
            System.out.println("\nNúmero de conflitos: " + melhorResult.getNumConf());
        }
        return melhorResult;
    }
}

