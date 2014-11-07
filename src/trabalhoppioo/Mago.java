package trabalhoppioo;

public class Mago extends Mind {
    
    private int dano;
    private int resistencia;

    public Mago(String nome){
        super(35, nome, 150);
        this.dano = 20;
        this.resistencia = 35;
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
        atacado.zeroBonusResistencia();
        this.zeroBonusDano();
        
        System.out.println("Dano: " + (float)this.getDano() + " Dano bonus: " + (float)this.getBonusDano() + " Coeficiente: " + coeficiente + " Vida: " + atacado.getQuantidadeVida());
        
        return (int)((this.getBonusDano() + this.getDano())*coeficiente);
    }

    @Override
    public void defender() {
        this.setBonusResistencia(this.getBonusResistencia()+this.getResistencia()/2);
    }

    @Override
    public float calcularFatorIncremento() {
        float coeficiente = (((float)this.getQuantidadeVida())/150);
        return (this.getFatorIncremento()*coeficiente);
    }

    @Override
    public void conjurar(Personagem alvo) {
        try {
            equals(alvo);
            System.out.println("Vida anterior: " + alvo.getQuantidadeVida());
            alvo.setQuantidadeVida((int) (alvo.getQuantidadeVida() + this.calcularFatorIncremento()));
            System.out.println("Heal: " + this.calcularFatorIncremento() + " Alvo: " + alvo.getNome() + " Vida atual: " + alvo.getQuantidadeVida() + " Vida: " + this.getQuantidadeVida() );
        } catch (MindException ce) {
            //
        }
}
    
    public void equals(Personagem alvo) throws MindException {
        if (alvo instanceof Mago) {
            Mago th = (Mago)alvo;
            if (th.getNome().equals(this.getNome())){
                throw new MindException();
            }
        }
    };
}
