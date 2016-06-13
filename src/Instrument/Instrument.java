package Instrument;

import java.io.IOException;

/**
 * Created by rafal on 02.06.2016.
 */
public class Instrument
        implements Metody {
    protected double _typ_instrumentu;
    protected double _waga = 0;
    protected double _cena = 0;
    protected int _il_sztuk = 0;
    protected String _material = "";
    protected String _nazwa = "";

    @Override
    public double get_typ_instr() {
        return _typ_instrumentu;
    }

    @Override
    public void get_param() {

    }

    @Override
    public void zapisz() throws IOException {

    }
}
