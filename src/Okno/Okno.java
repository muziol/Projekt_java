package Okno;

/**
 * Created by rafal on 02.06.2016.
 */
public class Okno {
    private String s = "                                        ";
    private String l = "###################################";

    public void ramka(int w, String a){
        String b = s;
        if (w == -1 || w == 1 || w==4)
            System.out.print(s + l + "\n");
        b += "#";
        for (int i=0; i < ((33-a.length())/2); i++ ){
            b += " ";
        }
        b += a;
        for (int i=0; i < ((33-a.length())/2); i++){
            b += " ";
        }
        if (a.length() % 2 == 0) b += " ";
        b += "#";
        System.out.print(b + "\n");
        if (w == 1 || w == 2 || w == 3 || w == 4)
            System.out.print(s + l + "\n");

        if (w == 3 || w == 4 )
            System.out.print(s + "->");

    }

    public void krawedz(){
        System.out.print(s + l + "\n");
    }

    public void tekst(String a){
        System.out.print(s + a + "\n");
    }
}
