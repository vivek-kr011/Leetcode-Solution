class Solution {
    public int fib(int n) {

        int f[] = new int[n+1];
        return helper(n , f);
    }

    public int helper(int n, int f[]) {

        if(n == 0 || n == 1) {
            return n;
        }

        if(f[n] != 0) {
            return f[n];
        }

        f[n] = helper(n-1, f) + helper(n-2, f);

        return f[n];
    }
}