package Instrument;

import java.io.IOException;

/**
 * Created by rafal on 11.06.2016.
 */
public interface Metody {
    double get_typ_instr();
    void get_param();
    void zapisz() throws IOException;
}
