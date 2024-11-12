class IntList {
    int first;
    IntList rest;

    IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size(int currentSize) {
        if (this.rest != null) {
            currentSize += 1;
            return this.rest.size(currentSize);
        }
        return currentSize;
    }

    public int iterativeSize(IntList L) {
        int counter = 1;
        while(L.rest != null) {
            L = L.rest;
            counter += 1;
        }
        return counter;
    }

    public static void main (String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);

        System.out.println(L.size(1));
        System.out.println(L.iterativeSize(L));
    }
}