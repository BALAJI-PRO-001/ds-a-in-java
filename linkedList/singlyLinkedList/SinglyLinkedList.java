package linkedList.singlyLinkedList;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
  private Node headNode;
  private Node lastNode;
  private int size = 0;

  private class Node {
    T data;
    Node nextNode;
    
    public Node(T data) {
      this.data = data;
      this.nextNode = null;
      size++;
    }
  }
  

  public SinglyLinkedList() {
    headNode = null;
    lastNode = null;
  }


  private void validateIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index. Index must be between 0 and " + (size - 1) + ".");
    }
  }

  private void checkIfListIsEmpty() {
    if (size == 0) {
      throw new IllegalStateException("List is empty. Please add elements to the list.");
    }
  }


  public void insertFirst(T element) {
    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      lastNode = newNode;
    } else {
      Node tempNode = headNode;
      newNode.nextNode = tempNode;
      lastNode = tempNode;
      headNode = newNode;
    }
  }


  public void insertLast(T element) {
    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      lastNode = newNode;
    } else {
      lastNode.nextNode = newNode;
      lastNode = newNode;
    }
  }


  public void insertAtIndex(int index, T element) {
    checkIfListIsEmpty();
    validateIndex(index);
    
    if (index == 0) {
      insertFirst(element);
      return;
    }

    int i = 0;
    Node tempNode = headNode;
    Node preNode = null;
    Node newNode = new Node(element);

    while (tempNode != null) {
      preNode = tempNode;
      if (i == index) 
        break;
      tempNode = tempNode.nextNode;
      i++;
    }

    preNode.nextNode = newNode;
    newNode.nextNode = tempNode;
  }


  public T deleteFirst() {
    checkIfListIsEmpty();
    T element = headNode.data;
    Node tempNode = headNode;
    headNode = tempNode.nextNode;
    size --;
    return element;
  }



  // public T deleteLast() {
  //   checkIfListIsEmpty();
  //   T element = lastNode.data;
    
  // }


  public int size() {
    return this.size;
  }


  public int getSize() {
    if (this.size == 0) 
      return 0;

    int size = 0;
    Node tempNode = headNode;
    while (tempNode != null) {
      size++;
      tempNode = tempNode.nextNode;
    }
    return size;
  }


  public void print() {
    System.out.print("\nList Elements: [ ");
    Node tempNode = headNode;
    while (tempNode != null) {
      System.out.print(tempNode.data + " ");
      tempNode = tempNode.nextNode;
    }
    System.out.println("]");
  }


  public void indexView() {
    if (headNode != null) {
      Node tempNode = headNode;
      int index = 0;
      System.out.println();
      while (tempNode != null) {
        System.out.println("Index: " + (index++) + " Element: " + tempNode.data);
        tempNode = tempNode.nextNode;
      }
    }
  }


  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node tempNode = headNode;

      public boolean hasNext() {
        return tempNode != null;
      }

      public T next() {
        T data = tempNode.data;
        tempNode = tempNode.nextNode;
        return data;
      }
    };
  }
}
