package tests;

import java.time.LocalDate;
import java.util.List;

import livres.Ouvrage;
import livres.Auteur;
import livres.Serie;
import livres.Pays;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testSerie();
        test.testPays();
    }

    public void testSerie() {
        System.out.println("\n-----Test de la classe Serie (Ajout et Retrait)-----------");

        Pays france = new Pays("France", "FRA");
        Auteur auteurTest = new Auteur("Victor", "Hugo", france);
        Ouvrage o1 = new Ouvrage("Les Misérables", auteurTest);
        Ouvrage o2 = new Ouvrage("Notre-Dame de Paris", auteurTest);

        Serie maSerie = new Serie("Collection Classique");
        System.out.println("Nom de la série : " + maSerie.getNom());

        maSerie.ajouterOuvrages(o1);
        maSerie.ajouterOuvrages(o2);
        System.out.println("Nombre d'ouvrages après ajouts : " + maSerie.getOuvrages().size());

        maSerie.retirerOuvrage(o1);
        System.out.println("Nombre d'ouvrages après retrait : " + maSerie.getOuvrages().size());

        if (maSerie.getOuvrages().contains(o2)) {
            System.out.println("L'ouvrage restant est bien : " + o2.getTitre());
        }
    }
    public void testPays() {
        System.out.println("\n-----Test de la classe Pays et lien Auteur-----------");

        Pays p1 = new Pays("Canada", "CAN");
        System.out.println("Pays valide crée : " + p1);

        Auteur a1 = new Auteur("Albertine", "Tremblay", p1);
        System.out.println("Auteur lié au pays : " + a1.getNom() + " d'origine " + a1.getPaysOrigine().getNom());

        try {
            System.out.println("Test de validation code invalide (ca) :");
            Pays pInvalide = new Pays("Canada", "ca");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur interceptée comme prévu : " + e.getMessage());
        }
    }



    public void testOuvrages() {
//Deux auteurs deja prets pour les tests...
        Pays pCanada = new Pays("Canada", "CAN");
        Pays pUSA = new Pays("Etats-Unis", "USA");

        Auteur albertine = new Auteur("Albertine", "Tremblay", pCanada);
        Auteur john = new Auteur("John", "Smith", pUSA);

//Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new Ouvrage("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new Ouvrage(null, john);
        System.out.println(livreC);

//bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new Ouvrage("Titre assez long", null);
        System.out.println(livreA1);
//bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new Ouvrage("Tout va bien", albertine);
        System.out.println(livre1);

//Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

//Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10);
        System.out.println(livre2);

        livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new Ouvrage("Musique du hasard", new Auteur("Paul", "Auster", pUSA), Ouvrage.Format.PAPIER, LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new Ouvrage("Test", new Auteur("A", "B", pUSA), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("\n-----Tests de la méthode equals()-----------");
//Deux ouvrages égaux
        Ouvrage livre5 = new Ouvrage("Test", new Auteur("A", "B", pUSA), Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre6 = new Ouvrage("Test", new Auteur("A", "B", pUSA), Ouvrage.Format.PAPIER, LocalDate.now(), 10);
//Un qui ne l'est pas
        Ouvrage livre7 = new Ouvrage("Test", new Auteur("Z", "B", pUSA), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }

    private void testTrouver() {
// Logique de test pour trouverOuvrage
    }
}