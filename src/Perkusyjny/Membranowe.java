package Perkusyjny;

import Instrument.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by rafal on 02.06.2016.
 */
public class Membranowe
        extends Instrument
        implements Metody{
    private String _wl_akustyczne; // wlasciwosci akustyczne - nieokreslonej/okreslonej wysokosci dzwieku
    private double _sr_membrany;    // [cm]
    private String _paleczki; // TAK / NIE

    public Membranowe(double wag, double cen, int il_szt, String mat, String naz, String pal, String wl_aku, double sr_memb){
        _typ_instrumentu = 3.2;
        _waga = wag;
        _cena = cen;
        _il_sztuk = il_szt;
        _material = mat;
        _nazwa = naz;
        _paleczki = pal;
        _wl_akustyczne = wl_aku;
        _sr_membrany = sr_memb;
    }

    @Override
    public void get_param() {
        String s = "                                        ";
        System.out.println(s+"# Instr. perkusyjny membranowy: #");
        System.out.println(s+"# -Nazwa: "+_nazwa);
        System.out.println(s+"# -Waga: "+_waga+" [kg]");
        System.out.println(s+"# -Cena: "+_cena+" [pln]");
        System.out.println(s+"# -Ilosc sztuk: "+_il_sztuk);
        System.out.println(s+"# -Material: "+_material);
        System.out.println(s+"# -Paleczki: "+_paleczki);
        System.out.println(s+"# -Wlasciwosci akustyczne: "+_wl_akustyczne);
        System.out.println(s+"# -Srednica membrany: "+_sr_membrany);
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
            out.write(_typ_instrumentu+";"+_waga+";"+_cena+";"+_il_sztuk+";"+_material+";"+_nazwa+";"+_paleczki+";"+_wl_akustyczne+";"+_sr_membrany);
            out.close();
        } catch (Exception e){
            System.err.println("Blad: "+e.getMessage());
        }
    }
}
