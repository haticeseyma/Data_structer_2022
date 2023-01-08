public class Main {
    public static void main(String[] args) {
    
        ciftyonlu d=new ciftyonlu();
        d.ekle("Şeyma");   
        d.ekle("Hatice");
        d.ekle("Melike");
        d.ekle("Rümeysa");
        d.ekle("Seher");
        d.listele();
        d.sil("Hatice");
        System.out.println();
        d.listele();
    }
}