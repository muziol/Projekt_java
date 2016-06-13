package Baza_danych;

import Dete.*;
import Instrument.Instrument;
import Okno.Okno;
import Perkusyjny.*;
import Strunowy.*;
import java.io.*;
import java.util.*;


public class Baza_danych {
    private Vector<Instrument> tab = new Vector<Instrument>();

    private void odczyt() throws IOException {
       try{
           FileInputStream plik = new FileInputStream("data.txt");
           DataInputStream in = new DataInputStream(plik);
           BufferedReader br = new BufferedReader(new InputStreamReader(in));
           String strLine;
           while ((strLine = br.readLine()) != null){
               List<String> list = new ArrayList<>(Arrays.asList(strLine.split(";")));
               // PROBA
               //System.out.println(list.get(8));
                   if ("1.1".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       int il_str = Integer.parseInt(list.get(6));
                       Smyczkowy tmp = new Smyczkowy(wag, cen, il_szt, list.get(4), list.get(5), il_str, list.get(7));
                       tab.add(tmp);
                   }
                   else if ("1.2".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       int il_str = Integer.parseInt(list.get(6));
                       Szarpane tmp = new Szarpane(wag, cen, il_szt, list.get(4), list.get(5), il_str, list.get(7));
                       tab.add(tmp);
                   }
                   else if ("1.3".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       int il_str = Integer.parseInt(list.get(6));
                       Uderzane tmp = new Uderzane(wag, cen, il_szt, list.get(4), list.get(5), il_str, list.get(7));
                       tab.add(tmp);
                   }
                   else if ("2.1".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       double dl_rury = Double.parseDouble(list.get(6));
                       int il_otw = Integer.parseInt(list.get(8));
                       Drewniane tmp = new Drewniane(wag, cen, il_szt, list.get(4), list.get(5), dl_rury, list.get(7), il_otw);
                       tab.add(tmp);
                   }
                   else if ("2.2".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       double dl_rury = Double.parseDouble(list.get(6));
                       double sr_rozt = Double.parseDouble((list.get(8)));
                       Blaszane tmp = new Blaszane(wag, cen, il_szt, list.get(4), list.get(5), dl_rury, list.get(7), sr_rozt);
                       tab.add(tmp);
                   }
                   else if ("2.3".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       double dl_rury = Double.parseDouble(list.get(6));
                       int il_klaw = Integer.parseInt(((list.get(8))));
                       Klawiszowe tmp = new Klawiszowe(wag, cen, il_szt, list.get(4), list.get(5), dl_rury, il_klaw);
                       tab.add(tmp);
                   }
                   else if ("3.1".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       Samobrzmiace tmp = new Samobrzmiace(wag, cen, il_szt, list.get(4), list.get(5), list.get(6), list.get(7));
                       tab.add(tmp);
                   }
                   else if ("3.2".equals(list.get(0))){
                       double wag = Double.parseDouble(list.get(1));
                       double cen = Double.parseDouble(list.get(2));
                       int il_szt = Integer.parseInt(list.get(3));
                       double sr_memb = Double.parseDouble(list.get(8));
                       Membranowe tmp = new Membranowe(wag, cen, il_szt, list.get(4), list.get(5), list.get(6), list.get(7), sr_memb);
                       tab.add(tmp);
                   }
               list.clear();
               }
           plik.close();
       } catch (FileNotFoundException e) {
           Okno okno = new Okno();
           okno.tekst("Nie znaleziono pliku z danymi !");
       }
        File plik = new File("data.txt");
        if (plik.delete()){
            zapisz();
        }
    }

    private void zapisz() throws IOException {
            File plik = new File("C:\\Users\\rafal\\Desktop\\projektv1_java\\Projekt_java\\data.txt");
            Instrument tmp;
            if (plik.delete()){  }
            for (int i=0; i < tab.size(); i++){
                tmp = tab.get(i);
            tmp.zapisz();
        }
    }

    private void powitaj(){
        Okno ekran = new Okno();
        ekran.ramka(1, "Witamy w BiBi !");
    }

