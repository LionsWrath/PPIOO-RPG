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
public class Guerreiro extends Body {

    private int dano;
    private int resistencia;

    public Guerreiro(String nome) {
        super(nome, 200);
        this.dano = 50;
        this.resistencia = 40;
    }
    
    @Override
    public int getDano() {
        return this.dano;
    }

    @Override
    public int getResistencia() {
        return this.resistencia;
    }

    //Arrumar o retorno depois
    @Override
    public int atacar(Personagem atacado) {
        float coeficiente = (((float)atacado.getResistencia() + (float)atacado.getBonusResistencia())/100)/3;
        atacado.setQuantidadeVida((int) (atacado.getQuantidadeVida() - (this.getBonusDano() + this.getDano() - ((this.getBonusDano() + this.getDano())*coeficiente))));
        atacado.setBonusResistencia(0);
        this.setBonusDano(0);
        
        return (int)(this.getBonusDano() + this.getDano() - ((this.getBonusDano() + this.getDano())*coeficiente));
    }

    @Override
    public void defender() {
        this.setBonusResistencia(this.getBonusResistencia()+this.getResistencia()/3);
    }
    
    //Verificar retorno depois
    @Override
    public void conjurar() {
        int coeficiente = ((this.getQuantidadeVida()*100)/200);
        this.setBonusDano(this.getDano()*(100 - coeficiente));
    }
}
