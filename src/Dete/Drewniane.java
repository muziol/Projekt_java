package Dete;
import Instrument.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by rafal on 02.06.2016.
 */
public class Drewniane
        extends Instrument
        implements Metody{
    private int _il_otworow;        //
    private String _typ_wibratora;  // pojedynczy/podwojny stroik, wibrator krawedziowy
    private double _dl_rury;

    public Drewniane(double wag, double cen, int il_szt, String mat, String naz, double dl_rury, String typ_wib, int il_otw){
        _typ_instrumentu = 2.1;
        _waga = wag;
        _cena = cen;
        _il_sztuk = il_szt;
        _material = mat;
        _nazwa = naz;
        _dl_rury = dl_rury;
        _typ_wibratora = typ_wib;
        _il_otworow = il_otw;
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
        System.out.println(s+"# -Typ wibratora: "+_typ_wibratora);
        System.out.println(s+"# -Ilosc otworow: "+_il_otworow);
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
            out.write(_typ_instrumentu+";"+_waga+";"+_cena+";"+_il_sztuk+";"+_material+";"+_nazwa+";"+_dl_rury+";"+_typ_wibratora+";"+_il_otworow);
            out.close();
        } catch (Exception e){
            System.err.println("Blad: "+e.getMessage());
        }
    }
}
