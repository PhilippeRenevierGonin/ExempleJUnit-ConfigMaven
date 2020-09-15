package jeu421.modele;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LancéTest {
    private Lancé lancé ;


    @BeforeEach
    public void setUp() {
       lancé = new Lancé();
    }


    @Test
    public void ajouterJet() throws Exception {

        lancé.ajouterJet(1);
        Assertions.assertEquals( 1, lancé.listeDeLancés.size(), "la liste doit être de taille 1");
        Assertions.assertEquals(1, lancé.valeurJet(0), "la valeur doit être  1");

        lancé.ajouterJet(2);
        Assertions.assertEquals(2, lancé.listeDeLancés.size(),"la liste doit être de taille 2");
        Assertions.assertEquals( 2, lancé.valeurJet(1), "la valeur doit être  2");

    }


    @Test
    public void ajouterJetsOrdonnésCroissants() throws Exception {

        for (int i = 1; i < 6; i++) {
            lancé.ajouterJet(i);
            Assertions.assertEquals( i, lancé.listeDeLancés.size(), "la liste doit être de taille " + i);
            Assertions.assertEquals( i, lancé.valeurJet(i-1), "la valeur doit être  "+i);

        }

    }

    @Test
    public void ajouterJetsOrdonnésDéCroissants() throws Exception {

        for (int i = 1; i < 6; i++) {
            lancé.ajouterJet(7-i);
            Assertions.assertEquals( i, lancé.listeDeLancés.size(), "la liste doit être de taille " + i);
            Assertions.assertEquals( 7-i, lancé.valeurJet(0), "la valeur doit être  "+(7-i)); // toujours ajouté en premier
        }

    }


    @Test
    public void ajouterJet3MêmesValeurs() throws Exception {

        for (int i = 1; i <= 3; i++) {
            lancé.ajouterJet(2);
            Assertions.assertEquals( i, lancé.listeDeLancés.size(), "la liste doit être de taille " + i);
            Assertions.assertEquals(2, lancé.valeurJet(i-1),"la valeur doit être  "+i);

        }
    }

    @Test
    public void enDernierQuiSePlaceEnAvantDernier()     throws Exception {
        for (int i = 1; i <= 3; i++) {
            lancé.ajouterJet(2);
            Assertions.assertEquals(i, lancé.listeDeLancés.size(),"la liste doit être de taille " + i);
            Assertions.assertEquals(2, lancé.valeurJet(i-1), "la valeur doit être  "+i);

        }

        lancé.ajouterJet(6);
        Assertions.assertEquals( 4, lancé.listeDeLancés.size(), "la liste doit être de taille " + 4);
        Assertions.assertEquals(6, lancé.valeurJet(4-1), "la valeur doit être  "+6);


        lancé.ajouterJet(5);
        Assertions.assertEquals( 5, lancé.listeDeLancés.size(),"la liste doit être de taille " + 5);
        Assertions.assertEquals( 5, lancé.valeurJet(4-1), "la valeur doit être  "+5);
        Assertions.assertEquals( 6, lancé.valeurJet(5-1), "la valeur doit être  "+6); // nouvelle dernière valeur


    }

}