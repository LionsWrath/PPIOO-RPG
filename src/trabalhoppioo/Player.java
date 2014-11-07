package trabalhoppioo;

import java.util.ArrayList;

public class Player {

    ArrayList<Personagem> listaPersonagens = new ArrayList();

    public Player() {
    }
    
    //
    public void inserirGuerreiro(String nome) {
        try{
            verificarLimite(this.listaPersonagens.size());
            Guerreiro guerreiro = new Guerreiro(nome);
            listaPersonagens.add(guerreiro);
        } catch (PlayerException pe) {
            //Inventar algo para fazer aqui
        }
    };
    
    public void inserirAssassino(String nome) {
        try{
            verificarLimite(this.listaPersonagens.size());
            Assassino assassino = new Assassino(nome);
            listaPersonagens.add(assassino);
        } catch (PlayerException pe) {
            //Inventar algo para fazer aqui
        }
    };
    
    public void inserirMago(String nome) {
        try{
            verificarLimite(this.listaPersonagens.size());
            Mago mago = new Mago(nome);
            listaPersonagens.add(mago);
        } catch (PlayerException pe) {
            //Inventar algo para fazer aqui
        }
    };
    
    public void inserirGuardiao(String nome) {
        try{
            verificarLimite(this.listaPersonagens.size());
            Guardião guardião = new Guardião(nome);
            listaPersonagens.add(guardião);
        } catch (PlayerException pe) {
            //Inventar algo para fazer aqui
        }
    };

    public void removerPersonagem() {
        try {
            if (this.listaPersonagens.isEmpty()){
                throw new PlayerException();
            }
            this.listaPersonagens.remove(listaPersonagens.size()-1);
        } catch (PlayerException pe) {
            //Inventar algo para fazer aqui
        }
    };
    
    public void removerPersonagem(int index) {
        try {
            if (this.listaPersonagens.isEmpty() || this.listaPersonagens.size() < index ) {
                throw new PlayerException();
            }
            this.listaPersonagens.remove(index);
        } catch (PlayerException pe) {
            //
        }
    }
    
    public void verificarLimite(int num) throws PlayerException{
        if (num == 10){
            throw new PlayerException();
        }
    };

    public ArrayList<Personagem> getListaPersonagens() {
        return listaPersonagens;
    }
    
    public Personagem getPersonagem(int index) {
        return listaPersonagens.get(index);
    }
    
}
