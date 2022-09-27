package arasınav_proje;

//GeometrikNesne üst sınıfından türetilen Daire alt sınıfı
public class Daire extends GeometrikNesne {

    private double yaricap;

    public Daire() { //Hiç parametre girilmediği takdirde atanacak olan veriler
        super(); //Üst sınıftan değişken bilgilerini alma
        yaricap = 1.0;
    }

    //Parametre girildiği takdirde parametreleri değişkenlere atama
    public Daire(String etiket, Date tarih, double yaricap) {
        super(etiket, tarih); //Üst sınıftan değişken bilgilerini alma
        this.yaricap = yaricap;
    }

    //Parametre olarak girilen objenin kopyasını oluşturacak olan metot (copy constructor)
    public Daire(Daire originalObject) {
        super(originalObject); //Üst sınıftan kopya bilgilerini alma
        this.yaricap = originalObject.yaricap;
    }

    public double getYaricap() { //Daire'nin yarıçap değişkenini çağıracak metot
        return yaricap;
    }

    //Daire'nin yarıçap değişkenini düzenlemek için kullanılacak metot
    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    //Daire'nin bilgilerini yazdırmak için kullanılacak olan metot
    public String toString() {
        return (super.toString() + " " + String.format("%.2f", yaricap));
    }

    //Üst sınıfta imzası atılan abstact metotların gerçekleştirimleri
    @Override
    public double alanHesapla() { //Dairenin alanını hesaplamak için kullanılacak metot
        return (Math.PI * yaricap * yaricap);
    }

    @Override
    public double cevreHesapla() { //Dairenin çevresini hesaplamak için kullanılacak metot
        return (2 * Math.PI * yaricap);
    }

    @Override
    //İki dairenin yarıçaplarını karşılaştırmak için kullanılacak metot
    public int compareTo(Object o) {
        //Parametre olarak girilen objenin daire sınıfından olup olmadığının kontrolü
        if (getClass() != o.getClass()) {
            throw new ClassCastException("Sınıfları farklı, karşılaştırılamazlar");
        }
        Daire other = (Daire) o;
        // Metodun üzerinde çağrıldığı daire nesnesinin yarıçapı parametrede 
        //verilen daire nesnesinin yarıçapından 
        if (getYaricap() > other.getYaricap()) { //büyük ise 1
            return (1);
        } else if (getYaricap() < other.getYaricap()) { //küçük ise -1
            return (-1);
        } else {
            return (0); //eşitler ise 0 döndürülmesi
        }
    }

}
