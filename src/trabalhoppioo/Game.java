/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhoppioo;

import java.util.Random;

public class Game {

    Player player = new Player();
    Player computer = new Player();
    
    public Game() {    
    }
    
    //player
    public void atacarPersonagem(int indexPers, int indexComputer) {
        Personagem atacante = player.getListaPersonagens().get(indexPers);
        Personagem atacado = computer.getListaPersonagens().get(indexComputer);
        Random randomGenerator = new Random();
        
        int randomNum = randomGenerator.nextInt(100);
        if (randomNum > 25 && randomNum <=50) {
            atacado.defender();
        }
        
        System.out.println("Random: " + randomNum);
        
        
        int dano = atacante.atacar(atacado);
        
        System.out.println("Dano: " + dano);
    };
    
    public void curarPersonagem(int indexPers,int indexComputer) {
        Mind mind = (Mind)player.getListaPersonagens().get(indexPers);
        Personagem alvo = computer.getListaPersonagens().get(indexComputer);
        
        mind.conjurar(alvo);
    };
    
    public void conjurarPersonagem(int indexPers) {
        Body body = (Body)player.getListaPersonagens().get(indexPers);
        
        body.conjurar();
    };
    
    //Computer - Implementar
    public void randomizeAction(int indexComputer){
        Random randomGenerator = new Random();
        Personagem atual = computer.getListaPersonagens().get(indexComputer);
        
        int randomNum = randomGenerator.nextInt(2);
        
        System.out.println("Randomizing: " + randomNum + "; Nome: " +  atual.getNome());
        
        if (randomNum == 0) {
            if (atual instanceof Body){
                conjurarPersonagemComputer(indexComputer);
            } else {
                curarPersonagem(indexComputer);
            }
        } else {
            atacarPersonagem(indexComputer);
        }
    };
    
    public void atacarPersonagem(int indexComputer){
        Personagem atacante = computer.getListaPersonagens().get(indexComputer);
        Random randomGenerator = new Random();
        
        int randomNum = randomGenerator.nextInt(player.getListaPersonagens().size()-1);
        Personagem atacado = player.getListaPersonagens().get(randomNum);
        
        atacante.atacar(atacado);
    };
    
    public void curarPersonagem(int indexComputer){
        Mind curador = (Mind)computer.getListaPersonagens().get(indexComputer);
        Random randomGenerator = new Random();
        
        int randomNum = randomGenerator.nextInt(computer.getListaPersonagens().size() - 1);
        Personagem curado = computer.getListaPersonagens().get(randomNum);
        curador.conjurar(curado);
    };

    public void conjurarPersonagemComputer(int indexComputer){
        Body conjurador = (Body)computer.getListaPersonagens().get(indexComputer);
        conjurador.conjurar();
    };
    
    //Inserir Personagens

    public void adicionarGuardião(String nome){
        player.inserirGuardiao(nome);
        computer.inserirGuardiao("Sombra de " + nome);
        System.out.println("Personagem " + nome + " adicionado.");
    };
    
    public void adicionarAssassino(String nome){
        player.inserirAssassino(nome);
        computer.inserirAssassino("Sombra de " + nome);
        System.out.println("Personagem " + nome + " adicionado.");
    };
    
    public void adicionarGuerreiro(String nome){
        player.inserirGuerreiro(nome);
        computer.inserirGuerreiro("Sombra de " + nome);
        System.out.println("Personagem " + nome + " adicionado.");
    };
    
    public void adicionarMago(String nome){
        player.inserirMago(nome);
        computer.inserirMago("Sombra de " + nome);
        System.out.println("Personagem " + nome + " adicionado.");
    };
    
    public void removerPersonagem(){
        
        player.removerPersonagem();
        computer.removerPersonagem();
        //System.out.println("Personagem " + nome + " removido.");
    };
}
