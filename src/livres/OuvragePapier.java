package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage {
    private int nbPages;

    public OuvragePapier(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int nbPages) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.nbPages = nbPages;
    }

    public OuvragePapier(String titre, Auteur auteur, int nbPages) {
        super(titre, auteur);
        this.nbPages = nbPages;
    }

    public int getNbPages() {
        return nbPages;
    }
}
