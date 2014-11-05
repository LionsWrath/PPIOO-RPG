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
public class TrabalhoPPIOO {

    //To do:
        //-Ver se as exceptions estão funcionando
        //-Verificação de mesmo nome na criação de personagens - Arrumar exceptions
        //-Corrigir magias de cura(Coeficiente) - ok
        //-Melhorar randomização de araques - opcional
        //-Corrigir ataques do computador - ok
        //-Verificação de personagens mortos
        //-Interface
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
    
        game.conjurarPersonagem(0);
        game.atacarPersonagem(0, 1);
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
