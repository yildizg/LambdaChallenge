import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3_Array_StreamOrnekleri {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
            // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
            // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1 [] ={1,5,-5,6,12,-8,9,3,4};
        System.out.println("arrlistele(arr1) = " + arrlistele(arr1));
        System.out.println("toplam(arr1) = " + toplam(arr1));//toplam(arr1) = 27
        System.out.println("toplam2(arr1) = " + toplam2(arr1));//toplam2(arr1) = 27
        int arr2 [] ={1,5,-5,6,12,-8,9,3,4};
        System.out.println("ortalama(arr2) = " + ortalama(arr2));//ortalama(arr2) = OptionalDouble[3.0]


    }
    //S1: arrayin elemanlarini bir liste yazdiralim
    public static  List<Integer>arrlistele(Integer arr[]){
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    //S2: Arrayin elemanlarini toplamini bulalim
    public static  int toplam(Integer[] arr){
     Stream<Integer>arryeni=Stream.of(arr);
     return arryeni.reduce(0,(x,y)->x+y);

    }
    public static  int toplam2(Integer[] arr){
     Stream<Integer>arryeni=Stream.of(arr);
     return arryeni.reduce(0, Integer::sum);

    }

    // S3: Array in elemanlarinin ortalamasini bulalim yazdir
    public static OptionalDouble ortalama(int[] arr){

        return Arrays.stream(arr).average();

    }



}
