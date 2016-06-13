package Strunowy;
import Instrument.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by rafal on 02.06.2016.
 */
public class Uderzane
        extends Instrument
        implements Metody {
    private String _uderzane; //recznie/tangentem/mloteczkiem
    private int _il_strun;

    public Uderzane(double wag, double cen, int il_szt, String mat, String naz, int il_str, String uderz) {
        _typ_instrumentu = 1.3;
        _waga = wag;
        _cena = cen;
        _il_sztuk = il_szt;
        _material = mat;
        _nazwa = naz;
        _il_strun = il_str;
        _uderzane = uderz;
    }

    @Override
    public void get_param() {
        String s = "                                        ";
        System.out.println(s+"#  Instrument strunowy uderzany: #");
        System.out.println(s+"# -Nazwa: "+_nazwa);
        System.out.println(s+"# -Waga: "+_waga+" [kg]");
        System.out.println(s+"# -Cena: "+_cena+" [pln]");
        System.out.println(s+"# -Ilosc sztuk: "+_il_sztuk);
        System.out.println(s+"# -Material: "+_material);
        System.out.println(s+"# -Ilosc strun: "+_il_strun);
        System.out.println(s+"# -Uderzane: "+_uderzane);
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
            out.write(_typ_instrumentu+";"+_waga+";"+_cena+";"+_il_sztuk+";"+_material+";"+_nazwa+";"+_il_strun+";"+_uderzane);
            out.close();
        } catch (Exception e){
            System.err.println("Blad: "+e.getMessage());
        }
    }
}
