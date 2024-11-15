class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(int x) {
        IntNode p = sentinel;
/** No longer needed because we created the sentinel which
 *  eliminates the special case where this is needed */
//        if (first == null) {
//            addFirst(x);
//            return;
//        }
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

 /** This was the old way before I started tracking size
  *  from the start instead of calculating it on demand */
//    private static int size(IntNode p) {
//        if (p.next == null) {
//             return 1;
//        }
//
//        return 1 + size(p.next);
//    }
//
//    public int size() {
//        return size(first);
//    }

    public int size() {
        return size;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public static void main (String[] args) {
        SLList single = new SLList(88);
        single.addFirst(15);
        single.addFirst(10);
        single.addLast(25);
        System.out.println(single.size());
    }
}