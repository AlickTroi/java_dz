import java.util.Scanner;

public class binTree {

  public class BinaryTree {

    private static Node Root = null;

    private class Node {
      boolean color;
      int value;
      Node Left;
      Node Right;

    }

    public boolean isRed(Node node) {
      if (node == null) {
        return false;
      }
      return node.color = true;
    }

    private void RightTurn(Node node) {
      Node parant = node;
      Node RightChild = node.Right.Left;
      node = node.Right;
      node.Left = parant;
      node.Left.Right = RightChild;
    }

    private void LeftTurn(Node node) {
      Node parant = node;
      Node LeftChild = node.Left.Right;
      node = node.Left;
      node.Right = parant;
      node.Right.Left = LeftChild;
    }

    private void swapColor(Node node) {
      node.color = true;
      node.Left.color = false;
      node.Right.color = false;
    }

    private Node rebalance(Node node) {
      boolean needRebalance = true;
      while (needRebalance) {
        needRebalance = false;
        if (node.Right != null && node.Right.color == true) {
          needRebalance = true;
          RightTurn(node);
        }
        if (node.Left != null && node.Left.color == true && node.Left.Left != null
            && node.Left.Left.color == true) {
          needRebalance = true;
          LeftTurn(node);
        }
        if (node.Left != null && node.Left.color == true && node.Right != null && node.Right.color == true) {
          needRebalance = true;
          swapColor(node);
        }
      }
      return node;

    }

    public boolean find(int Value) {
      Node current = Root;
      while (current != null) {
        if (current.value == Value) {
          return true;
        }

        if (Value < current.value) {
          current = current.Left;
        } else {
          current = current.Right;
        }
      }
      return false;
    }

    public void push(int Value) {
      Node node = new Node();
      node.value = Value;
      node.color = true;

      if (Root == null) {
        Root = node;
        Root.color = false;
      } else {

        Node current = Root;
        while (current != null) {
          if (Value < current.value) {
            if (current.Left == null) {
              current.Left = node;
              rebalance(node);
              return;
            }
            current = current.Left;
          } else {
            if (current.Right == null) {
              current.Right = node;
              rebalance(node);
              return;
            }
            current = current.Right;
          }
        }
      }

    }

    public void inorder(Node node) {
      if (node != null) {
        inorder(node.Left);
        char c = '●';
        if (node.color == false)
          c = '◯';
        System.out.print(node.value + "" + c + " ");
        inorder(node.Right);
      }
    }

  }

  public static void main(String[] args) {
    BinaryTree node = new BinaryTree();
    Scanner scan = new Scanner(System.in);

    char ch = 'Y';
    while (ch == 'Y' || ch == 'y') {
      System.out.println("Введите целое число");

      int num = scan.nextInt();

      node.inorder(node);
      System.out.println("\nВы хотите продолжить? (введите y или n)");
      ch = scan.next().charAt(0);
    }
  }
}