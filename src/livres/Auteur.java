package livres;

import java.util.Objects;
/**
 * Cours POO 1
 *
 * @author Julien.Brunet maj Jocelyn
 * @since H25
 */
public class Auteur {

    public static final String INCONNU = "Inconnu";

    private String prenom = INCONNU;
    private String nom = INCONNU;
    private Pays paysOrigine;

    public Auteur(String prenom, String nom, Pays paysOrigine) {
        setPrenom(prenom);
        setNom(nom);
        setPaysOrigine(paysOrigine);
    }

    public Auteur() {
        this(INCONNU, INCONNU, null);
    }

    public String getPrenom() {
        return prenom;
    }

    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPaysOrigine() {
        return paysOrigine;
    }

    private void setPaysOrigine(Pays paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    @Override
    public String toString() {
        String paysTxt = (paysOrigine != null) ? paysOrigine.toString() : INCONNU;
        return prenom + " " + nom + " (origine : " + paysTxt + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auteur)) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(prenom, auteur.prenom) &&
                Objects.equals(nom, auteur.nom) &&
                Objects.equals(paysOrigine, auteur.paysOrigine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom, paysOrigine);
    }
}