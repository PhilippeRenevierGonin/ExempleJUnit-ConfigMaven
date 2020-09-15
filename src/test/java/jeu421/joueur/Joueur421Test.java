package jeu421.joueur;

import jeu421.modele.Dé;
import jeu421.modele.Lancé;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Joueur421Test {


    @Mock
    Dé monDé ;


    @Test
    public void jouer() throws Exception {
        when(monDé.lancer()).thenReturn(4,2,1);

        Joueur421 joueur = new Joueur421();
        joueur.setDé(monDé);

        Lancé lancé = joueur.jouer(3);

        for(int i=0; i<3; i++) Assertions.assertTrue(lancé.estConservé(i));
    }


    @Disabled
    @Test
    public void jouer111() throws Exception {
        when(monDé.lancer()).thenReturn(1,1,1);

        Joueur421 joueur = new Joueur421();
        joueur.setDé(monDé);

        Lancé lancé = joueur.jouer(3);

        for(int i=0; i<3; i++) Assertions.assertTrue( lancé.estConservé(i),"le dé est conservé");
    }

}