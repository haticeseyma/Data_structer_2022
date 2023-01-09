  
import java.util.Scanner;  
  
class Node  
{      
    int element;  
    int h;  //yükseklik için
    Node leftChild;  
    Node rightChild;  
      
    //boş düğüm oluşturmak için
    public Node()  
    {  
        leftChild = null;  
        rightChild = null;  
        element = 0;  
        h = 0;  
    }  
    public Node(int element)  
    {  
        leftChild = null;  
        rightChild = null;  
        this.element = element;  
        h = 0;  
    }       
}  
  
 
class ConstructAVLTree  
{  
    private Node rootNode;       
  

    public ConstructAVLTree()  
    {  
        rootNode = null;  
    }  
      
    //AVL ağacını boş yapmak için 
    public void removeAll()  
    {  
        rootNode = null;  
    }  
      
    // ağacın boş olup olmadığını kotrol etmek için
    public boolean checkEmpty()  
    {  
        if(rootNode == null)  
            return true;  
        else   
            return false;  
    }  
      
    // öge eklemek için 
    public void insertElement(int element)  
    {  
        rootNode = insertElement(element, rootNode);  
    }  
      
    //düğüm oluşturmak için  
    private int getHeight(Node node )  
    {  
        return node == null ? -1 : node.h;  
    }  
      
    //max yüksekliği elde etmek için
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)  
    {  
    return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;  
    }  
      
      
    //avl ağacına recursive olarak veri eklemek için 
    private Node insertElement(int element, Node node)  
    {  
        //düğmün boş olup olmadığını kontrol et
        if (node == null)  
            node = new Node(element);  
        //verilen eleman küçükse yeni düğüm ekle  
        else if (element < node.element)  
        {  
            node.leftChild = insertElement( element, node.leftChild );  
            if( getHeight( node.leftChild ) - getHeight( node.rightChild ) == 2 )  
                if( element < node.leftChild.element )  
                    node = rotateWithLeftChild( node );  
                else  
                    node = doubleWithLeftChild( node );  
        }  
        else if( element > node.element )  
        {  
            node.rightChild = insertElement( element, node.rightChild );  
            if( getHeight( node.rightChild ) - getHeight( node.leftChild ) == 2 )  
                if( element > node.rightChild.element)  
                    node = rotateWithRightChild( node );  
                else  
                    node = doubleWithRightChild( node );  
        }  
        else  
            ;  // öge zaten nodda mevcutsa hiçbirşey yapmayacak
        node.h = getMaxHeight( getHeight( node.leftChild ), getHeight( node.rightChild ) ) + 1;  
          
        return node;  
          
    }  
      
        
    private Node rotateWithLeftChild(Node node2)  
    {  
        Node node1 = node2.leftChild;  
        node2.leftChild = node1.rightChild;  
        node1.rightChild = node2;  
        node2.h = getMaxHeight( getHeight( node2.leftChild ), getHeight( node2.rightChild ) ) + 1;  
        node1.h = getMaxHeight( getHeight( node1.leftChild ), node2.h ) + 1;  
        return node1;  
    }  
  

    private Node rotateWithRightChild(Node node1)  
    {  
        Node node2 = node1.rightChild;  
        node1.rightChild = node2.leftChild;  
        node2.leftChild = node1;  
        node1.h = getMaxHeight( getHeight( node1.leftChild ), getHeight( node1.rightChild ) ) + 1;  
        node2.h = getMaxHeight( getHeight( node2.rightChild ), node1.h ) + 1;  
        return node2;  
    }  
  
    private Node doubleWithLeftChild(Node node3)  
    {  
        node3.leftChild = rotateWithRightChild( node3.leftChild );  
        return rotateWithLeftChild( node3 );  
    }  
  
    private Node doubleWithRightChild(Node node1)  
    {  
        node1.rightChild = rotateWithLeftChild( node1.rightChild );  
        return rotateWithRightChild( node1 );  
    }      
  
     
    public int getTotalNumberOfNodes()  
    {  
        return getTotalNumberOfNodes(rootNode);  
    }  
    private int getTotalNumberOfNodes(Node head)  
    {  
        if (head == null)  
            return 0;  
        else  
        {  
            int length = 1;  
            length = length + getTotalNumberOfNodes(head.leftChild);  
            length = length + getTotalNumberOfNodes(head.rightChild);  
            return length;  
        }  
    }  
  
    public boolean searchElement(int element)  
    {  
        return searchElement(rootNode, element);  
    }  
  
    private boolean searchElement(Node head, int element)  
    {  
        boolean check = false;  
        while ((head != null) && !check)  
        {  
            int headElement = head.element;  
            if (element < headElement)  
                head = head.leftChild;  
            else if (element > headElement)  
                head = head.rightChild;  
            else  
            {  
                check = true;  
                break;  
            }  
            check = searchElement(head, element);  
        }  
        return check;  
    }  
    public void inorderTraversal()  
    {  
        inorderTraversal(rootNode);  
    }  
    private void inorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            inorderTraversal(head.leftChild);  
            System.out.print(head.element+" ");  
            inorderTraversal(head.rightChild);  
        }  
    }  
  
    public void preorderTraversal()  
    {  
        preorderTraversal(rootNode);  
    }  
    private void preorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            System.out.print(head.element+" ");  
            preorderTraversal(head.leftChild);               
            preorderTraversal(head.rightChild);  
        }  
    }  
      
    public void postorderTraversal()  
    {  
        postorderTraversal(rootNode);  
    }  
      
    private void postorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            postorderTraversal(head.leftChild);               
            postorderTraversal(head.rightChild);  
            System.out.print(head.element+" ");  
        }  
    }       
}  
  
