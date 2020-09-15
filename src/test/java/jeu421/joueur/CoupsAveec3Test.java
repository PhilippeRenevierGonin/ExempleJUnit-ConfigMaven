package jeu421.joueur;

import jeu421.modele.Lancé;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoupsAveec3Test {

    private Lancé lancé;
    private Coups coup;

    @BeforeEach
    void setUp() {
        lancé = new Lancé();
        coup = new Coups();
    }

    @Test
    void valeurLancé() {
        lancé.ajouterJet(3);
        lancé.ajouterJet(3);
        lancé.ajouterJet(3);

        assertEquals(3, coup.valeurLancé(lancé));

    }
}