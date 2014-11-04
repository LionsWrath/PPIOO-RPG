/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhoppioo;

import java.util.ArrayList;

/**
 *
 * @author LionsWrath
 */
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
            if (this.listaPersonagens.isEmpty() == true){
                throw new PlayerException();
            }
            this.listaPersonagens.remove(listaPersonagens.size()-1);
        } catch (PlayerException pe) {
            //Inventar algo para fazer aqui
        }
    };
    
    public void verificarLimite(int num) throws PlayerException{
        if (num == 10){
            throw new PlayerException();
        }
    };

    public ArrayList<Personagem> getListaPersonagens() {
        return listaPersonagens;
    }
    
}
