package livres;

public class Pays {

    private String nom;
    private String code;

    public Pays(String nom, String code) {
        this.nom = nom;
        if (code != null && code.matches("^[A-Z]{3}$")) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Le code pays doit contenir exactement 3 lettres majuscules.");
        }
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return nom + " (" + code + ")";
    }

}
