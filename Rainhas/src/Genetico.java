
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldo
 */
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
        
        System.out.println("\n Algoritmo Genético \n");
        System.out.println("\n População \n");
        
        return pop;        
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
