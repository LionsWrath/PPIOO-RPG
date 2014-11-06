package trabalhoppioo;

public class Assassino extends Body {
    
    private int dano;
    private int resistencia;
    
    public Assassino(String nome){
        super(nome, 150);
        this.dano = 80;
        this.resistencia = 30;
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
        System.out.println("Dano: " + (float)this.getDano() + " Dano bonus: " + (float)this.getBonusDano() + " Coeficiente: " + coeficiente + " Vida antes: " + atacado.getMaxvida() + " Vida: " + atacado.getQuantidadeVida());
        atacado.zeroBonusResistencia();
        this.zeroBonusDano();
        
        return (int)((this.getBonusDano() + this.getDano())*coeficiente);
    }

    @Override
    public void defender() {
        this.setBonusResistencia(this.getBonusResistencia()+this.getResistencia()/2);
    }
    
    //Verificar retorno depois
    @Override
    public void conjurar() {
        float coeficiente = ((this.getQuantidadeVida())/150);
        this.setBonusDano((int) (this.getDano()*coeficiente));
        
        System.out.println("Dano Bonus: " + (int)(this.getDano()*coeficiente) + " Comparação: " + this.getBonusDano());
    }
}
