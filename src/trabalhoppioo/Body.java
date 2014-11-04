/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhoppioo;

/**
 *
 * @author LionsWrath
 */
public abstract class Body extends Personagem {

    public Body(String nome, int quantidadeVida) {
        super(nome, quantidadeVida);
    }

    //Verificar o retorno depois
    public abstract void conjurar();
}
