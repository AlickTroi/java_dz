/**
 * binTree
 */
public class binTree {

    public class BinaryTree {
        Node Root;

        private class Node {
            boolean color = black; // black == true, red == false
            int Value;
            Node Left;
            Node Right;
            Node parent;

        }

        private void RightTurn(Node node) {
            Node temp = new Nide();
            temp = node.Right;
            node.Right = node.Right.Left;
            node.Right.Left = temp;
        }

        private void LeftTurn(Node node) {
            Node temp = new Nide();
            temp = node.Left;
            node.Left = node.Left.Right;
            node.Left.Right = temp;
        }

        private void swapColor(Node node) {
            node.color = false;
            node.Left.color = true;
            node.Right.color = true;
        }

        private Node rebalance(Node node) {
            boolean needRebalance = true;
            while (needRebalance) {
                needRebalance = false;
                if (node.Right != null && node.Right.color == false) {
                    needRebalance = true;
                    RightTurn(node);
                }
                if (node.Left != null && node.Left.color == false && node.Left.Left != null
                        && node.Left.Left.color == false) {
                    needRebalance = true;
                    LeftTurn(node);
                }
                if (node.Left != null && node.Left.color == false && node.Right != null && node.Right.color == false) {
                    needRebalance = true;
                    swapColor(node);
                }
            }
            return node;

        }

        public void print(Node node) {

            System.out.println("value = ", node.Value, "color = ", node.color, "left = ", node.Left.Value, "color = ",
                    node.Left.color, "right = ", node.Right.Value, "color = ", node.Right.color);

        }

        public boolean find(int Value) {
            Node current = Root;
            while (current != null) {
                if (current.Value == Value) {
                    return true;
                }

                if (Value < current.Value) {
                    current = current.Left;
                } else {
                    current = current.Right;
                }
            }
            return false;
        }

        public void push(int Value) {
            Node node = new Node();
            node.Value = Value;
            node.color = false;

            if (Root == null) {
                Root = node;
                Root.color = true;
            } else {

                Node current = Root;
                while (current != null) {
                    if (Value < current.Value) {
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

        private void printCh(Node node) {
            node.print(node);
            if (node.Right != null) {
                printCh(node.Right);
            }
            if (node.Left != null) {
                printCh(node.Left);
            }

        }

        public static void main(String[] args) {
            
        }
    }
}