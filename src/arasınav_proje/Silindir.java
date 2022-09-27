package arasınav_proje;

//GeometrikNesne üst sınıfından türetilen Silindir alt sınıfı
public class Silindir extends GeometrikNesne {

    private double yaricap;
    private double uzunluk;

    public Silindir() { //Hiç parametre girilmediği takdirde atanacak olan veriler
        super(); //Üst sınıftan değişken bilgilerini alma
        yaricap = 1.0;
        uzunluk = 1.0;
    }

    //Parametre girildiği takdirde parametreleri değişkenlere atama
    public Silindir(String etiket, Date tarih, double yaricap, double uzunluk) {
        super(etiket, tarih); //Üst sınıftan değişken bilgilerini alma
        this.yaricap = yaricap;
        this.uzunluk = uzunluk;
    }

    //Parametre olarak girilen objenin kopyasını oluşturacak olan metot (copy constructor)
    public Silindir(Silindir originalObject) {
        super(originalObject);
        this.yaricap = originalObject.yaricap;
        this.uzunluk = originalObject.uzunluk;
    }

    public double getYaricap() { //Silindir'in yarıçap değişkenini çağıracak metot
        return yaricap;
    }

    //Silindir'in yarıçap değişkenini düzenlemek için kullanılacak metot
    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    //Silindir'in uzunluk değişkenini çağıracak metot
    public double getUzunluk() {
        return uzunluk;
    }

    //Silindir'in uzunluk değişkenini düzenlemek için kullanılacak metot
    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }

    //Silindir'in bilgilerini yazdırmak için kullanılacak olan metot
    public String toString() {
        return (super.toString() + " " + String.format("%.2f", yaricap) + " "
                + String.format("%.2f", uzunluk));
    }

    //Silindirin hacmini hesaplamak için kullanılacak metot
    public double hacimHesapla() {
        return (Math.PI * yaricap * yaricap * uzunluk);
    }

    //Üst sınıfta imzası atılan abstact metotların gerçekleştirimleri
    @Override
    public double alanHesapla() { //Silindirin alanını hesaplamak için kullanılacak metot
        return (2 * yaricap * Math.PI * (yaricap + uzunluk));
    }

    @Override
    public double cevreHesapla() { //Silindirin çevresini hesaplamak için kullanılacak metot
        return ((2 * 2 * yaricap * Math.PI) + (2 * uzunluk));
    }

    @Override
    //İki silindirin hacimlerini karşılaştırmak için kullanılacak metot
    public int compareTo(Object o) {
        //Parametre olarak girilen objenin silindir sınıfından olup olmadığının kontrolü
        if (getClass() != o.getClass()) {
            throw new ClassCastException("Sınıfları farklı, karşılaştırılamazlar");
        }
        Silindir other = (Silindir) o;
        // Metodun üzerinde çağrıldığı silindir nesnesinin hacmi parametrede
        //verilen silindir nesnesinin hacminden; 
        if (hacimHesapla() > other.hacimHesapla()) { //büyük ise 1,
            return (1);
        } else if (hacimHesapla() < other.hacimHesapla()) { //küçük ise -1,
            return (-1);
        } else {
            return (0); //eşitler ise 0 döndürülmesi.
        }
    }

}
