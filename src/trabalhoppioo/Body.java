package trabalhoppioo;

public abstract class Body extends Personagem {

    public Body(String nome, int quantidadeVida) {
        super(nome, quantidadeVida);
    }

    //Verificar o retorno depois
    public abstract void conjurar();
}
