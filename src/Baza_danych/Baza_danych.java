package Baza_danych;

import Dete.Dete;
import Okno.Okno;
import Perkusyjny.Perkusyjny;
import Strunowy.Strunowy;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by rafal on 02.06.2016.
 */
public class Baza_danych {
    private Vector<Strunowy> tabS = new Vector<Strunowy>();
    private Vector<Dete> tabD = new Vector<Dete>();
    private Vector<Perkusyjny> tabP = new Vector<Perkusyjny>();

    private void odczyt(){}

    private void zapisz(){}

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
        int odp = 0; String wczyt = "";
        while (odp>4 || odp<1){
            ekran.ramka(-1, "Wybierz rodzaj instrumentu:");
            ekran.ramka(0, "1. Strunowy  ");
            ekran.ramka(0, "2. Dety      ");
            ekran.ramka(0, "3. Perkusyjny");
            ekran.ramka(3, "4. Powrot    ");
        }
    }

    private void dodaj_strunowy(){}

    private void dodaj_dety(){}

    private void dodaj_perkusyjny(){}

    private void wypisz(String a){
        Okno ekran = new Okno();
        int odp = 0;
        String wczyt = "";
        while (odp<1 || odp>4){
            ekran.ramka(-1, "Jakie instrumenty "+a+"?");
            ekran.ramka(0, "1. Strunowe  ");
            ekran.ramka(0, "2. Dete      ");
            ekran.ramka(0, "3. Perkusyjne");
            ekran.ramka(3, "4. Powrot    ");
            Scanner klawiatura = new Scanner(System.in);
            wczyt = klawiatura.nextLine();
            odp = Integer.parseInt(wczyt);
            if (odp > 4 || odp < 1) ekran.tekst("Podales zla liczbe, popraw!");}
/*1. wypisz_strunowe*/
        if (odp == 1){
            int sizS = tabS.size();
            for (int i =0; i < sizS; i++){
                Strunowy tmp = new Strunowy();
                tmp = tabS[i];
                int n = i+1;
                String nr = toString(n);
                ekran.ramka(-1, "# Nr instrumentu: "+nr);
                tmp.get_param();
                ekran.krawedz();
            }}/*****WYPISZ_STRUNOWE***********************/
 /*2. wypisz_dete*/
        else if (odp == 2){
            int sizD = tabD.size();
            for (int i =0; i < sizD; i++){
                Dete tmp=new Dete();
                tmp = tabD[i];
                int n = i+1;
                String nr = toString(n);
                ekran.ramka(-1, "Nr instrumentu: "+nr);
                tmp.get_param();
                ekran.krawedz();
            }}/******WYPISZ_DETE***************************/
 /*3. wypisz_perkusyjne*/
        else if (odp == 3){
            int sizP = tabP.size();
            for (int i =0; i < sizP; i++){
                Perkusyjny tmp=new Perkusyjny();
                tmp = tabP[i];
                int n = i+1;
                String nr = toString(n);
                ekran.ramka(-1, "Nr instrumentu: "+nr);
                tmp.get_param();
                ekran.krawedz();
            }}/******WYPISZ_PERKUSYJNE********************/
/*4. Powrot*/else if (odp == 4){ }
        return odp;
    }

    private void usun(){
        Okno ekran = new Okno();
        int odp=0;
        int arg=0;
        int usun=1;
        String wczyt= "";
        arg = wypisz("usunac ");
        /* tabS */
        if (arg == 1){
            int rozmiar = tabS.size();
            while (odp<1 || odp>rozmiar){
                if (tabS.size() == 0){
                    ekran.ramka(1, "Brak danych");
                    usun = 0;
                    break;
                }
                ekran.ramka(4, "Podaj nr. usuwanego instrumentu:");
                getline(cin, wczyt);
                odp = atoi(wczyt.c_str());
                if (odp<1 || odp>rozmiar) ekran.tekst("Zla odpowiedz, popraw! ");}
            if (usun == 1) tabS.erase(tabS.begin() + odp - 1);
        }/******************TAB_S*************************************/
/* tabD */else if (arg == 2){
            int rozmiar = tabD.size();
            while (odp<1 || odp>rozmiar){
                if (tabD.size() == 0){
                    ekran.ramka(1, "Brak danych");
                    usun = 0;
                    break;
                }
                ekran.ramka(4, "Podaj nr. usuwanego instrumentu:");
                getline(cin, wczyt);
                odp = atoi(wczyt.c_str());
                if (odp<1 || odp>rozmiar) ekran.tekst("Zla odpowiedz, popraw! ");}
            if (usun == 1) tabD.erase(tabD.begin() + odp - 1);
        }/*****************TAB_D**************************************/
/* tabP */else if (arg == 3) {
            int rozmiar = tabP.size();
            while (odp<1 || odp>rozmiar){
                if (tabP.size() == 0){
                    ekran.ramka(1, "Brak danych");
                    usun = 0;
                    break;
                }
                ekran.ramka(4, "Podaj nr. usuwanego instrumentu:");
                getline(cin, wczyt);
                odp = atoi(wczyt.c_str());
                if (odp<1 || odp>rozmiar) ekran.tekst("Zla odpowiedz, popraw! ");}
            if (usun == 1) tabP.erase(tabP.begin() + odp - 1);
        }/*****************TAB_P**************************************/
    }

    public void start(){
        odczyt();
        powitaj();
        Okno ekran = new Okno();
        int odp=0; String wczyt = "";

        while (odp>4 || odp<1){
            interfejs();
            Scanner klawiatura = new Scanner(System.in);
            wczyt = klawiatura.nextLine();
            odp = Integer.parseInt(wczyt);
            if (odp > 4 || odp < 1) ekran.tekst("Podales niepoprawna liczbe, popraw!");
            if (odp == 1){ odp=0; dodaj_instrument(); }     /* 1. Dodaj instrument */
            else if (odp == 2){ odp=0; usun(); }            /* 2. Usun */
            else if (odp == 3){ odp=0; wypisz("wypisac"); } /* 3. Wypisz */
            else if (odp == 4){ zapisz(); break; }          /* 4. Zapisz i Wyjdz */
        }
    }

}


