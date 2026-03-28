package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage {

    public enum FormatAudio { NUMERIQUE, ANALOGIQUE }

    private int dureeMinutes;

    private FormatAudio formatAudio;

    public OuvrageAudio(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int dureeMinutes, FormatAudio formatAudio) {

        super(titre, auteur, type, date, nombreExemplaires);

        this.dureeMinutes = dureeMinutes;

        this.formatAudio = formatAudio;

    }

    public int getDureeMinutes() {

        return dureeMinutes;

    }

    public FormatAudio getFormatAudio() {

        return formatAudio;

    }

}
 
