package lib_app;

public class Istorie extends Carte {
    String eveniment;
    protected boolean disponibil = true;


    public Istorie(String nume, String autor, double pret, int isbn, String eveniment) {

        super(nume, autor, pret, isbn);
        this.eveniment=eveniment;
    }

    public String getEveniment() {
        return eveniment;
    }

    public void setEveniment(String eveniment) {

        this.eveniment = eveniment;
    }


}
