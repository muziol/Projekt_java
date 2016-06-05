package Instrument;

/**
 * Created by rafal on 02.06.2016.
 */
public interface Instrument {
    float _waga = 0;
    float _cena = 0;
    int _il_sztuk = 0;
    String _material = "";
    String _nazwa = "";
    public abstract void set_param();
    public abstract void get_param();
}
