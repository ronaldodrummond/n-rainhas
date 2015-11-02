/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ronaldo
 */
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
    
}
