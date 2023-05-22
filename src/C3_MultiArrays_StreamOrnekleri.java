//multi arrayleri cevirirken flatMap kullaniriz yapilis sekli iki turludur
//1) lambda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc", "Erik"}
        };
        System.out.println("listele(arr) = " + listele(arr));
        //listele(arr) = [Elma, Muz, Portakal, Cilek, Limon, Havuc, Erik]
        listele2(arr);//ElmaElma ErikErik
        System.out.println(listele3(arr));//[ElmaElma, ErikErik]
        kilebitenliste(arr);//Cilek* Erik*
    }

    // S1 : tum elemanlari list yapalim
    public static List<String>listele(String[][]arr){
        return Arrays.stream(arr).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void listele2(String[][]arr){
         Arrays.stream(arr).flatMap(Arrays::stream).filter(x->x.startsWith("E")).map(x-> x+x).forEach(x->System.out.print(x+ " "));
    }

    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String> listele3(String[][]arr){
        //todo void li yap
     return Arrays.stream(arr).flatMap(Arrays::stream).filter(x -> x.startsWith("E")).map(x -> x + x).collect(Collectors.toList());
    }


    //S4 : k ile bitenlerin sonuna '*' ekleyelim   ***endsWith("k")

    public static void kilebitenliste(String[][]arr){
        System.out.println();
        Arrays.stream(arr).flatMap(x->Arrays.stream(x)).filter(x->x.endsWith("k")).map(x-> x +"*").forEach(x->System.out.print(x+ " "));
    }



}
