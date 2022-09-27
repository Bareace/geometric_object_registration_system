package arasınav_proje;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Deneme {

    public static void main(String[] args) {
        //Oluşturulan tüm nesneleri tutabilecek GeometrikNesne tipli 50 elemanlı bir dizi yaratma
        GeometrikNesne dizi[] = new GeometrikNesne[50];
        int sayac = 0; //GeometrikNesne dizisindeki eleman sayısını belirlemek için kullanılacak sayaç değişkeni

        //Daire nesnelerini tutabilecek Daire tipli 50 elemanlı bir dizi yaratma
        Daire daireDizi[] = new Daire[50];
        int daireSayac = 0; //Daire dizisindeki eleman sayısını belirlemek için kullanılacak sayaç değişkeni

        //Dikdortgen nesnelerini tutabilecek Dikdortgen tipli 50 elemanlı bir dizi yaratma
        Dikdortgen dikdortgenDizi[] = new Dikdortgen[50];
        int dikdortgenSayac = 0; //Dikdortgen dizisindeki eleman sayısını belirlemek için kullanılacak sayaç değişkeni

        //Silindir nesnelerini tutabilecek Silindir tipli 50 elemanlı bir dizi yaratma
        Silindir silindirDizi[] = new Silindir[50];
        int silindirSayac = 0; //Silindir dizisindeki eleman sayısını belirlemek için kullanılacak sayaç değişkeni

        try { //Dosyanın olup olmadığının denenmesi
            File dosya = new File("input.txt"); //Dosyanın açılması
            Scanner rdr = new Scanner(dosya); //Dosyanın okunması

            //Dosyanın her satırının okunmasını ve dğişkenlerin atanmasını sağlayacak while döngüsü
            while (rdr.hasNextLine()) {
                String sinif = rdr.next(); //Satırdaki ilk kelimenin sınıf olarak atanması
                sinif.toLowerCase(); //Sınıfı doğru şekilde kontrol edebilmek için tüm harfleri küçültme
                String etiket = rdr.next();

                //Sınıf'a göre gerçekleşecek switch case 
                switch (sinif) {
                    case "daire": { //Sınıf Daire olduğu zaman gerçekleşecekler
                        double yaricap = rdr.nextDouble();
                        String date = rdr.next();
                        int ay = rdr.nextInt();
                        int gun = rdr.nextInt();
                        int yil = rdr.nextInt();

                        //Daire nesnesini tüm nesnelerin tutulduğu diziye ekleme
                        dizi[sayac] = new Daire(etiket, new Date(ay, gun, yil), yaricap);

                        //Daire nesnesini dairelerin tutulduğu diziye ekleme
                        daireDizi[daireSayac] = new Daire(etiket, new Date(ay, gun, yil), yaricap);
                        sayac++; //Sayacın 1 artırılması
                        daireSayac++; //Daire sayacının 1 artırılması
                        break;
                    }
                    case "dikdortgen": { //Sınıf Dikdortgen olduğu zaman gerçekleşecekler
                        double en = rdr.nextDouble();
                        double boy = rdr.nextDouble();
                        String date = rdr.next();
                        int ay = rdr.nextInt();
                        int gun = rdr.nextInt();
                        int yil = rdr.nextInt();

                        //Dikdortgen nesnesini tüm nesnelerin tutulduğu diziye ekleme
                        dizi[sayac] = new Dikdortgen(etiket, new Date(ay, gun, yil), en, boy);

                        //Dikdortgen nesnesini dikdörtgenlerin tutulduğu diziye ekleme
                        dikdortgenDizi[dikdortgenSayac] = new Dikdortgen(etiket, new Date(ay, gun, yil), en, boy);
                        sayac++; //Sayacın 1 artırılması
                        dikdortgenSayac++; //Dikdörtgen sayacının 1 artırılması
                        break;
                    }
                    default: { //Sınıf Silindir olduğu zaman gerçekleşecekler
                        double yaricap = rdr.nextDouble();
                        double uzunluk = rdr.nextDouble();
                        String date = rdr.next();
                        int ay = rdr.nextInt();
                        int gun = rdr.nextInt();
                        int yil = rdr.nextInt();

                        //Silindir nesnesini tüm nesnelerin tutulduğu diziye ekleme
                        dizi[sayac] = new Silindir(etiket, new Date(ay, gun, yil), yaricap, uzunluk);

                        //Silindir nesnesini silindirlerin tutulduğu diziye ekleme
                        silindirDizi[silindirSayac] = new Silindir(etiket, new Date(ay, gun, yil), yaricap, uzunluk);
                        sayac++; //Sayacın 1 artırılması
                        silindirSayac++; //Silindir sayacının 1 artırılması
                        break;
                    }
                }
            }

            rdr.close(); //Dosyanın kapatılması

        } catch (FileNotFoundException e) {
            //Dosyanın açılması veya okunmasında sıkıntı olduğu takdirde kullanıcının uyarılması
            System.out.println("Dosya bulunamadı");
        }

        //Son oluşturulan daire nesnesinin copy constructor ile kopyasını oluşturma ve diziye yerleştirme
        daireDizi[daireSayac] = new Daire(daireDizi[daireSayac - 1]);
        //Son oluşturulan dikdörtgen nesnesinin copy constructor ile kopyasını oluşturma ve diziye yerleştirme
        dikdortgenDizi[dikdortgenSayac] = new Dikdortgen(dikdortgenDizi[dikdortgenSayac - 1]);
        //Son oluşturulan silindir nesnesinin copy constructor ile kopyasını oluşturma ve diziye yerleştirme
        silindirDizi[silindirSayac] = new Silindir(silindirDizi[silindirSayac - 1]);

        //Kopya nesneleri tüm nesnelerin tutulduğu diziye yerleştirme
        dizi[sayac] = daireDizi[daireSayac];
        dizi[sayac + 1] = dikdortgenDizi[dikdortgenSayac];
        dizi[sayac + 2] = silindirDizi[silindirSayac];

        sayac += 2; //Kopya nesneleri diziye yerleştirdikten sonra sayacı 2 artırma

        double topCevre = 0; //Toplam çevre değişkenini 0'a eşitleme
        double topAlan = 0; //Toplam alan değişkenini 0'a eşitleme
        double topHacim = 0; //Toplam hacim değişkenini 0'a eşitleme
        //En büyük çevre değişkenini dizideki ilk nesnenin çevresine eşitleme
        double maxCevre = dizi[0].cevreHesapla();
        //En büyük alan değişkenini dizideki ilk nesnenin alanına eşitleme
        double maxAlan = dizi[0].alanHesapla();
        //En küçük çevre değişkenini dizideki ilk nesnenin çevresine eşitleme
        double minCevre = dizi[0].cevreHesapla();
        //En küçük alan değişkenini dizideki ilk nesnenin alanına eşitleme
        double minAlan = dizi[0].alanHesapla();

        for (int i = 0; i < sayac + 1; i++) { //Dizideki eleman sayısı kadar dönecek olan for döngüsü
            //Dizideki tüm nesnelerin bilgilerinin polymorphicYazdir metodu çağrılarak yazdırılması
            polymorphicYazdir(dizi[i]);
            System.out.println(" "); //Daha rahat okunması için satırı boş bırakma
            topCevre += dizi[i].cevreHesapla(); //Tüm nesnelerin çevresinin toplanması
            topAlan += dizi[i].alanHesapla(); //Tüm nesnelerin alanının toplanması

            //Dizideki nesnelerin çevrelerini maxCevre değişkeniyle karşılaştırarak 
            //en büyük çevreyi bulma ve maxCevre değişkenine atama
            if (dizi[i].cevreHesapla() > maxCevre) {
                maxCevre = dizi[i].cevreHesapla();
            }
            //Dizideki nesnelerin alanlarını maxAlan değişkeniyle karşılaştırarak
            //en büyük alanı bulma ve maxAlan değişkenine atama
            if (dizi[i].alanHesapla() > maxAlan) {
                maxAlan = dizi[i].alanHesapla();
            }
            //Dizideki nesnelerin çevrelerini minCevre değişkeniyle karşılaştırarak
            //en küçük çevreyi bulma ve minCevre değişkenine atama
            if (dizi[i].cevreHesapla() < minCevre) {
                minCevre = dizi[i].cevreHesapla();
            }
            //Dizideki nesnelerin alanlarını minAlan değişkeniyle karşılaştırarak
            //en küçük alanı bulma ve minAlan değişkenine atama
            if (dizi[i].alanHesapla() < minAlan) {
                minAlan = dizi[i].alanHesapla();
            }
        }
        //En küçük ve en büyük hacim değerlerini ilk silindirin hacmine eşitleme
        double minHacim = silindirDizi[0].hacimHesapla();
        double maxHacim = silindirDizi[0].hacimHesapla();

        //Silindir dizisindeki eleman sayısı kadar dönecek olan for döngüsü
        for (int i = 0; i < silindirSayac + 1; i++) {
            topHacim += silindirDizi[i].hacimHesapla(); //Tüm silindirlerin hacminin toplanması
            //Silindir nesnelerinin hacimlerini minHacim değişkeniyle karşılaştırarak
            //en küçük hacmi bulma ve minHacim değişkenine atama
            if (silindirDizi[i].hacimHesapla() < minHacim) {
                minHacim = silindirDizi[i].hacimHesapla();
            }
            //Silindir nesnelerinin hacimlerini maxHacim değişkeniyle karşılaştırarak
            //en büyük hacmi bulma ve minHacim değişkenine atama
            if (silindirDizi[i].hacimHesapla() > maxHacim) {
                maxHacim = silindirDizi[i].hacimHesapla();
            }
        }
        //karsilastir metoduyla ilk oluşturulan daire nesnesini ve son oluşturulan 
        //daire nesnesini karşılaştırma
        karsilastir(daireDizi[0], daireDizi[daireSayac]);

        //karsilastir metoduyla son oluşturulan daire nesnesini ve ondan bir önceki 
        //daire nesnesini karşılaştırma 
        karsilastir(daireDizi[daireSayac], daireDizi[daireSayac - 1]);

        //karsilastir metoduyla ilk oluşturulan dikdörtgen nesnesini ve son oluşturulan
        //dikdörtgen nesnesini karşılaştırma
        karsilastir(dikdortgenDizi[0], dikdortgenDizi[dikdortgenSayac]);

        //karsilastir metoduyla son oluşturulan dikdörtgen nesnesini ve ondan bir önceki 
        //dikdörtgen nesnesini karşılaştırma
        karsilastir(dikdortgenDizi[dikdortgenSayac], dikdortgenDizi[dikdortgenSayac - 1]);

        //karsilastir metoduyla ilk oluşturulan silindir nesnesini ve son oluşturulan
        //silindir nesnesini karşılaştırma
        karsilastir(silindirDizi[0], silindirDizi[silindirSayac]);

        //karsilastir metoduyla son oluşturulan silindir nesnesini ve ondan bir önceki 
        //silindir nesnesini karşılaştırma
        karsilastir(silindirDizi[silindirSayac], silindirDizi[silindirSayac - 1]);
        System.out.println(" "); //Daha rahat okunması için satırı boş bırakma

        //Toplam çevre değerini toplam nesne sayısına bölerek ortalma çevre değerini bulma
        double ortCevre = topCevre / (sayac + 1);
        //Toplam alan değerini toplam nesne sayısına bölerek ortalama alan değerini bulma
        double ortAlan = topAlan / (sayac + 1);
        //Toplam hacim değerini toplam silindir sayısına bölerek ortalma hacim değerini bulma
        double ortHacim = topHacim / (silindirSayac + 1);

        //Sırası ile çevre ortalaması, alan ortalaması, hacim ortalaması, 
        //en küçük çevre değeri, en büyük çevre değeri, en küçük alan değeri, 
        //en büyük alan değeri, en küçük hacim değeri ve en büyük hacim değerinin
        //double tipindeki ortMaxMin dizisine yerleştirilmesi
        double ortMaxMinDizi[] = {ortCevre, ortAlan, ortHacim, minCevre,
            maxCevre, minAlan, maxAlan, minHacim, maxHacim};

        //ortMaxMin dizisindeki eleman sayısı kadar dönecek olan for döngüsü
        for (int i = 0; i < ortMaxMinDizi.length; i++) {
            //ortMaxMin dizisindeki tüm elemanların yazdırılması
            System.out.println(String.format("%.3f", ortMaxMinDizi[i]));
        }

    }

    //GeometrikNesne tipinde parametre alan statik metot 
    public static void polymorphicYazdir(GeometrikNesne o) {
        //Parametre olarak alınan nesnenin bilgilerinin yazdırılması
        System.out.println(o.toString());
        //Parametre olarak alınan nesnenin çevresinin yazdırılması
        System.out.println("Çevre: " + String.format("%.3f", o.cevreHesapla()));
        //Parametre olarak alınan nesnenin alanının yazdırılması
        System.out.println("Alan: " + String.format("%.3f", o.alanHesapla()));
        //Parametre olarak alınan nesne Silindir sınıfından ise gerçekleşecekler
        if (o.getClass() == Silindir.class) {
            Silindir oSilindir = (Silindir) o;
            //Parametre olarak alınan Silindirin hacminin yazdırılması
            System.out.println("Hacim: " + String.format("%.3f", oSilindir.hacimHesapla()));
        }
    }

    //GeometrikNesne tipinde 2 tane parametre alan statik metot
    public static void karsilastir(GeometrikNesne x, GeometrikNesne y) {
        //Daha önce yazılan compareTo metotları kullanılarak, 
        //alınan ilk parametrenin ikinci parametre ile karşılaştırılması
        System.out.println(x.compareTo(y));

    }

}
