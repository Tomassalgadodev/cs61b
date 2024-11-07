class Fibonacci {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fib2(int n, int k, int f0, int f1) {
        for (int i = 0; i < n - 1; i++) {
            k = f0 + f1;
            f0 = f1;
            f1 = k;
        }
        if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            System.out.println(k);
            return k;
        }
    }

    public static void main (String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(9));
    }
}