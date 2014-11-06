package trabalhoppioo;

public class TrabalhoPPIOO {

    //To do:
        //-Ver se as exceptions estão funcionando
        //-Verificação de mesmo nome na criação de personagens - Arrumar exceptions
        //-Corrigir magias de cura(Coeficiente) - ok
        //-Melhorar randomização de araques - opcional
        //-Corrigir ataques do computador - ok
        //-Verificação de personagens mortos - Testar
        //-Interface
        //-Numero de vida limite na criação - testar
        //-Corrigir magias - testar
        //-retirar/arrumar prints para interface
        //-etc
    
    public static void main(String[] args) {
        Game game = new Game();
        
        game.adicionarAssassino("Tarkir");
        game.adicionarGuardião("Hueragem");
        game.adicionarGuerreiro("Jack");
        game.removerPersonagem();
        game.adicionarGuerreiro("Berserk");
        game.adicionarMago("Barbosa");
        game.adicionarMago("Melchior");
        game.adicionarMago("Melchior");
        game.adicionarMago("Hueragem");
        
        game.randomizeAction(0);
        game.randomizeAction(0);
        game.randomizeAction(0);
        game.randomizeAction(0);
        
        game.curarPersonagem(3, 0);
        game.curarPersonagem(3, 1);
        game.curarPersonagem(3, 2);
        game.curarPersonagem(3, 3);
        game.curarPersonagem(3, 4);
              
        game.atacarPersonagem(1, 1);
        game.conjurarPersonagem(2);
        game.atacarPersonagem(2, 1);
        game.atacarPersonagem(3, 1);
        //game.curarPersonagem(3, 3);
        
        game.randomizeAction(0);
        game.randomizeAction(1);
        game.randomizeAction(2);
        game.randomizeAction(3);
    }
    
}