    private void interfejs(){
        Okno ekran = new Okno();
        ekran.ramka(-1, "Co chcesz zrobic ?");
        ekran.ramka(0, "1. Dodaj instrument");
        ekran.ramka(0, "2. Usun instrument ");
        ekran.ramka(0, "3. Wypisz          ");
        ekran.ramka(3, "4. Zapisz i wyjdz  ");
    }

    private void dodaj_instrument(){
        Okno ekran = new Okno();
        int odp=0, blad;
        while (odp>4 || odp<1){
            blad=0;
            ekran.ramka(-1, "Wybierz rodzaj instrumentu:");
            ekran.ramka(0, "1. Strunowy  ");
            ekran.ramka(0, "2. Dety      ");
            ekran.ramka(0, "3. Perkusyjny");
            ekran.ramka(3, "4. Powrot    ");
            Scanner klawiatura = new Scanner(System.in);
            try{
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad = 1;
            }
            if ((odp>4 || odp<1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
        }
        if (odp == 1){ dodaj_strunowy(); }
        else if (odp == 2){ dodaj_dety(); }
        else if (odp == 3){ dodaj_perkusyjny(); }
    }

    private void dodaj_strunowy(){
        String typ_smy="", mat, naz, wz_drg="", uderz="";
        double wag=-1, cen=-1;
        int il_szt=-1, il_str=-1, odp=0, blad;
        Okno ekran = new Okno();
        Scanner klawiatura = new Scanner(System.in);
        while (odp>4 || odp<1) {
            blad=0;
            ekran.ramka(-1, "Wybierz instrument strunowy:");
            ekran.ramka(0, "1. Smyczkowy");
            ekran.ramka(0, "2. Szarpany ");
            ekran.ramka(0, "3. Uderzany ");
            ekran.ramka(3, "4. Powrot   ");
            try{
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad=1;
            }
            if ((odp>4 || odp <1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
        }
        //********************************
        // SMYCZKOWY
        if (odp == 1){
            odp=0;
            // TYP SMYCZKA
            while (odp>3 || odp<1){
                blad=0;
                ekran.ramka(-1, "Podaj typ smyczka:");
                ekran.ramka(0, "1. Konskie wlosie    ");
                ekran.ramka(0, "2. Syntetyczne wlosie");
                ekran.ramka(3, "3. Powrot            ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>3 || odp<1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            if (odp == 1){ typ_smy = "Konskie wlosie"; }
            else if (odp == 2){ typ_smy = "Syntetyczne wlosie"; }
            else if (odp == 3){ dodaj_strunowy(); }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(0, "np. Skrzypce, Altowka,");
            ekran.ramka(3, "    Wiolonczela, Kontrabas.");
            naz = klawiatura.nextLine();
            // ILOSC STRUN
            while (il_str<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. strun instrumentu:");
                try{
                    il_str = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_str<=0 || blad==1) ekran.tekst("Niepoprawna ilosc strun, popraw!");
            }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Smyczkowy tmp = new Smyczkowy(wag, cen, il_szt, mat, naz, il_str, typ_smy);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        //*************************************
        // SZARPANY
        else if (odp == 2){
            odp=0;
            // WZBUDZANIE DRGAN
            while (odp>4 || odp<1){
                blad=0;
                ekran.ramka(-1, "Napisz czym wzbudzasz drgania:");
                ekran.ramka(0, "1. Gole rece      ");
                ekran.ramka(0, "2. Uzbrojone rece ");
                ekran.ramka(0, "3. Drewniane pioro");
                ekran.ramka(3, "4. Powrot         ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>4 || odp<1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            if (odp == 1){ wz_drg = "Gole rece"; }
            else if (odp == 2){ wz_drg = "Uzbrojone rece"; }
            else if (odp == 3){ wz_drg = "Drewniane pioro"; }
            else if (odp == 4){ dodaj_strunowy(); }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(0, "np. Balalajka, Bandzola, Banjo,");
            ekran.ramka(0, "    Gitara, Harfa, Kobza, Lira,");
            ekran.ramka(3, "    Lutnia, Mandolina, Ukulele.");
            naz = klawiatura.nextLine();
            // ILOSC STRUN
            while (il_str<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. strun instrumentu:");
                try{
                    il_str = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_str<=0 || blad==1) ekran.tekst("Niepoprawna ilosc strun, popraw!");
            }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Szarpane tmp = new Szarpane(wag, cen, il_szt, mat, naz, il_str, wz_drg);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        //**********************************************
        // UDERZANY
        else if (odp == 3){
            odp=0;
            // UDERZASZ
            while (odp>4 || odp<1){
                blad=0;
                ekran.ramka(-1, "Czym uderzasz w struny:");
                ekran.ramka(0, "1. Recznie    ");
                ekran.ramka(0, "2. Tangentem  ");
                ekran.ramka(0, "3. Mloteczkiem");
                ekran.ramka(3, "4. Powrot     ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>4 || odp<1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            if (odp == 1){ uderz = "Recznie"; }
            else if (odp == 2){ uderz = "Tangentem"; }
            else if (odp == 3){ uderz = "Mloteczkiem"; }
            else if (odp == 4){ dodaj_strunowy(); }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try {
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try {
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try {
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(0, "np. Cymbaly, Klawikord,");
            ekran.ramka(3, "    Fortepian, Pianino.");
            naz = klawiatura.nextLine();
            // ILOSC STRUN
            while (il_str<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. strun instrumentu:");
                try {
                    il_str = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_str<=0 || blad==1) ekran.tekst("Niepoprawna ilosc strun, popraw!");
            }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try {
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Uderzane tmp = new Uderzane(wag, cen, il_szt, mat, naz, il_str, uderz);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        // POWROT
        else if (odp == 4){ dodaj_instrument(); }
    }

    private void dodaj_dety(){
        String typ_wib="", mat, naz, typ_ust="";
        double wag=-1, cen=-1, dl_rury=-1, sr_rozt=-1;
        int il_szt=-1, il_otw=-1, il_klaw=-1, odp=0,blad;
        Okno ekran = new Okno();
        Scanner klawiatura = new Scanner(System.in);
        while (odp>4 || odp<1){
            blad=0;
            ekran.ramka(-1, "Wybierz instrument dety:");
            ekran.ramka(0, "1. Drewniany ");
            ekran.ramka(0, "2. Blaszany  ");
            ekran.ramka(0, "3. Klawiszowy");
            ekran.ramka(3, "4. Powrot    ");
            try {
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad=1;
            }
            if ((odp>4 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!");}
        }
        //*******************************************
        // DREWNIANY
        if (odp == 1){
            odp=0;
            while (odp>4 || odp<1){
                blad=0;
                ekran.ramka(-1, "Podaj typ wibratora:");
                ekran.ramka(0, "1. Pojedynczy stroik   ");
                ekran.ramka(0, "2. Podwojny stroik     ");
                ekran.ramka(0, "3. Wibrator krawedziowy");
                ekran.ramka(3, "4. Powrot              ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>4 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
            }
            if (odp == 1){ typ_wib = "Pojedynczy stroik"; }
            else if (odp == 2){ typ_wib = "Podwojny stroik"; }
            else if (odp == 3){ typ_wib = "Wibrator krawedziowy"; }
            else if (odp == 4){ dodaj_dety(); }
            // ILOSC OTWOROW
            while (il_otw<=0){
                blad=0;
                ekran.ramka(4, "Podaj ilosc otworow:");
                try{
                    il_otw = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_otw<=0 || blad==1) { ekran.tekst("Niepoprawna ilosc otworow, popraw!"); }
            }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(0, "np. Flet, Klarnet, Saksofon,");
            ekran.ramka(3, "    Oboj, Fagot.");
            naz = klawiatura.nextLine();
            // DLUGOSC RURY
            while (dl_rury<=0){
                blad=0;
                ekran.ramka(4, "Podaj dl. rury instrumentu:");
                try{
                    dl_rury = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (dl_rury<=0 || blad==1) ekran.tekst("Niepoprawna dlugosc rury, popraw!");
            }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Drewniane tmp = new Drewniane(wag, cen, il_szt, mat, naz, dl_rury, typ_wib, il_otw);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        //*******************************************************
        // BLASZANY
        else if (odp == 2){
            odp=0;
            while (odp>3 || odp<1){
                blad=0;
                ekran.ramka(-1, "Podaj typ ustnika:");
                ekran.ramka(0, "1. Lejkowaty   ");
                ekran.ramka(0, "2. Kociolkowaty");
                ekran.ramka(3, "3. Powrot      ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>3 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
            }
            if (odp == 1){ typ_ust = "Lejkowaty"; }
            else if (odp == 2){ typ_ust = "Kociolkowaty"; }
            else if (odp == 3){ dodaj_dety(); }
            // SREDNICA ROZTRABU
            while (sr_rozt<=0){
                blad=0;
                ekran.ramka(4, "Podaj srednice roztrabu: [cm] ");
                try{
                    sr_rozt = Double.parseDouble((klawiatura.nextLine()));
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (sr_rozt<=0 || blad==1) { ekran.tekst("Niepoprawna srednica roztrabu, popraw!"); }
            }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(3, "np. Trabka, Puzon, Tuba, Rog.");
            naz = klawiatura.nextLine();
            // DLUGOSC RURY
            while (dl_rury<=0){
                blad=0;
                ekran.ramka(4, "Podaj dl. rury instrumentu:");
                try{
                    dl_rury = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (dl_rury<=0 || blad==1) ekran.tekst("Niepoprawna dlugosc rury, popraw!");
            }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Blaszane tmp = new Blaszane(wag, cen, il_szt, mat, naz, dl_rury, typ_ust, sr_rozt);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        //*******************************************************
        // KLAWISZOWY
        else if (odp == 3){
            odp=0;
            while (odp>2 || odp<1){
                blad=0;
                ekran.ramka(-1, "Chcesz podac teraz parametry:");
                ekran.ramka(0, "1. Tak (Dalej) ");
                ekran.ramka(3, "2. Nie (Powrot)");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>2 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
            }
            if (odp == 2){ dodaj_dety(); }
            // ILOSC KLAWISZY
            while (il_klaw<=0){
                blad=0;
                ekran.ramka(4, "Podaj ilosc klawiszy:");
                try{
                    il_klaw= Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_klaw<=0 || blad==1) { ekran.tekst("Niepoprawna ilosc klawiszy, popraw!"); }
            }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(3, "np. Organy, Akordeon, Fisharmonia.");
            naz = klawiatura.nextLine();
            // DLUGOSC RURY
            while (dl_rury<=0){
                blad=0;
                ekran.ramka(4, "Podaj dl. rury instrumentu:");
                try{
                    dl_rury = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (dl_rury<=0 || blad==1) ekran.tekst("Niepoprawna dlugosc rury, popraw!");
            }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Klawiszowe tmp = new Klawiszowe(wag, cen, il_szt, mat, naz, dl_rury, il_klaw);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        // POWROT
        else if (odp == 4){ dodaj_instrument(); }
    }

    private void dodaj_perkusyjny(){
        String ksz_wib="", mat, naz, pal="", wl_aku="";
        double wag=-1, cen=-1, sr_memb=-1;
        int il_szt=-1, odp=0,blad;
        Okno ekran = new Okno();
        Scanner klawiatura = new Scanner(System.in);
        while (odp>3 || odp<1){
            blad=0;
            ekran.ramka(-1, "Wybierz instrument perkusyjny:");
            ekran.ramka(0, "1. Samobrzmiacy");
            ekran.ramka(0, "2. Membranowy  ");
            ekran.ramka(3, "3. Powrot      ");
            try {
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad=1;
            }
            if ((odp>3 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
        }
        //***********************************************
        // SAMOBRZMIACE
        if (odp == 1){
            odp=0;
            while (odp>5 || odp<1){
                blad=0;
                ekran.ramka(-1, "Podaj ksztalt wibratora:");
                ekran.ramka(0, "1. Plytowy  ");
                ekran.ramka(0, "2. Sztabkowy");
                ekran.ramka(0, "3. Rurowy   ");
                ekran.ramka(0, "4. Pretowy  ");
                ekran.ramka(3, "5. Powrot   ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>5 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
            }
            if (odp == 1){ ksz_wib = "Plytkowy"; }
            else if (odp == 2){ ksz_wib = "Sztabkowy"; }
            else if (odp == 3){ ksz_wib = "Rurowy"; }
            else if (odp == 4){ ksz_wib = "Pretowy"; }
            else if (odp == 5){ dodaj_perkusyjny(); }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(0, "np. Talerze, Gong, Czelesta,");
            ekran.ramka(3, "Ksylofon, Dzwony rurowe, trojkat.");
            naz = klawiatura.nextLine();
            // PALECZKI
            odp=0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy sa dolaczone paleczki?");
                ekran.ramka(0, "1. Tak");
                ekran.ramka(3, "2. Nie");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            if (odp == 1) { pal = "Tak"; }
            else if (odp == 2){ pal = "Nie"; }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Samobrzmiace tmp = new Samobrzmiace(wag, cen, il_szt, mat, naz, pal, ksz_wib);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        //******************************************************
        // MEMBRANOWE
        else if (odp == 2){
            odp=0;
            while (odp>3 || odp<1){
                blad=0;
                ekran.ramka(-1, "Podaj wlasciwosc akustyczna:");
                ekran.ramka(0, "1. Nieokreslona wysokosc dzwieku");
                ekran.ramka(0, "2. Okreslona wysokosc dzwieku   ");
                ekran.ramka(3, "3. Powrot                       ");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp>3 || odp<1) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
            }
            if (odp == 1){ wl_aku = "Nieokreslona wysokosc dzwieku"; }
            else if (odp == 2){ wl_aku = "Okreslona wysokosc dzwieku"; }
            else if (odp == 3){ dodaj_perkusyjny(); }
            // SREDNICA MEMBRANY
            while (sr_memb<=0){
                blad=0;
                ekran.ramka(4, "Podaj srednice membrany: [cm]");
                try {
                    sr_memb = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (sr_memb<=0 || blad==1) { ekran.tekst("Niepoprawna srednica membrany, popraw!"); }
            }
            // WAGA
            while (wag<=0){
                blad=0;
                ekran.ramka(4, "Podaj wage instrumentu: [kg]");
                try{
                    wag = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (wag<=0 || blad==1) ekran.tekst("Niepoprawna waga, popraw!");
            }
            // CENA
            while (cen<=0){
                blad=0;
                ekran.ramka(4, "Podaj cene instrumentu: [pln]");
                try{
                    cen = Double.parseDouble(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (cen<=0 || blad==1) ekran.tekst("Niepoprawna cena, popraw!");
            }
            // ILOSC SZTUK
            while (il_szt<=0){
                blad=0;
                ekran.ramka(4, "Podaj il. sztuk instrumentu:");
                try{
                    il_szt = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if (il_szt<=0 || blad==1) ekran.tekst("Niepoprawna ilosc sztuk, popraw!");
            }
            // MATERIAL
            ekran.ramka(-1, "Podaj material instrumentu:");
            ekran.ramka(3, "np. Drewno, Plastik, Metal.");
            mat = klawiatura.nextLine();
            // NAZWA
            ekran.ramka(-1, "Podaj nazwe instrumentu:");
            ekran.ramka(0, "np. Beben, Tom-tom,");
            ekran.ramka(3, "    Kotly, Rototom.");
            naz = klawiatura.nextLine();
            // PALECZKI
            odp=0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy sa dolaczone paleczki?");
                ekran.ramka(0, "1. Tak");
                ekran.ramka(3, "2. Nie");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            if (odp == 1) { pal = "Tak"; }
            else if (odp == 2){ pal = "Nie"; }
            odp = 0;
            while (odp<1 || odp>2){
                blad=0;
                ekran.ramka(-1, "Czy chcesz zapisac instrument:");
                ekran.ramka(0, "1. TAK");
                ekran.ramka(3, "2. NIE");
                try{
                    odp = Integer.parseInt(klawiatura.nextLine());
                } catch (NumberFormatException n){
                    blad=1;
                }
                if ((odp<1 || odp>2) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            }
            Membranowe tmp = new Membranowe(wag, cen, il_szt, mat, naz, pal, wl_aku, sr_memb);
            if (odp == 1){
                tab.add(tmp);
                ekran.ramka(-1, "Dodales:");
                tmp.get_param();
            }
            else { ekran.ramka(-1, "Anulowales dodawanie !"); }
            ekran.krawedz();
        }
        else if (odp == 3){ dodaj_instrument(); }
    }

    private void wypisz(String a){
        Scanner klawiatura = new Scanner(System.in);
        Okno ekran = new Okno();
        int odp = 0, blad;
        if (a.equals("usun")){
            odp = 4;
        }
        while (odp<1 || odp>5){
            blad=0;
            ekran.ramka(-1, "Jakie instrumenty wypisac?");
            ekran.ramka(0, "1. Strunowe  ");
            ekran.ramka(0, "2. Dete      ");
            ekran.ramka(0, "3. Perkusyjne");
            ekran.ramka(0, "4. Wszystkie ");
            ekran.ramka(3, "5. Powrot    ");
            try{
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad=1;
            }
            if ((odp>5 || odp<1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");}
        int licznik = 1;
        double typ_instr;
        if (odp>0 || odp<5){
            if (tab.isEmpty()) { ekran.ramka(1, "Brak instrumentów"); }
            for (int i =0; i < tab.size(); i++){
                Instrument tmp;
                tmp = tab.get(i);
                typ_instr = tmp.get_typ_instr();
                // Wyswietlenie Strunowego i zwiekszenie licznika
                if(odp == 1 || odp == 4){
                    if (typ_instr == 1.1 || typ_instr == 1.2 || typ_instr == 1.3){
                        ekran.ramka(-1, "# Nr instrumentu: "+licznik);
                        tmp.get_param();
                        licznik++;
                        ekran.krawedz();
                    }
                }
                // Wyswietlenie Detego i zwiekszenie licznika
                if(odp == 2 || odp == 4){
                    if (typ_instr == 2.1 || typ_instr == 2.2 || typ_instr == 2.3){
                        ekran.ramka(-1, "# Nr instrumentu: "+licznik);
                        tmp.get_param();
                        licznik++;
                        ekran.krawedz();
                    }
                }
                // Wyswietlenie Perkusyjnego i zwiekszenie licznika
                if(odp == 3 || odp == 4){
                    if (typ_instr == 3.1 || typ_instr == 3.2){
                        ekran.ramka(-1, "# Nr instrumentu: "+licznik);
                        tmp.get_param();
                        ekran.krawedz();
                        licznik++;
                    }
                }
            }
        }
    }

    private void usun(){
        Scanner klawiatura = new Scanner(System.in);
        Okno ekran = new Okno();
        int odp=-1, blad;
        wypisz("usun");
        while (odp<0 || odp>tab.size()){
            if (tab.isEmpty()) { break; }
            blad=0;
            ekran.ramka(-1, "Podaj nr. usuwanego instrumentu:");
            ekran.ramka(3, " '0' (zero)- zeby wyjsc");
            try{
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad=1;
            }
            if ((odp<0 || odp>(tab.size())) || blad==1) { ekran.tekst("Niepoprawna odpowiedz, popraw!"); }
            tab.remove(odp - 1);
        }

    }

    public void start() throws IOException {
        odczyt();
        powitaj();
        Okno ekran = new Okno();
        int odp=0,blad;

        while (odp>4 || odp<1){
            interfejs();
            blad = 0;
            Scanner klawiatura = new Scanner(System.in);
            try{
                odp = Integer.parseInt(klawiatura.nextLine());
            } catch (NumberFormatException n){
                blad = 1;
            }
            if ((odp>4 || odp<1) || blad==1) ekran.tekst("Niepoprawna odpowiedz, popraw!");
            if (odp == 1){ odp=0; dodaj_instrument(); }     /* 1. Dodaj instrument */
            else if (odp == 2){ odp=0; usun(); }            /* 2. Usun */
            else if (odp == 3){ odp=0; wypisz(""); }        /* 3. Wypisz */
            else if (odp == 4){ zapisz(); break; }          /* 4. Zapisz i Wyjdz */
        }
    }

}

