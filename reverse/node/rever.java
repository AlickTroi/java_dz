package node;

public class rever {
    public static class dList {
        private Node Head;
        private Node Tail;

        private class Node {
            private int value;
            private Node next;
            private Node prev;
        }

        Integer ReverseCount() {
            Node current = Head;
            int count = 0;
            if (current != null) {
                while (current != null) {
                    current = current.next;
                    count++;
                }
                return count;
            } else {
                return count;
            }
        }

        void Reverse() {
            Integer count = ReverseCount();
            Node currentH = Head;
            Node currentT = Tail;
            Node temp;
            if (count == 0) {
                return null;
            } else if (count / 2 == 0) {
                while (count / 2 == 0) {
                    temp = currentH;
                    currentH = currentT;
                    currentT = temp;
                    currentT = currentT.prev;
                    currentH = currentH.next;
                }
            } else
        }
    }
}
