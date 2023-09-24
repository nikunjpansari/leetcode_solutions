//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Pair<T, U> {
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getKey() {
        return first;
    }

    public U getValue() {
        return second;
    }
}

class Solution {

    public static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(
            Comparator.comparing((Pair<Integer, Pair<Integer, Integer>> pair) -> -pair.getKey())
        );

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            pq.add(new Pair<>(A[i] + B[N - 1], new Pair<>(i, N - 1)));
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && K > 0) {
            Pair<Integer, Pair<Integer, Integer>> top = pq.poll();
            int data = top.getKey();
            int x = top.getValue().getKey();
            int y = top.getValue().getValue();
            ans.add(data);

            if (y != 0) {
                pq.add(new Pair<>(A[x] + B[y - 1], new Pair<>(x, y - 1)));
            }

            K--;
        }

        return ans;
    }
}
