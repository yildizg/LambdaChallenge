import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.Stream;

/*
dosya eklemek icin 2 yol var
1) Files.lines(Path.of("path")  buradan stream e eklemek icin
Stream <String> satir=Files.lines(Path.of(".........."));
bu bize tekrardan stream tanimlamadan kullanmayi saglar
2) //Files.lines(Paths.get("..........")).  kullanilir
==========================================================
intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
sonrasinda copy path seciyoruz bundan sonra iki secenek var
1) absolute path seciyoruz yada
2) path from content root seciyoruz
her ikisinde de path kopyalamis oluyoruz

cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
*/
public class C7_DosyaOkuma {
    public static void main(String[] args) throws IOException {
        Stream<String> satir = Files.lines(Path.of("src/C7_TextFile"));


        // S1: Yazdiralim

        // satir.forEach(Methods::yazString);
        //1.Terk etmek kolaysa senin icin, 2.El sallamak zor degil benim icin!
        // 3.Sevmek zaman ayirmaktir. 4.Bos zamanlari doldurmak degil... 5.bu son satir da Lambda ya Hoscakal olsun :)


        // S2: tum harfleri buyuk harf ile yazdiralim

        //satir.map(x->x.toUpperCase()).forEach(Methods::yazString);
        //1.TERK ETMEK KOLAYSA SENIN ICIN, 2.EL SALLAMAK ZOR DEGIL BENIM ICIN!
        // 3.SEVMEK ZAMAN AYIRMAKTIR. 4.BOS ZAMANLARI DOLDURMAK DEGIL...
        // 5.BU SON SATIR DA LAMBDA YA HOSCAKAL OLSUN :)

        // S3: son satiri buyuk harfle yazdiralim
        // chatgpt den
        //String sonSatir = satir.reduce((first, second) -> second).orElse("");
        // String buyukHarfliSonSatir = sonSatir.toUpperCase();
        // System.out.println(buyukHarfliSonSatir);
        //5.BU SON SATIR DA LAMBDA YA HOSCAKAL OLSUN :)


        // S4: 2.ve 3. satirlari yazdiralim


        // S5: kac tane "icin" kelimesi vardir

        //todo calis buna
        //                String metin = "Terk etmek kolaysa senin icin, El sallamak zor degil benim icin! Sevmek zaman ayirmaktir. Bos zamanlari doldurmak degil...";
        //
        //                List<String> kelimeler = Arrays.asList(metin.split("\\s+"));
        //                long sayac = kelimeler.stream()
        //                        .filter(kelime -> kelime.equalsIgnoreCase("icin"))
        //                        .count();

        //System.out.println("Metindeki 'icin' kelimesinin sayısı: " + sayac);


        // S6: tum kelimeleri natural order  yazdiriniz.
        //satir.map(y->y.split(" ")).flatMap(Arrays::stream).sorted().forEach(System.out::println);
        // S7: metinde kac tane "a"  vardir
        //  System.out.println("satir.map(y -> y.split(\"\")).flatMap(Arrays::stream).filter(y -> y.contains(\"a\")).count() = " + satir.map(y -> y.split("")).flatMap(Arrays::stream).filter(y -> y.contains("a")).count());
        //satir.map(y -> y.split("")).flatMap(Arrays::stream).filter(y -> y.contains("a")).count() = 20



    }
}