package jeu421;

import jeu421.joueur.Coups;
import jeu421.joueur.Joueur421;
import jeu421.modele.Lancé;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class UnePartieDe421 {

    Joueur421 joueur ;
    Coups coups;

    public UnePartieDe421() {
        coups = new Coups();
    }

    /**
     * configuration de la sortie textuelle en utf-8. <br>
     * sous windows, dans cmd, il faudra taper chcp 65001 pour passer la console en UTF-8 et avoir une
     * police de caractère compatible (Courier New)
     */
    public void initialisation(Joueur421 j) {
        joueur = j;

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     */
    public void uneManche() {
        Lancé lancé = joueur.jouer(3);
        System.out.println("résultat du lancé : "+lancé);
        int points = coups.valeurLancé(lancé);
        System.out.println("nb de points : "+points);

    }

    public static void main(String[] args) {
        UnePartieDe421 partie = new UnePartieDe421();
        partie.initialisation(new Joueur421());
         partie.uneManche();
    }
}
