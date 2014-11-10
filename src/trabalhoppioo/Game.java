package trabalhoppioo;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    public Player player = new Player();
    Player computer = new Player();
    
    public Game() {    
    }
    
    //player
    public void atacarPersonagem(int indexPers, int indexComputer) {
        Personagem atacante = player.getPersonagem(indexPers);
        Personagem atacado = computer.getPersonagem(indexComputer);
        Random randomGenerator = new Random();
        
        int randomNum = randomGenerator.nextInt(100);
        if (randomNum > 25 && randomNum <=50) {
            atacado.defender();
            System.out.println(atacado.getNome() + " defendeu!");
        }
        
        int dano = atacante.atacar(atacado);
        
        if (atacado.getQuantidadeVida() == 0) {
            System.out.println("Morto: " + atacado.getNome());
            this.removerPersonagem(indexComputer);
        }
    };
    
    public void curarPersonagem(int indexPers,int indexComputer) {
        try {
            if (this.player.getPersonagem(indexPers) instanceof Mind) {
                ((Mind)player.getPersonagem(indexPers)).conjurar(player.getPersonagem(indexComputer));
            } else {
                throw new GameException();
            }
        } catch (GameException ge) {
            //use here
        }
    };
    
    public void conjurarPersonagem(int indexPers) {
        try {
            if (this.player.getPersonagem(indexPers) instanceof Body) {
                ((Body)player.getPersonagem(indexPers)).conjurar();
            } else {
                throw new GameException();
            }
        } catch (GameException ge) {
            //use here
        }
    };
    
    //Computer - Implementar
    public void randomizeAction(int indexComputer){
        Random randomGenerator = new Random();
        Personagem atual = computer.getPersonagem(indexComputer);
        
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
        Personagem atacante = computer.getPersonagem(indexComputer);
        Random randomGenerator = new Random();
        
        int randomNum = randomGenerator.nextInt(player.getListaPersonagens().size()-1);
        Personagem atacado = player.getPersonagem(randomNum);
        
        randomNum = randomGenerator.nextInt(100);
        if (randomNum > 25 && randomNum <=50) {
            atacado.defender();
            System.out.println(atacado.getNome() + " defendeu!");
        }
        
        atacante.atacar(atacado);
        
        //Checar se o atacado está morto
        
        if (atacado.getQuantidadeVida() == 0) {
            this.removerPersonagem(indexComputer);
        }
    };
    
    //Movimentos do Computador
    public void curarPersonagem(int indexComputer){
        try {
            if (this.computer.getPersonagem(indexComputer) instanceof Mind){
                Random randomGenerator = new Random();
        
                int randomNum = randomGenerator.nextInt(computer.getListaPersonagens().size() - 1);
                ((Mind)this.computer.getPersonagem(indexComputer)).conjurar(this.computer.getPersonagem(randomNum));
            } else {
                throw new GameException();
            }
        } catch (GameException ge) {
            //
        }
    };

    public void conjurarPersonagemComputer(int indexComputer){
        try {
            if (this.computer.getPersonagem(indexComputer) instanceof Body) {
                ((Body)computer.getPersonagem(indexComputer)).conjurar();
            } else {
                throw new GameException();
            }
        } catch (GameException ge) {
            //
        }
    };
    
    //Inserir Personagens

    public void adicionarGuardião(String nome){
        try {
            this.verificarRepeticao(nome);
            player.inserirGuardiao(nome);
            computer.inserirGuardiao("Sombra de " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
            //Do something
            System.out.println("Nome repetido. Numero de Personagens: " + player.getListaPersonagens().size());
        }
    };
    
    public void adicionarAssassino(String nome){
        try {
            this.verificarRepeticao(nome);
            player.inserirAssassino(nome);
            computer.inserirAssassino("Sombra de " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
            //Do something
            System.out.println("Nome repetido. Numero de Personagens: " + player.getListaPersonagens().size());
        }
    };
    
    public void adicionarGuerreiro(String nome){
        try {
            this.verificarRepeticao(nome);
            player.inserirGuerreiro(nome);
            computer.inserirGuerreiro("Sombra de " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
            //Do something
            System.out.println("Nome repetido. Numero de Personagens: " + player.getListaPersonagens().size());
        }
    };
    
    public void adicionarMago(String nome){
        try {
            this.verificarRepeticao(nome);
            player.inserirMago(nome);
            computer.inserirMago("Sombra de " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
            //Do something
            System.out.println("Nome repetido. Numero de Personagens: " + player.getListaPersonagens().size());
        }
    };
    
    public void removerPersonagem(){
        
        player.removerPersonagem();
        computer.removerPersonagem();
        //System.out.println("Personagem " + nome + " removido.");
    };
    
    public void removerPersonagem(int index) {
        //A remoção tem que ser realizada ou utilizando cast ou por index
        player.removerPersonagem(index);
        computer.removerPersonagem(index);
    }
    
    public void verificarRepeticao(String nome) throws PlayerException{
        for (Personagem p : player.getListaPersonagens()) {
            if (p.getNome().equals(nome)) {
                throw new PlayerException();
            }
        }
    };
    
    public int getIndex() {
        return player.listaPersonagens.size();
    }
}
