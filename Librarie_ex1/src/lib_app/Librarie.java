package lib_app;

import javax.swing.*;
import java.util.*;

public class Librarie extends JFrame {

    private List<Carte> carti = new ArrayList();
    int nrCarti=0;



    public static Librarie getInstance () {
        Librarie singleton = null;
        if (singleton == null) {
            singleton = new Librarie();
        }
        return singleton;
    }

    public void afisareCarti () {
        for (int i = 0; i < this.carti.size(); ++i) {
            System.out.println("Catalog carti: " + this.carti.get(i));
        }

    }

    public void afisareCartiBeletristica () {
        for (int i = 0; i < this.carti.size(); ++i) {
            if (this.carti.get(i) instanceof Beletristica) {
                System.out.println("Catalog carti beletristica: " + this.carti.get(i));

            }
        }
    }

    public void afisareCartiIstorie () {
        for (int i = 0; i < this.carti.size(); ++i) {
            if (this.carti.get(i) instanceof Istorie)
                System.out.println("Catalog carti istorie: " + this.carti.get(i));
        }
    }

    public void adaugaCarte (Carte carte) {

        this.carti.add(carte);
        nrCarti++;

    }

    public void stergeCarteDupaIsbn (int isbn) {
        ListIterator<Carte> iter = carti.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getIsbn() == isbn) {
                iter.remove();
            }
        }
    }

    public void stergeCarteDupaAutor (String autor) {
        carti.removeIf(carte1 -> carte1.getAutor().equals(autor));
    }

    public void adaugaLibrarie (Carte carte) throws NotEnoughSpaceException, DuplicateIsbnException {


        if (carti.contains(carte.getIsbn())) {
            throw new DuplicateIsbnException("DuplicateIsbmException");
        } else if (nrCarti > 100) {
            throw new NotEnoughSpaceException("NotEnoughSpaceException");
        }
        adaugaCarte(carte);

    }


    public static void main (String[] args) throws Exception {
        Librarie librarie = new Librarie();

        librarie.adaugaLibrarie(new Beletristica("Casa somnului", "Jonathan Coe", 19, 469, 20));
        librarie.adaugaLibrarie(new Istorie("O scurta istorie ilustrata a romanilor ", "NeaguDjuvara", 10, 4368889, "istorie romani"));

        //folosim ac isbn pentru a primi exceptie
        //librarie.adaugaLibrarie(new Istorie("Limba franceza a evului mediu ", "Francois Auteuil", 10, 43669, "evul mediu"));
        librarie.adaugaLibrarie(new Beletristica("Dune", "Frank Herbert", 29, 43579, 20));

        Scanner sc = new Scanner(System.in);
        String line;
        boolean stop=false;
        String[] vector;
        while (!stop) {
            line = sc.nextLine();
            vector = line.split("\\s+");
            switch (vector[0].toUpperCase()) {

                case "ADD":
                    if (vector[1].equals("istorie")) {
                        librarie.adaugaLibrarie(new Istorie(vector[2], vector[3], Integer.parseInt(vector[4]), Integer.parseInt(vector[5]), vector[6]));
                    } else if (vector[1].equals("beletristica")) {
                        librarie.adaugaLibrarie(new Beletristica(vector[2], vector[3], Integer.parseInt(vector[4]), Integer.parseInt(vector[5]), Integer.parseInt(vector[6])));
                    }
                    break;
                case "BUY":
                    librarie.stergeCarteDupaIsbn(Integer.parseInt(vector[1]));
                    break;
                case "PRINT":
                    librarie.afisareCarti();
                    break;
                case "PRINT_H":
                    librarie.afisareCartiIstorie();
                    break;
                case "REMOVE":
                    librarie.stergeCarteDupaAutor(vector[1]);
                    break;
                case "EXIT": {
                    stop=true;
                    break;
                }
            }

        }


        librarie.afisareCartiBeletristica();

    }


}