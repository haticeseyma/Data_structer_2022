public class Node {

    String ogrenci;
    Node sonraki=null;
    Node onceki=null;
    
    public String getIsim() {
        return ogrenci;
    }
    public void setIsim(String ogrenci) {
        this.ogrenci = ogrenci;
    }
    public Node getSonraki() {
        return sonraki;
    }
    public void setSonraki(Node sonraki) {
        this.sonraki = sonraki;
    }
    public Node getOnceki() {
        return onceki;
    }
    public void setOnceki(Node onceki) {
        this.onceki = onceki;
    }
}