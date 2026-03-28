package livres;

import java.util.ArrayList;
import java.util.List;

public class Librairie {
    private List<Auteur> auteurs  = new ArrayList<>();
    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Librairie() {
        // 1. On crée les objets Pays nécessaires
        Pays canada = new Pays("Canada", "CAN");
        Pays usa = new Pays("Etats-Unis", "USA");
        Pays suisse = new Pays("Suisse", "CHE");

        // 2. On crée les Auteurs avec les objets Pays
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        Auteur john = new Auteur("John", "Smith", usa);
        Auteur jean = new Auteur("Jean", "Némarre", suisse);
        auteurs.add(albertine);
        auteurs.add(john);
        auteurs.add(jean);

        // 3. On remplit le catalogue avec les SOUS-CLASSES (Héritage)
        // Note : J'ajoute des valeurs par défaut pour les pages/durée
        ouvrages.add(new OuvragePapier("Titre 1", john, 200));
        ouvrages.add(new OuvragePapier("Titre 2", albertine, 150));
        ouvrages.add(new OuvragePapier("Titre 3", john, 300));
        ouvrages.add(new OuvragePapier("Titre 4", john, 100));
        ouvrages.add(new OuvragePapier("Titre 5", albertine, 400));
        ouvrages.add(new OuvragePapier("Titre 6", john, 250));
        ouvrages.add(new OuvragePapier("Titre 7", john, 180));
        // Pour les formats Vidéo et Audio, on utilise les constructeurs spécifiques
        ouvrages.add(new OuvrageVideo("Titre 8", albertine, Ouvrage.Format.VIDEO, null, 0, 120, 4500));
        ouvrages.add(new OuvrageAudio("Titre 9", john, Ouvrage.Format.AUDIO, null, 0, 60, OuvrageAudio.FormatAudio.NUMERIQUE));
        ouvrages.add(new OuvragePapier("Titre 10", jean, 320));
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public List<Ouvrage> trouverOuvrages(Auteur auteur) {
        List<Ouvrage> trouves = new ArrayList<>();
        for (Ouvrage ouvrage : ouvrages) {
            // Le .equals() fonctionnera si tu l'as généré dans la classe Auteur
            if (ouvrage.getAuteur() != null && ouvrage.getAuteur().equals(auteur)) {
                trouves.add(ouvrage);
            }
        }
        return trouves;
    }
}