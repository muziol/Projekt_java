package Dete;

import Instrument.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by rafal on 02.06.2016.
 */
public class Klawiszowe
        extends Instrument
        implements Metody{
    private int _il_klawiszy;
    private double _dl_rury;

    public Klawiszowe(double wag, double cen, int il_szt, String mat, String naz, double dl_rury, int il_klaw){
        _typ_instrumentu = 2.3;
        _waga = wag;
        _cena = cen;
        _il_sztuk = il_szt;
        _material = mat;
        _nazwa = naz;
        _dl_rury = dl_rury;
        _il_klawiszy = il_klaw;
    }

    @Override
    public void get_param() {
        String s = "                                        ";
        System.out.println(s+"#    Instrument dety blaszany:    #");
        System.out.println(s+"# -Nazwa: "+_nazwa);
        System.out.println(s+"# -Waga: "+_waga+" [kg]");
        System.out.println(s+"# -Cena: "+_cena+" [pln]");
        System.out.println(s+"# -Ilosc sztuk: "+_il_sztuk);
        System.out.println(s+"# -Material: "+_material);
        System.out.println(s+"# -Dlugosc rury: "+_dl_rury+" [cm]");
        System.out.println(s+"# -Ilosc klawiszy: "+_il_klawiszy);
    }

    @Override
    public void zapisz() {
        File data = new File("data.txt");
        try {
            int line = 0;
            if (!data.exists()){
                data.createNewFile();
                line = 1;
            }
            FileWriter plik = new FileWriter(data, true);
            BufferedWriter out = new BufferedWriter(plik);
            if (line == 0) { out.newLine(); }
            out.write(_typ_instrumentu+";"+_waga+";"+_cena+";"+_il_sztuk+";"+_material+";"+_nazwa+";"+_dl_rury+";"+_il_klawiszy);
            out.close();
        } catch (Exception e){
            System.err.println("Blad: "+e.getMessage());
        }
    }
}
