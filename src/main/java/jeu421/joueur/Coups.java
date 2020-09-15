package jeu421.joueur;

import jeu421.modele.Lancé;

/**
 * un modélisation des coups au 421.
 * Permet également de comparer des lancés.
 * @see <a href="https://www.regles-de-jeux.com/regle-du-421/">les règles du jeu</a>
 */
public class Coups {

    /**
     * recheche s'il y a une combinaison dans le
     * lancé de 3 dés
     * @param lancé représente le jet de n dés
     * @return la valeur en jetons
     */
    public int valeurLancé(Lancé lancé) {
        int nbJetons = 1;

        int[] jets = new int[3]; // @TODO ATTENTION CHIFFRE EN DUR !!
        for(int i = 0; i < 3; i++) {
            jets[i] = lancé.valeurJet(i);
        }

        // y'a plus qu'à tester les coups
        // 421
        if ((jets[0] == 1) && (jets[1] == 2) && (jets[2] == 4)) nbJetons = 10;
        // 111 ou 11n
        else if ((jets[0] == 1) && (jets[1] == 1)) {
            if (jets[2] == 1) nbJetons = 7;
            else nbJetons = jets[2];
        }
        // brelan (autre que 1)
        else if ((jets[0] == jets[1]) && (jets[1] == jets[2])) nbJetons = jets[2];
        // suite
        else if ((jets[0]+1 == jets[1]) && (jets[1]+1 == jets[2])) nbJetons = 2;
        // nénette
        else if ((jets[0] == 1) && (jets[1] == 2) && (jets[2] == 2)) nbJetons = 2;


        return nbJetons;
    }

    /**
     * contient une erreur, il faut affiner la comparaison si la valeur du jet et la même
     * @param un
     * @param deux
     * @return
     */
    public boolean estSupérieur(Lancé un, Lancé deux) {
        int valeurUn = valeurLancé(un);
        int valeurDeux = valeurLancé(deux);

        return (valeurUn > valeurDeux);
    }
}
