import java.util.*;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));
        yaz(list);//-5 -8 -2 -12 0 1 12 5 6 9 15 8
        negatifleriyaz(list);//-5 -8 -2 -12
        System.out.println("pozitifList(list) = " + pozitifList(list));//pozitifList(list) = [1, 12, 5, 6, 9, 15, 8]
        System.out.println("kareList(list) = " + kareList(list));//kareList(list) = [25, 64, 4, 144, 0, 1, 144, 25, 36, 81, 225, 64]
        System.out.println("tekrarsizkareList(list) = " + tekrarsizkareList(list));
        ktenbygeyaz(list);//-12 -8 -5 -2 0 1 5 6 8 9 12 15
        System.out.println("sirala(list) = " + sirala(list));//sirala(list) = [-12, -8, -5, -2, 0, 1, 5, 6, 8, 9, 12, 15]
        byktenkcgeeyaz(list);//15 12 9 8 6 5 1 0 -2 -5 -8 -12
        System.out.println("pozitifkupList(list) = " + pozitifkupList(list));// pozitifkupList(list) = [125, 3375]
        System.out.println("pozitifkareList(list) = " + pozitifkareList(list));//pozitifkareList(list) = [1, 144, 36, 81, 64]
        System.out.println("toplam(list) = " + toplam(list));//toplam(list) = Optional[29]
        System.out.println(" negatifkareList(list) = " + negatifkareList(list));
        //negatifler: -5 kareler: 25 negatifler: -8 kareler: 64 negatifler: -2 kareler: 4 negatifler: -12 kareler: 144 negatifkareList(list) = [25, 64, 4, 144]
        System.out.println("sifiraEsitYokMu(list) = " + sifiraEsitYokMu(list));
        ilkBesToplam(list);
        System.out.println("ilkBesToplam2(list) = " + ilkBesToplam2(list));
        System.out.println("sonBes(list) = " + sonBes(list));

    }   // S1:listi aralarinda bosluk birakarak yazdiriniz
        public static void yaz(List<Integer>list){
        list.stream().forEach(y-> System.out.print(y+" "));
        }
        // S2: sadece negatif olanlari yazdir
        public static void negatifleriyaz(List<Integer>list){
        System.out.println();
        list.stream().filter(y->y<0).forEach(y-> System.out.print(y+" "));
        }
        // S3: pozitif olanlardan yeni bir liste olustur
        public static List<Integer> pozitifList(List<Integer>list){
        return list.stream().filter(y->y>0).collect(Collectors.toList());

        }
    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
        public static List<Integer> kareList(List<Integer>list) {
        return list.stream().map(y ->y*y).collect(Collectors.toList());//kareList(list) = [25, 64, 4, 144, 0, 1, 144, 25, 36, 81, 225, 64]
            //return list.stream().map(y ->(int)Math.pow(y,2)).collect(Collectors.toList());
        }

    // S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
        public static List<Integer> tekrarsizkareList(List<Integer>list) {
        return list.stream().map(y ->y*y).distinct().collect(Collectors.toList());//tekrarsizkareList(list) = [25, 64, 4, 144, 0, 1, 36, 81, 225]
        //return list.stream().map(y ->(int)Math.pow(y,2)).distinct().collect(Collectors.toList());
    }

    // S6: listin elemanlarini kucukten buyuge siralayalim
    public static void ktenbygeyaz(List<Integer>list){
        System.out.println();
        list.stream().sorted().forEach(y-> System.out.print(y+" "));
    }
    public static List<Integer> sirala(List<Integer> liste) {
        return liste.stream().sorted().collect(Collectors.toList());

    }

    // S7: listin elemanlarini buyukten kucuge siralayalim
    public static void byktenkcgeeyaz(List<Integer>list){
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(y-> System.out.print(y+" "));
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer>pozitifkupList(List<Integer>list) {
        System.out.println();
        return list.stream().filter(y->y>0).map(y -> (int)Math.pow(y,3)).filter(y->y%10==5).collect(Collectors.toList());
    }
    // S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer>pozitifkareList(List<Integer>list) {
        System.out.println();
        return list.stream().filter(y->y>0).map(y -> (int)Math.pow(y,2)).filter(y->y%10!=5).collect(Collectors.toList());
    }
    // S10 :list elemanlarini toplamini bulalim
    public static Optional<Integer> toplam(List<Integer>list){
        System.out.println();
     // return  list.stream().reduce(0, (a, b) -> a + b);//burda return type int olmali todo yeni method yap
      return list.stream().reduce(Integer::sum);
      //return list.stream().mapToInt(t->t).sum();todo yeni method yap

    }

        // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
        public static List<Integer>negatifkareList(List<Integer>list) {
            System.out.println();
            return list.stream().filter(y->y<0).peek(y-> System.out.print(" negatifler: "+ y)).
                    map(y -> (int)Math.pow(y,2)).peek(y-> System.out.print(" kareler: "+y)).
                    collect(Collectors.toList());
        }


    /*
     peek () 'in Javadoc sayfası şöyle diyor: " Bu yöntem, temelde, öğeleri bir
    ardışık düzen içinde belirli bir noktadan geçerken görmek istediğiniz
    yerde hata ayıklamayı desteklemek için vardır . Ara islemdir.. yapilam islemi gormek icin kullanilir

     */
    public static boolean sifirdanKucukMu(List<Integer> liste) {
        return liste.stream().allMatch(t->t<0); //false
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsitYokMu(List<Integer> liste) {
        return liste.stream().noneMatch(t->t==100); //true
    }

    // S15: listenin sifira esit elemani yok mu?
    public static boolean sifiraEsitYokMu(List<Integer> liste) {
        return liste.stream().noneMatch(t->t==0); //false
    }
    // S16:  listenin ilk 5 elemanini topla?

    public static void ilkBesToplam(List<Integer> liste) {
        System.out.println(liste.stream().limit(5).reduce(Integer::sum));
    }

    public static int ilkBesToplam2(List<Integer> liste) {
        return liste.stream().limit(5).reduce(0,(x,y)->x+y);
    }
    // S17: listenin son bes elemaninin  listele
    public static List<Integer> sonBes(List<Integer> liste) {
        long n = liste.size()-5;
        return liste.stream().skip(n).collect(Collectors.toList());
    }


}
