

public class rever {
    public static class dList {
        private Node Head;
        private Node Tail;

        private class Node {

            private Node next;

        }

    
        void Reverse() {
            Node currentH = Head;
            Node temp;
            if (currentH == null) {
                return;
            } else {
                while (currentH.next != null) {
                    temp = currentH;
                    currentH = currentH.next;
                    currentH.next = temp;

                    currentH = currentH.next;
                }
            } 
        }
    }
}
