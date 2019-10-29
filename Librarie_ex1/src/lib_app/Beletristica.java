package lib_app;

public class Beletristica extends Carte{

    int numarPersonaje;
    protected boolean disponibil = true;

    public Beletristica(String nume, String autor, double pret, int isbn, int numarPersonaje) {
        super(nume, autor, pret, isbn);
        this.numarPersonaje=numarPersonaje;

    }

    public int getNumarPersonaje() {
        return numarPersonaje;
    }

    public void setNumarPersonaje(int numarPersonaje) {
        this.numarPersonaje = numarPersonaje;
    }
    public void isbnDisponibil(){
    this.disponibil=false;
    }


}
