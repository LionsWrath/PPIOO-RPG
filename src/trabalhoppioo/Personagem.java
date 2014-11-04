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
public abstract class Personagem {

    private String nome;
    private int quantidadeVida;
    
    private int bonusDano = 0;
    private int bonusResistencia = 0;

    public Personagem(String nome, int quantidadeVida) {
        setNome(nome);
        this.quantidadeVida = quantidadeVida;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try {
            if (nome == null) {
                throw new PersonagemException();
            }
        this.nome = nome;
        } catch (PersonagemException pe) {
            //Ver o que fazer aqui
        }
    }

    //
    public int getQuantidadeVida() {
        return quantidadeVida;
    }

    public void setQuantidadeVida(int quantidadeVida) {
        this.quantidadeVida = quantidadeVida;
        if (this.quantidadeVida < 0) {
            this.quantidadeVida = 0;
        }
    }

    //
    public int getBonusDano() {
        return bonusDano;
    }

    public void setBonusDano(int bonusDano) {
        this.bonusDano = bonusDano;
        if (this.bonusDano > 100) {
            this.bonusDano = 100;
        }
    }

    //
    public int getBonusResistencia() {
        return bonusResistencia;
    }

    public void setBonusResistencia(int bonusResistencia) {
        this.bonusResistencia = bonusResistencia;
        if (this.bonusResistencia > 100) {
            this.bonusResistencia = 100;
        }
    }
    
    //Métodos abstratos
    public abstract int getDano();
    
    public abstract int getResistencia();
    
    public abstract int atacar(Personagem atacado);
    
    public abstract void defender();
}
