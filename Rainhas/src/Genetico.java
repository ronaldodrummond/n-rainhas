
import java.util.ArrayList;

public class Genetico {
    private ArrayList<Tabuleiro> populacao = new ArrayList<>();
    int n;
    
    public Genetico(int n) {
        this.n = n;
        this.populacao = populacao;
    }

    public ArrayList<Tabuleiro> gerarPopulacao(int n) {
        ArrayList<Tabuleiro> pop = new ArrayList<Tabuleiro>();
        
        for(int i = 0; i < n; i++) {
            Tabuleiro tab = new Tabuleiro(n);
            tab.conflitos();
            pop.add(i, tab);
        }
        
        System.out.println("\nAlgoritmo Genético \n");
        System.out.println("\nPopulação \n");
        
        for (int i = 0; i < n; i++) {
            System.out.print("\nPopulação "+ i + " [ ");
            for (int j = 0; j < n; j++) {
                System.out.print(pop.get(i).getTabuleiro()[j] + " ");
            }
            System.out.println("] \nConflitos: " + pop.get(i).getNumConf());
        }
        
        return pop;        
    }
    
    public ArrayList<Tabuleiro> selecao(int n) {
        Tabuleiro menor1 = new Tabuleiro(n);
        Tabuleiro menor2 = new Tabuleiro(n);
        ArrayList<Tabuleiro> selecionados = new ArrayList<Tabuleiro>();
        int auxMaior = 0;
        
        populacao = gerarPopulacao(n);
        
        ArrayList<Tabuleiro> aux = new ArrayList<Tabuleiro>();
        menor1 = populacao.get(0);
        menor1.conflitos();
        menor2.conflitos();
        
        for (int i = 0; i < populacao.size(); i++) {
            if(menor1.getNumConf()>=populacao.get(i).getNumConf()) {
                menor1 = populacao.get(i);
                auxMaior = i;
            }
        }
        
        if (auxMaior != 0) {
            menor2 = populacao.get(0);
        } else {
            menor2 = populacao.get(1);
        }
        
        for (int i = 0; i < populacao.size(); i++) {
            if (auxMaior != i) {
                if (auxMaior != i) {
                    if (menor2.getNumConf() >= populacao.get(i).getNumConf()) {
                        menor2 = populacao.get(i);
                    }
                }
            } 
        }
        
        selecionados.add(menor1);
        selecionados.add(menor2);
        
        System.out.println("\nIndivíduos Selecionados \n");
        
        for (int i = 0; i < selecionados.size(); i++) {
            System.out.print("\nSelecionados "+ i + " [ ");
            for (int j = 0; j < n; j++) {
                System.out.print(selecionados.get(i).getTabuleiro()[j] + " ");
            }
            System.out.println("] \nConflitos: " + selecionados.get(i).getNumConf());
        }
        
        return selecionados;
    }
    
    public Tabuleiro crossOver(int n) {
        Tabuleiro aux1 = new Tabuleiro(n);
        Tabuleiro aux2 = new Tabuleiro(n);
        
        Tabuleiro filho = new Tabuleiro(n);
        ArrayList<Tabuleiro> pais = new ArrayList<Tabuleiro>();
        
        pais = selecao(n);        
        aux1 = pais.get(0);
        aux2 = pais.get(1);
        aux1.conflitos();
        aux2.conflitos();
        
        System.out.println("\nCrossover \n");
        System.out.println("Pai 1: ");
        pais.get(0).imprimir();
        System.out.println("Pai 2: ");
        pais.get(1).imprimir();
        
        int pontoCorte = aux1.getTamanho()/2;
        
        for (int i = 0; i < n; i++) {
            if (i < pontoCorte) {
                filho.getTabuleiro()[i] = aux1.getTabuleiro()[i];
            } else {
                filho.getTabuleiro()[i] = aux2.getTabuleiro()[i];
            }
        }
        
        filho.conflitos();
        System.out.println("Filho: ");
        filho.imprimir();
        System.out.println("Conflitos: " + filho.getNumConf());
        
        return filho;
    } 
    
    public Tabuleiro mutacao(int n) {
        Tabuleiro filho = new Tabuleiro(n);
        filho = crossOver(n);
        filho.conflitos();
        
        int num1 = (int) (Math.random() * n);
        int num2 = (int) (Math.random() * n);
        
        int aux = filho.getTabuleiro()[num1];
        filho.getTabuleiro()[num1] = filho.getTabuleiro()[num2];
        filho.getTabuleiro()[num2] = aux;
        
        System.out.println("\n Mutação \n");
        System.out.println("Solução encontrada: ");
        filho.imprimir();
        System.out.println("Conflitos: " + filho.getNumConf());
        
        return filho;
    }
    
    public ArrayList<Tabuleiro> getPopulacao() {
        return populacao;
    }

    public void setPopulacao(ArrayList<Tabuleiro> populacao) {
        this.populacao = populacao;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
}
