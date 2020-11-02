package jeu421.joueur;

import jeu421.modele.Lancé;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoupsAvec3Test {

    private Lancé lancé;
    private Coups coup;

    @BeforeEach
    void setUp() {
        lancé = new Lancé();
        coup = new Coups();

        lancé.ajouterJet(3);
        lancé.ajouterJet(3);
    }

    @Test
    void valeurLancéAvecTrois3() {
        lancé.ajouterJet(3);

        assertEquals(3, coup.valeurLancé(lancé));

    }


    @Test
    void valeurLancéAvecDeux3() {
        lancé.ajouterJet(1);
        assertEquals(1, coup.valeurLancé(lancé));

    }
}