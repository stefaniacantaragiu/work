package lib_app;

public class Carte {
    public String nume;
    public String autor;
    public double pret;
    public int isbn;



    protected boolean disponibil = true;

    public Carte(String nume, String autor, double pret, int isbn){
        this.nume=nume;
        this.autor=autor;
        this.pret=pret;
        this.isbn=isbn;

    }



    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getNume(){
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;

    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


    public String toString()
    {
        return "Titlul cartii este: " + nume + " scrisa de  " + autor + " cu pretul " + pret + " cu codul:  " +isbn ;

    }

}
