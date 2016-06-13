package Strunowy;
import Instrument.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by rafal on 02.06.2016.
 */
public class Szarpane
        extends Instrument
        implements Metody{
    private String _wzbudzanie_drgan; //rece gole/uzbrojone, drewniane pioro
    private int _il_strun;

    public Szarpane(double wag, double cen, int il_szt, String mat, String naz, int il_str, String wz_drg){
        _typ_instrumentu = 1.2;
        _waga = wag;
        _cena = cen;
        _il_sztuk = il_szt;
        _material = mat;
        _nazwa = naz;
        _il_strun = il_str;
        _wzbudzanie_drgan = wz_drg;
    }

    @Override
    public void get_param() {
        String s = "                                        ";
        System.out.println(s+"#  Instrument strunowy szarpany: #");
        System.out.println(s+"# -Nazwa: "+_nazwa);
        System.out.println(s+"# -Waga: "+_waga+" [kg]");
        System.out.println(s+"# -Cena: "+_cena+" [pln]");
        System.out.println(s+"# -Ilosc sztuk: "+_il_sztuk);
        System.out.println(s+"# -Material: "+_material);
        System.out.println(s+"# -Ilosc strun: "+_il_strun);
        System.out.println(s+"# -Wzbudzanie drgan: "+_wzbudzanie_drgan);
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
            out.write(_typ_instrumentu+";"+_waga+";"+_cena+";"+_il_sztuk+";"+_material+";"+_nazwa+";"+_il_strun+";"+_wzbudzanie_drgan);
            out.close();
        } catch (Exception e){
            System.err.println("Blad: "+e.getMessage());
        }
    }
}
