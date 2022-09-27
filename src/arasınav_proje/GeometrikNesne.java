package arasınav_proje;

public abstract class GeometrikNesne {

    private String etiket;
    private Date tarih;

    public GeometrikNesne() { //Hiç parametre girilmediği takdirde atanacak olan veriler
        etiket = "none";
        tarih = new Date(11, 1, 2001);

    }

    //Parametre girildiği takdirde parametreleri değişkenlere atama
    public GeometrikNesne(String etiket, Date tarih) {
        this.etiket = etiket;
        this.tarih = new Date(tarih);

    }

    //Parametre olarak girilen objenin kopyasını oluşturacak olan metot (copy constructor)
    public GeometrikNesne(GeometrikNesne originalObject) {
        this.etiket = originalObject.etiket;
        this.tarih = new Date(originalObject.tarih);
    }

    public String getEtiket() { //Geometrik nesnenin etiket değişkenini çağıracak metot
        return etiket;
    }

    //Geometrik nesnenin etiket değişkenini düzenlemek için kullanılacak metot
    public void setEtiket(String newEtiket) {
        if (newEtiket == null) { //Girilen parametrenin kontrolü
            System.out.println("Etiketi ayarlarken HATA oluştu!");
            System.exit(0);
        } else {
            etiket = newEtiket;
        }

    }

    public Date getTarih() { //Tarihi çağıracak olan metot
        return new Date(tarih);
    }

    // Tarihi düzenlemek için kullanılacak metot
    public void setTarih(Date newTarih) {
        if (newTarih == null) { //Girilen parametrenin kontrolü
            System.out.println("Tarihi ayarlarken HATA oluştu!");
            System.exit(0);
        } else {
            tarih = new Date(newTarih);
        }

    }

    //Geometrik nesnenin bilgilerini yazdırmak için kullanılacak metot
    public String toString() {
        return (etiket + " " + tarih.toString());
    }

    //Alt sınıflarda kullanılacak abstact metotların imzası
    public abstract double alanHesapla();

    public abstract double cevreHesapla();

    public abstract int compareTo(Object o);

}
