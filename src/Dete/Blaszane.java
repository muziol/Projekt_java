package Dete;

import Instrument.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by rafal on 02.06.2016.
 */
public class Blaszane
        extends Instrument
        implements Metody {
    private String _typ_ustnika; //lejkowaty, kociolkowaty
    private double _sr_roztrabu; //[cm]
    private double _dl_rury;

    public Blaszane(double wag, double cen, int il_szt, String mat, String naz, double dl_rury, String typ_ust, double sr_rozt) {
        _typ_instrumentu = 2.2;
        _waga = wag;
        _cena = cen;
        _il_sztuk = il_szt;
        _material = mat;
        _nazwa = naz;
        _dl_rury = dl_rury;
        _typ_ustnika = typ_ust;
        _sr_roztrabu = sr_rozt;
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
        System.out.println(s+"# -Typ ustnika: "+_typ_ustnika);
        System.out.println(s+"# -Srednica roztrabu: "+_sr_roztrabu+" [cm]");
    }

    @Override
    public void zapisz() throws IOException {
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
            out.write(_typ_instrumentu+";"+_waga+";"+_cena+";"+_il_sztuk+";"+_material+";"+_nazwa+";"+_dl_rury+";"+_typ_ustnika+";"+_sr_roztrabu);
            out.close();
        } catch (Exception e){
            System.err.println("Blad: "+e.getMessage());
        }
    }
}
