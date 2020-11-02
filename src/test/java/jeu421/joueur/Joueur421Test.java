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


    /**
     * vérification que lorsqu'on a 421 en lancé de dé, on garde tout
     * @throws Exception
     */
    @Test
    public void jouer() throws Exception {
        when(monDé.lancer()).thenReturn(4,2,1);

        Joueur421 joueur = new Joueur421();
        joueur.setDé(monDé);

        Lancé lancé = joueur.jouer(3);

        for(int i=0; i<3; i++) Assertions.assertTrue(lancé.estConservé(i));
    }


    // @Disabled
    @Test
    public void jouer111() throws Exception {
        when(monDé.lancer()).thenReturn(1,1,1);

        Joueur421 joueur = new Joueur421();
        joueur.setDé(monDé);

        Lancé lancé = joueur.jouer(3);

        for(int i=0; i<3; i++) Assertions.assertTrue( lancé.estConservé(i),"le dé est conservé");
    }


    /**
     * vérifie que sur un lancé 245 le 2 et le 4 sont gardé
     * ne passe pas car jouer n'est pas complétement fait
     * @throws Exception
     */
    @Disabled @Test
    public void jouer542() throws Exception {
        when(monDé.lancer()).thenReturn(5,4,2);

        Joueur421 joueur = new Joueur421();
        joueur.setDé(monDé);

        Lancé lancé = joueur.jouer(3);

        Assertions.assertTrue( lancé.estConservé(0),"le dé 2 est conservé");
        Assertions.assertTrue( lancé.estConservé(1),"le dé 4 est conservé");
        Assertions.assertFalse( lancé.estConservé(2),"le dé 5 n'est pas conservé");
    }

}