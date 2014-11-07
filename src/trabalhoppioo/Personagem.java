package trabalhoppioo;

public abstract class Personagem {

    private String nome;
    private int quantidadeVida;
    private int maxvida;
    
    private int bonusDano;
    private int bonusResistencia;

    public Personagem(String nome, int quantidadeVida) {
        setNome(nome);
        this.quantidadeVida = quantidadeVida;
        this.maxvida = quantidadeVida;
        this.bonusDano = 0;
        this.bonusResistencia = 0;
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
        if (this.quantidadeVida > (this.maxvida + this.maxvida*0.10)) {
            this.quantidadeVida = this.maxvida;
        }
        if (this.quantidadeVida < 0) {
            this.quantidadeVida = 0;
        }
    }

    //
    public int getBonusDano() {
        return bonusDano;
    }

    public void setBonusDano(int bonusDano) {
        this.bonusDano = this.bonusDano + bonusDano;
        if (this.bonusDano > 150) {
            this.bonusDano = 150;
        }
    }
    
    public void zeroBonusDano() {
        this.bonusDano = 0;
    }

    //
    public int getBonusResistencia() {
        return bonusResistencia;
    }

    public void setBonusResistencia(int bonusResistencia) {
        this.bonusResistencia = this.bonusResistencia + bonusResistencia;
        if (this.bonusResistencia > 100) {
            this.bonusResistencia = 100;
        }
    }
    
    public void zeroBonusResistencia() {
        this.bonusResistencia = 0;
    }

    public int getMaxvida() {
        return maxvida;
    }
    
    //Métodos abstratos
    public abstract int getDano();
    
    public abstract int getResistencia();
    
    public abstract int atacar(Personagem atacado);
    
    public abstract void defender();
}
