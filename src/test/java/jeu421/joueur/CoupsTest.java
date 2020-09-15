package jeu421.joueur;

import jeu421.modele.Lancé;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import  org.junit.jupiter.api.Assertions;


public class CoupsTest {
    Lancé lancé;
    Coups coups;

    @BeforeEach
    public void setUp() throws Exception {
        coups = new Coups();
        lancé = new Lancé();
    }

    /**
     * pour tester la reconnaissance du 421 et des 10 jetons associés
     * @throws Exception
     */
 @Test
    public void valeurTestée421() throws Exception {
        lancé.ajouterJet(4);
        lancé.ajouterJet(1);
        lancé.ajouterJet(2);

        int nbJeton = coups.valeurLancé(lancé);

        assertEquals( 10,nbJeton, "valeur attentdue : 10 jetons");
    }


    @Test
    public void valeurTestée421AutreOrdre() throws Exception {
        lancé.ajouterJet(2);
        lancé.ajouterJet(4);
        lancé.ajouterJet(1);

        int nbJeton = coups.valeurLancé(lancé);

        assertEquals( 10,nbJeton, "valeur attentdue : 10 jetons");
    }

    @Test
    public void valeurTestée422() throws Exception {
        lancé.ajouterJet(2);
        lancé.ajouterJet(4);
        lancé.ajouterJet(2);

        int nbJeton = coups.valeurLancé(lancé);

        assertEquals( 1,nbJeton, "valeur attentdue : 10 jetons");
    }


    /**
     *
     * @throws Exception
     */
    @Test
    public void valeurTestée111() throws Exception {
        lancé.ajouterJet(1);
        lancé.ajouterJet(1);
        lancé.ajouterJet(1);

        int nbJeton = coups.valeurLancé(lancé);

        Assertions.assertEquals(7,nbJeton);
    }


    @Test
    public void valeurTestée444() throws Exception {
        lancé.ajouterJet(4);
        lancé.ajouterJet(4);
        lancé.ajouterJet(4);

        int nbJeton = coups.valeurLancé(lancé);
        Assertions.assertEquals( 4,nbJeton);

    }

    @Test
    public void valeurTestée114() throws Exception {
        lancé.ajouterJet(1);
        lancé.ajouterJet(1);
        lancé.ajouterJet(4);

        int nbJeton = coups.valeurLancé(lancé);
        Assertions.assertEquals( 4,nbJeton,"valeur attentdue : 4 jetons");

    }

}