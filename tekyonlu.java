import java.util.Scanner;

class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

class LinkedList {
  Node head;

  public void add(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
  }
}

public class tekyonlu {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList list = new LinkedList();

    while (true) {
      System.out.println("Bir sayı giriniz (0 geçersiz!):");
      int n = scanner.nextInt();
      if (n != 0) {
    
     
      list.add(n);
    }


    System.out.print("Linked list: ");
    list.printList();
  }
}
}
