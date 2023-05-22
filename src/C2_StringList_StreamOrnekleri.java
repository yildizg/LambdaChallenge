import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglenceliydi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");

        System.out.println("ilkHarfcd(list) = " + ilkHarfcd(list));//ilkHarfcd(list) = [cok, da]

        bassonyildiz(list);//*Java* *ogrenmek* *cok* *eglenceliydi* *lambda* *gelince* *Daha* *da* *Cok* *Eglenceli* *Oldu*

        sorted(list);
        //list.stream().sorted().collect(Collectors.toList()) = [Cok, Daha, Eglenceli, Java, Oldu, cok, da, eglenceliydi, gelince, lambda, ogrenmek]

        System.out.println("eolanlarlalist(list) = " + eolanlarlalist(list));
        //eolanlarlalist(list) = [ogrenmek, eglenceliydi, gelince, Eglenceli]

        lsil(list);
       //Java ogrenmek cok egenceiydi ambda geince Daha da Cok Egencei Odu

        ilkHarfBuyuk(list);
        //Java Ogrenmek Cok Eglenceliydi Lambda Gelince Daha Da Cok Eglenceli Oldu

        length4ve6haric(list);
        //ogrenmek cok eglenceliydi gelince da Cok Eglenceli

    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static List<String> ilkHarfcd(List<String>list){
        System.out.println();
      return  list.stream().filter(x->x.startsWith("d")|| x.startsWith("c")).collect(Collectors.toList());
    }

    // S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void bassonyildiz(List<String>list){
        System.out.println();
        list.stream().map(x->"*"+x+"*").forEach(x-> System.out.print(x+" "));
    }

    // S3: alfabetik  olarak siralayalim list olarak ***sorted()
    public static void sorted(List<String>list){
        System.out.println();
        System.out.println("list.stream().sorted().collect(Collectors.toList()) = " + list.stream().sorted().collect(Collectors.toList()));
    }

    // S4: tum 'l' leri silelim yazdiralim replaceAll
    public static void lsil(List<String>list){
        System.out.println();
        list.stream().map(y->y.replaceAll("l","")).forEach(Methods::yazString);
    }

    // S5 : icinde e olanlardan yeni bir list olusturunuz  *** filter(contains())  collect()
    public static List<String> eolanlarlalist(List<String>list){
        System.out.println();
        return  list.stream().filter(x->x.contains("e")).collect(Collectors.toList());
    }

    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi**map
    public static void ilkHarfUcTekrar(List<String>list){

       list.stream().map(x->x.substring(0,1)+x.substring(0,1)+x).forEach(x->System.out.print(x));
    }

    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz***substring uppercase und lowercase
    public static void ilkHarfBuyuk(List<String>list){
        System.out.println();

        list.stream().map(x->x.substring(0,1).toUpperCase()+x.substring(1)).forEach(Methods::yazString);
    }

    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz***filter length!= collect 2.yol skip olabilir
    public static void length4ve6haric(List<String>list){
        System.out.println();

       list.stream().filter(x -> x.length() != 4 && x.length() != 6).forEach(Methods::yazString);

    }



}
