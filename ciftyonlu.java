public class ciftyonlu {
    Node head;
    
    public void ekle(String ogrenci)
    {
        Node yeniNod=new Node();
        yeniNod.setIsim(ogrenci);
        if(head==null)
        {
            head=yeniNod;
            head.setSonraki(yeniNod);
            head.setOnceki(yeniNod);
            
            return;
        }
        Node temp=head.getOnceki();
        temp.setSonraki(yeniNod);
        yeniNod.setOnceki(temp);
        yeniNod.setSonraki(head);
        head.setOnceki(yeniNod);
    }


    public void sil(String ad)
    {
        if(head==null)
        {
            System.out.println("Liste boş"); return;
        }
        Node temp=head;
        while(temp.getIsim()!=ad)
        {
            temp=temp.sonraki; 
        }
        temp.onceki.setSonraki(temp.sonraki);
        temp.sonraki.setOnceki(temp.onceki);
    
    }
    public void listele()
    {
        if(head==null)
        {
        System.out.println("liste boş");
        return;
        }

        System.out.println("Listesi: ");
        System.out.print(head.ogrenci+" <--> ");
        Node temp=head.sonraki;
        while(temp!=head)
        {
            System.out.print(temp.ogrenci+" <--> ");
            temp=temp.sonraki;
            if(temp.sonraki==null)
                System.out.print(" ");
        }
    }
    
}