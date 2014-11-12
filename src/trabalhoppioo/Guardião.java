    package trabalhoppioo;

public class Guardião extends Mind {
    
    private int dano;
    private int resistencia;
    
    public Guardião(String nome) {
        super(15, nome, 450);
        this.dano = 15;
        this.resistencia = 55;
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
        
        return (int)((this.getBonusDano() + this.getDano())/coeficiente);
    }

    @Override
    public void defender() {
        this.setBonusResistencia(this.getBonusResistencia()+this.getResistencia()/2);
    }

    @Override
    public float calcularFatorIncremento() {
        float coeficiente = (float) ((this.getQuantidadeVida())/450);
        if (coeficiente == 1) {
            return (float) (this.getFatorIncremento() - 0.1);
        } else {
            return (this.getFatorIncremento() - (this.getFatorIncremento()*coeficiente));
        }
    }

    @Override
    public int conjurar(Personagem alvo) {
        try {
            equals(alvo);
            alvo.setQuantidadeVida((int) (alvo.getQuantidadeVida() + this.calcularFatorIncremento()));
            alvo.setBonusResistencia((int) (alvo.getBonusResistencia() + (this.calcularFatorIncremento()/2)));
            alvo.setBonusDano((int) (alvo.getBonusDano() + (this.calcularFatorIncremento()/3)));
            System.out.println("Heal: " + this.calcularFatorIncremento() + " Alvo: " + alvo.getNome() + "Vida: " + this.getQuantidadeVida() );
            
            return (int) this.calcularFatorIncremento();
        } catch (MindException ce) {
            //
        }
        return 0;
    }
    
    public void equals(Personagem alvo) throws MindException {
        if (alvo instanceof Guardião) {
            Guardião th = (Guardião)alvo;
            if (th.getNome().equals(this.getNome())){
                throw new MindException();
            }
        }
    };
}
