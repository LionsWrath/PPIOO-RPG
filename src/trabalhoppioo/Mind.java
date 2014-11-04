package trabalhoppioo;

public abstract class Mind extends Personagem {
    
    private int fatorIncremento;

    public Mind(int fatorIncremento, String nome, int quantidadeVida) {
        super(nome, quantidadeVida);
        setFatorIncremento(fatorIncremento);
    }

    public int getFatorIncremento() {
        return fatorIncremento;
    }

    public void setFatorIncremento(int fatorIncremento) {
        this.fatorIncremento = fatorIncremento;
    }
    
    public abstract float calcularFatorIncremento();
    
    public abstract void conjurar(Personagem alvo);

}
