package trabalhoppioo;

public class Game {

    public Player player = new Player();
    public Player computer = new Player();
    
    public Game() {    
    }
    
    //player
    public void atacarPersonagem(int indexPers, int indexComputer) {
        Personagem atacante = player.getPersonagem(indexPers);
        Personagem atacado = computer.getPersonagem(indexComputer);
        
        int dano = atacante.atacar(atacado);
    };
    
    public void curarPersonagem(int indexPers,int indexPers2) {
        try {
            if (this.player.getPersonagem(indexPers) instanceof Mind) {
                ((Mind)player.getPersonagem(indexPers)).conjurar(player.getPersonagem(indexPers2));
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
    
    public void atacarPersonagemComputer(int indexComputer, int target){
        Personagem atacante = computer.getPersonagem(indexComputer);
        Personagem atacado = player.getPersonagem(target);
        atacante.atacar(atacado);
    };
    
    //Movimentos do Computador
    public void curarPersonagemComputer(int indexComputer, int target){
        try {
            if (this.computer.getPersonagem(indexComputer) instanceof Mind){
                ((Mind)this.computer.getPersonagem(indexComputer)).conjurar(this.computer.getPersonagem(target));
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
            computer.inserirGuardiao("Sombra " + nome);
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
            computer.inserirAssassino("Sombra " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
        }
    };
    
    public void adicionarGuerreiro(String nome){
        try {
            this.verificarRepeticao(nome);
            player.inserirGuerreiro(nome);
            computer.inserirGuerreiro("Sombra " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
        }
    };
    
    public void adicionarMago(String nome){
        try {
            this.verificarRepeticao(nome);
            player.inserirMago(nome);
            computer.inserirMago("Sombra " + nome);
            System.out.println("Personagem " + nome + " adicionado.");
        } catch (PlayerException pe) {
        }
    };
    
    public void removerPersonagem(){
        
        player.removerPersonagem();
        computer.removerPersonagem();
    };
    
    public void removerPersonagem(int index) {
        player.removerPersonagem(index);
        computer.removerPersonagem(index);
    }
    
    public void removerMortoPlayer(int index) {
        player.removerPersonagem(index);
    }
    
    public void removerMortoComputer(int index) {
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
