import com.sun.jdi.BooleanValue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");


    }

    // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
    public static void buyukYaz(List<String> list ){
      list.stream().map(String::toUpperCase).forEach(Methods::yazString);
    }

    //S2: Stringleri uzunluklarina gore siralayip yaziniz
    public static void sirala(List<String> list ){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(Methods::yazString);
    }

    //S3: E ILE Baslayanlari yazdiralim
    public static void Eilebaslayan(List<String> list ){
        System.out.println("list.stream().map(Methods::EbasliyorMu) = " + list.stream().map(Methods::EbasliyorMu));
    }



}
