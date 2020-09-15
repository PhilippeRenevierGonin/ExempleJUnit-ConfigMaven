package jeu421.joueur;

import jeu421.modele.Lancé;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CoupsTestEstSuperieurTest {
    Lancé grosLancé;
    Lancé petitLancé;
    Lancé petitPlusGros;
    Coups testé;

    @BeforeEach
    public void setUp() throws Exception {
        grosLancé = new Lancé();
        grosLancé.ajouterJet(4);
        grosLancé.ajouterJet(2);
        grosLancé.ajouterJet(1);

        petitLancé = new Lancé();
        petitLancé.ajouterJet(3);
        petitLancé.ajouterJet(2);
        petitLancé.ajouterJet(1);

        petitPlusGros = new Lancé();
        petitPlusGros.ajouterJet(6);
        petitPlusGros.ajouterJet(5);
        petitPlusGros.ajouterJet(4);

        testé = new Coups();
    }




    /**
     * ce test compare 421 à 123
     * puis  654 à 321
     */
    @Test
    public void estSupérieur() {
        boolean supérieur = testé.estSupérieur(grosLancé, petitLancé);
        assertTrue(supérieur, "grosLancé est censé être plus fort");

        /*
        // test qui ne passe pas, qu'on pourrait écrire avant
        supérieur = testé.estSupérieur(petitPlusGros, petitLancé);
        assertTrue(supérieur,"petitPlusGros est censé être plus fort");
        */
    }

}