import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {


    public static void main(String[] args) {


    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)

        IntStream.range(1, 30)
         .forEach(n -> System.out.print(n + " "));
    //    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29

    //S2:  1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
        System.out.println();
        IntStream.rangeClosed(1, 30)
                .forEach(n -> System.out.print(n + " "));
    //  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30

    //S3 Istenen iki deger(dahil) arasindaki sayilari toplayalim
        System.out.println();
        int toplam =IntStream.rangeClosed(1, 10).sum();
        System.out.println("toplam = " + toplam);//toplam = 55


    //S4: 30 ile 40 arasindaki sayilarin (dahil) ortalamasini bulalim
        System.out.println();
        System.out.println("IntStream.rangeClosed(30,40).average() = " + IntStream.rangeClosed(30, 40).average());
        //OptionalDouble[35.0]

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
        System.out.println();
        System.out.println("IntStream.rangeClosed(325, 468).filter(x->x%8==0).count() = " + IntStream.rangeClosed(325, 468).filter(x -> x % 8 == 0).count());
    //  IntStream.rangeClosed(325, 468).filter(x->x%8==0).count() = 18
        //S6: 325 ile 468 arasinda 8 e bolunen sayilari yazdiralim

    // S7:325 ile 468 arasinda 8 e bolunen sayilarin toplamini bulalim

        System.out.println("IntStream.rangeClosed(325, 468).filter(x -> x % 8 == 0).sum() = " + IntStream.rangeClosed(325, 468).filter(x -> x % 8 == 0).sum());
       // IntStream.rangeClosed(325, 468).filter(x -> x % 8 == 0).sum() = 7128
    // S8: 7 ile 15 (dahil) arasindaki tek sayilarin carpimini bulalim
        System.out.println();

        System.out.println("IntStream.rangeClosed(7, 15).filter(x -> x %2 != 0).reduce(Math::multiplyExact) = " + IntStream.rangeClosed(7, 15).filter(x -> x % 2 != 0).reduce(Math::multiplyExact));
    //IntStream.rangeClosed(7, 15).filter(x -> x %2 != 0).reduce(Math::multiplyExact) = OptionalInt[135135]

    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
        System.out.println();
    IntStream.rangeClosed(1,10).filter(x->x%2!=0).forEach(Methods::yazInteger);//1 3 5 7 9


    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yazdiralim
        System.out.println();
        IntStream.rangeClosed(21,100).filter(x->x%7==0).limit(10).forEach(Methods::yazInteger);//21 28 35 42 49 56 63 70 77 84
        //todo iterate ile
    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
        System.out.println();
       // System.out.println("IntStream.iterate(21,7).limit(20).reduce(21,(a,b)->a+b) = " + IntStream.iterate(21,7).limit(20).reduce(21, (a, b) -> a + b));
        IntStream.rangeClosed(21,200).filter(x->x%7==0).limit(20).forEach(Methods::yazInteger);
        System.out.println();
        //21 28 35 42 49 56 63 70 77 84 91 98 105 112 119 126 133 140 147 154
        System.out.println("IntStream.rangeClosed(21,200).filter(x->x%7==0).limit(20).reduce(Math::addExact) = " + IntStream.rangeClosed(21, 200).filter(x -> x % 7 == 0).limit(20).reduce(Math::addExact));
        System.out.println();
        System.out.println("IntStream.rangeClosed(21,200).filter(x->x%7==0).limit(20).reduce(Integer::sum) = " + IntStream.rangeClosed(21, 200).filter(x -> x % 7 == 0).limit(20).reduce(Integer::sum));

    }
}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belirliyoruz