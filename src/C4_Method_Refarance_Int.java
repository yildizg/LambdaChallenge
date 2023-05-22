// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL = Arrays.asList(-2, -8, -5, 0, 2, 5, 6, 7, 15, 6, 8);
    tekBosluk(intL);//-5 5 7 15 0
        System.out.println("ciftcarpim(intL) = " + ciftcarpim(intL));
        //ciftcarpim(intL) = Optional[0]
        System.out.println("negatifKare(intL) = " + negatifKare(intL));
        System.out.println("kupmax(intL) = " + kupmax(intL));

    }



    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekBosluk( List<Integer> list ){
        list.stream().filter(Methods::tekMi).forEach(Methods::yazInteger);

    }

    // S2: ciftlerin carpimini bulalim
    public static Optional<Integer> ciftcarpim(List<Integer> list ){
       return list.stream().filter(Methods::ciftMi).reduce(Math::multiplyExact);

    }


    // S3: negatiflerin kare toplamlarini  bulalim
    public static Optional<Integer> negatifKare(List<Integer> list ){
      return  list.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(Integer::sum);

    }

    // S4: poziflerin kuplerinden max olani yazdiralim

    public static Optional<Integer> kupmax(List<Integer> list ){
        return  list.stream().filter(Methods::pozitifMi).map(Methods::kupBul).reduce(Integer::max);

    }


}
