import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Main {
    static final int MAXN = 500005;
    public static int num = 0;
    static void KurierzyMan(){
        Scanner sc = new Scanner(System.in);
        int[] t = new int[MAXN];
            int n, m;
        try{
            System.out.print("Podaj długość ciągu: ");
            n = sc.nextInt();
            System.out.print("Podaj ilość zapytań: ");
            m = sc.nextInt();
        for(int i = 0; i< n; i++ ){
            System.out.print("t["+ i +"] = ");
            t[i]=sc.nextInt();
        }
        for(int i = 0; i < m; i++) {
            int a, b;
            System.out.print("Przeszukiwanie ciągu od pozycji: ");
            a = sc.nextInt() - 1;
            System.out.print("Do pozycji: ");
            b = sc.nextInt() - 1;

            int leader = -1, leaderCount = 0;
            for (int j = a; j <= b; j++) {
                if (leaderCount == 0) {
                    leader = t[j];
                    leaderCount = 1;
                } else {
                    if (leader == t[j])
                        leaderCount++;
                    else
                        leaderCount--;
                }
            }
            int realCount = 0;
            for (int j = a; j <= b; j++)
                if (t[j] == leader)
                    realCount++;

            if (realCount > (b - a + 1) / 2)
                System.out.println("Liderem jest: " + leader);
            else
                System.out.println("Liderem jest: " + 0 + " ---Brak lidera");
        }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Błędne dane wejściowe!");
        }
    }
    static void KurierzyFile(File plik){
        num++;
        File f = new File(plik.getName());
        System.out.println("Dane wczytane z: " +plik.getAbsolutePath());
        try {
            File del = new File("Wyjscie"+num+".txt");
            del.delete();
                File Out = new File("Wyjscie"+num+".txt");
                if (Out.createNewFile()) {
                    System.out.println("Dane zapisane w: " + Out.getAbsolutePath());
                    FileWriter myWriter = new FileWriter((String)Out.getName());
                    Scanner s = new Scanner(f);
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    while (s.hasNext()) {
                        l.add(s.nextInt());
                    }
                    int n = l.get(0);
                    int m = l.get(1);
                    //System.out.println("Długość ciągu: " + n);
                    myWriter.write("Długość ciągu: " + n+"\n");
                    //System.out.println("Liczba zapytań: " + m);
                    myWriter.write("Liczba zapytań: " + m+"\n");
                    ArrayList<Integer> ciag = new ArrayList<Integer>(l.subList(2, n + 2));
                    //System.out.println("Ciąg:" + ciag);
                    myWriter.write("Ciąg:" + ciag+"\n");
                    for (int i = 0; i < m * 2; i += 2) {
                        int a = l.get(2 + n + i) - 1;
                        int b = l.get(3 + n + i) - 1;
                        //System.out.print("Dla przedziału od: " + (a + 1) + " ,do: " + (b + 1) + "\n");
                        myWriter.write("Dla przedziału od: " + (a + 1) + " ,do: " + (b + 1) + "\n");
                        int leader = -1, leaderCount = 0;
                        for (int j = a; j <= b; j++) {
                            if (leaderCount == 0) {
                                leader = ciag.get(j);
                                leaderCount = 1;
                            } else {
                                if (leader == ciag.get(j))
                                    leaderCount++;
                                else
                                    leaderCount--;
                            }
                        }
                        int realCount = 0;
                        for (int j = a; j <= b; j++)
                            if (ciag.get(j) == leader)
                                realCount++;

                        if (realCount > (b - a + 1) / 2) {
                            //System.out.println("Liderem jest: " + leader);
                            myWriter.write("Liderem jest: " + leader+"\n");
                        } else {
                            //System.out.println("Liderem jest: " + 0 + " ---Brak lidera");
                            myWriter.write("Liderem jest: " + 0 + " ---Brak lidera"+"\n");
                        }
                    }
                    myWriter.close();
                }else{
                    System.out.println("Plik już istnieje");
                }
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error obsługi pliku");
            }catch (Exception e){
            e.printStackTrace();
            System.out.println("Błąd Programu");
            }
        }
    public static void main(String[] args)
    {
        Locale locale = new Locale("pl","PL");
        int s;
        while(true){
            System.out.println("==========");
            System.out.println(" Kurierzy ");
            System.out.println("==========");
            System.out.println("1. Konsola");
            System.out.println("2. Test plików");
            System.out.println("3. Wyjście");
            System.out.println("==========");
            Scanner menu = new Scanner(System.in);
            System.out.print("Wybierz opcję: ");
            try {
                s = menu.nextInt();
                System.out.println("==========");
                switch (s) {
                    case 1:
                        KurierzyMan();
                        break;
                    case 2:
                        File plik1 = new File("dane1.txt");
                        KurierzyFile(plik1);
                        File plik2 = new File("dane2.txt");
                        KurierzyFile(plik2);
                        File plik3 = new File("dane3.txt");
                        KurierzyFile(plik3);
                        File plik4 = new File("dane4.txt");
                        KurierzyFile(plik4);
                        File plik5 = new File("dane5.txt");
                        KurierzyFile(plik5);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("=====================");
                        System.out.println(" Nie ma takiej opcji ");
                        System.out.println("=====================");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Podaj liczbę");
            continue;}
        }
    }
}