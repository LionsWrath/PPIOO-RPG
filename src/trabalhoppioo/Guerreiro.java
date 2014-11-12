package trabalhoppioo;

public class Guerreiro extends Body {

    private int dano;
    private int resistencia;

    public Guerreiro(String nome) {
        super(nome, 200);
        this.dano = 65;
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
        float coeficiente = (((float)atacado.getResistencia() + (float)atacado.getBonusResistencia())/10);
        atacado.setQuantidadeVida((int) (atacado.getQuantidadeVida() - ((this.getBonusDano() + this.getDano())/coeficiente)));
        System.out.println("Dano: " + (float)this.getDano() + " Dano bonus: " + (float)this.getBonusDano() + " Coeficiente: " + coeficiente + " Vida: " + atacado.getQuantidadeVida());
        atacado.zeroBonusResistencia();
        this.zeroBonusDano();
            
        return (int)((this.getBonusDano() + this.getDano())/coeficiente);
    }

    @Override
    public void defender() {
        this.setBonusResistencia(this.getBonusResistencia()+this.getResistencia()/2);
    }
    
    //Verificar retorno depois
    @Override
    public void conjurar() {
        float coeficiente = ((this.getQuantidadeVida())/200);
        this.setBonusDano((int) (this.getDano()*(1.2 - coeficiente)));
    }
}
