package jeu421.joueur;

import jeu421.modele.Dé;
import jeu421.modele.Lancé;

public class Joueur421 {
    private Dé dé = new Dé();

    public void setDé(Dé dé) {
        this.dé = dé;
    }


    public Lancé jouer(int nbJets) {
        Lancé lancé = new Lancé();
        for(int i = 0; i < nbJets; i++) {
            lancé.ajouterJet(dé.lancer());
        }

        // on ne garde que le 421 ;
        if ((lancé.valeurJet(0) == 1) && (lancé.valeurJet(1) == 2) && (lancé.valeurJet(2) == 4))
        {
            lancé.retenirJet(0);
            lancé.retenirJet(1);
            lancé.retenirJet(2);
        }

        return lancé;
    }
}
