package tests;

import java.time.LocalDate;
import java.util.List;

import livres.*;

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

        // CORRECTION : Utilisation de OuvragePapier au lieu de Ouvrage
        Ouvrage o1 = new OuvragePapier("Les Misérables", auteurTest, 1200);
        Ouvrage o2 = new OuvragePapier("Notre-Dame de Paris", auteurTest, 900);

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
        Pays pCanada = new Pays("Canada", "CAN");
        Pays pUSA = new Pays("Etats-Unis", "USA");

        Auteur albertine = new Auteur("Albertine", "Tremblay", pCanada);
        Auteur john = new Auteur("John", "Smith", pUSA);

        System.out.println("-----Test des constructeurs par héritage et validations-----------");

        // TEST PAPIER
        OuvragePapier livreA = new OuvragePapier("Titre assez long", john, 350);
        System.out.println(livreA + " | Pages: " + livreA.getNbPages());

        // TEST AUDIO
        OuvrageAudio livreB = new OuvrageAudio("Audio Tech", john, Ouvrage.Format.AUDIO, LocalDate.now(), 5, 45, OuvrageAudio.FormatAudio.NUMERIQUE);
        System.out.println(livreB + " | Durée: " + livreB.getDureeMinutes() + " min");

        // TEST VIDEO
        OuvrageVideo livreC = new OuvrageVideo("Tuto Java", albertine, Ouvrage.Format.VIDEO, LocalDate.now(), 2, 120, 5000);
        System.out.println(livreC + " | Taille: " + livreC.getTailleMb() + " Mb");

        System.out.println("\n-----Tests des méthodes héritées (acheter/vendre)-----------");
        livreA.acheter(5);
        System.out.println("Après achat de 5: " + livreA.getNombreExemplaires() + " ex.");

        boolean venteOk = livreA.vendre(3);
        System.out.println("Vente de 3 réussie ? " + venteOk + " | Reste: " + livreA.getNombreExemplaires());

        System.out.println("\n-----Tests de la méthode equals()-----------");
        // Deux ouvrages papier identiques
        Ouvrage livre5 = new OuvragePapier("Test", john, 100);
        Ouvrage livre6 = new OuvragePapier("Test", john, 100);

        System.out.println("Test equals version Franck: " + livre5.equals(livre6));
        System.out.println("Test equals version dagorn partenaire: " + livre5.equals(livre6));
    }

    private void testTrouver() {
        System.out.println("\n-----Test de la Librairie (Recherche)-----------");
        Librairie maLib = new Librairie();


        Auteur a = maLib.getAuteurs().get(0);
        List<Ouvrage> resultats = maLib.trouverOuvrages(a);

        System.out.println("Ouvrages trouvés pour " + a.getNom() + " : " + resultats.size());
        for(Ouvrage o : resultats) {
            System.out.println(" - " + o.getTitre());
        }
    }
}