public class avltree 
{    
    public static void main(String[] args)  
    {              
        Scanner sc = new Scanner(System.in);  
  
        ConstructAVLTree obj = new ConstructAVLTree();   
  
        char choice;      
          
        do      
        {  
            System.out.println("\nBir işlem seçin:\n");  
            System.out.println("1. Düğüm ekle");  
            System.out.println("2.  Düğüm arama");  
            System.out.println("3. Avl deki toplam düğüm sayisini bul");  
            System.out.println("4. AVL ağaci boş mu?");  
            System.out.println("5. Avl ağacindaki tüm düğümleri kaldir");  
            System.out.println("6.  Post order ağaçta dolasma");  
            System.out.println("7. Pre order ağaçta dolasma");  
            System.out.println("8.In order ağaçta dolasma");  
  
        
            int ch = sc.nextInt();              
            switch (ch)  
            {  
                case 1 :   
                    System.out.println("Avl ağacina eklenecek elemani giriniz");  
                    obj.insertElement( sc.nextInt() );                       
                    break;                            
                case 2 :   
                    System.out.println("Aranacak elemani giriniz");  
                    System.out.println(obj.searchElement( sc.nextInt() ));  
                    break;                                            
                case 3 :   
                    System.out.println(obj.getTotalNumberOfNodes());  
                    break;       
                case 4 :   
                    System.out.println(obj.checkEmpty());  
                    break;       
                case 5 :   
                    obj.removeAll();  
                    System.out.println("\nAğaç basariyla teemizlendi");  
                    break;  
                case 6 :   
                    System.out.println("\nPost order sırasına göre avl ağacı");  
                    obj.postorderTraversal();  
                    break;  
                case 7 :   
                    System.out.println("\nPre order sırasına göre avl ağacı");  
                    obj.preorderTraversal();  
                    break;  
                case 8 :   
                    System.out.println("\nIn order sırasına göre avl ağacı");  
                    obj.inorderTraversal();  
                    break;  
                default :   
                    System.out.println("\n ");  
                    break;      
            }  
            System.out.println("\nDevam etmek için 'e' veya 'E' ye basın \n");  
            choice = sc.next().charAt(0);                          
        } while (choice == 'E'|| choice == 'e');         
    }  
} 