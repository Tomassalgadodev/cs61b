class IntList {
    int first;
    IntList rest;

    IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    // This is how I originally wrote these functions on my own:
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

    // This is how Professor Jug wrote them:
    public int size2() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size2();
    }

    public int iterativeSize2() {
        IntList p = this;
        int counter = 0;
        while (p != null) {
            counter += 1;
            p = p.rest;
        }
        return counter;
    }

    public int get(int i) {
        if (i == 0) {
            return this.first;
        }
        return this.rest.get(i - 1);
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

        System.out.println(L.get(33));
    }
}