package arasınav_proje;

//GeometrikNesne üst sınıfından türetilen Dikdortgen alt sınıfı
public class Dikdortgen extends GeometrikNesne {

    private double en;
    private double boy;

    public Dikdortgen() { //Hiç parametre girilmediği takdirde atanacak olan veriler
        super(); //Üst sınıftan değişken bilgilerini alma
        en = 1.0;
        boy = 1.0;
    }

    //Parametre girildiği takdirde parametreleri değişkenlere atama
    public Dikdortgen(String etiket, Date tarih, double en, double boy) {
        super(etiket, tarih); //Üst sınıftan değişken bilgilerini alma
        this.en = en;
        this.boy = boy;

    }

    //Parametre olarak girilen objenin kopyasını oluşturacak olan metot (copy constructor)
    public Dikdortgen(Dikdortgen originalObject) {
        super(originalObject); //Üst sınıftan kopya bilgilerini alma
        this.en = originalObject.en;
        this.boy = originalObject.boy;
    }

    public double getEn() { //Dikdörtgen'in en değişkenini çağıracak metot
        return en;
    }

    //Dikdörtgen'in en değişkenini düzenlemek için kullanılacak metot
    public void setEn(double en) {
        this.en = en;
    }

    public double getBoy() { //Dikdörtgen'in boy değişkenini çağıracak metot
        return boy;
    }

    //Dikdörtgen'in boy değişkenini düzenlemek için kullanılacak metot
    public void setBoy(double boy) {
        this.boy = boy;
    }

    //Dikdörtgen'in bilgilerini yazdırmak için kullanılacak olan metot
    public String toString() {
        return (super.toString() + " " + String.format("%.2f", en) + " "
                + String.format("%.2f", boy));
    }

    //Üst sınıfta imzası atılan abstact metotların gerçekleştirimleri
    @Override
    public double alanHesapla() { //Dikdörtgenin alanını hesaplamak için kullanılacak metot
        return (en * boy);
    }

    @Override
    public double cevreHesapla() { //Dikdörtgenin çevresini hesaplamak için kullanılacak metot
        return (2 * (en + boy));
    }

    @Override
    //İki dikdörtgenin alanlarını karşılaştırmak için kullanılacak metot
    public int compareTo(Object o) {
        //Parametre olarak girilen objenin dikdörtgen sınıfından olup olmadığının kontrolü
        if (getClass() != o.getClass()) {
            throw new ClassCastException("Sınıfları farklı, karşılaştırılamazlar");
        }
        Dikdortgen other = (Dikdortgen) o;
        // Metodun üzerinde çağrıldığı dikdörtgen nesnesinin alanı parametrede
        //verilen dikdörtgen nesnesinin alanından; 
        if (alanHesapla() > other.alanHesapla()) { //büyük ise 1,
            return (1);
        } else if (alanHesapla() < other.alanHesapla()) { //küçük ise -1,
            return (-1);
        } else {
            return (0); //eşitler ise 0 döndürülmesi.
        }
    }

}
