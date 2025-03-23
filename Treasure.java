

import java.util.*;

public class treasure{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int length = s.length();
        int n = scanner.nextInt();
        int[] prefixSum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) == 'T' ? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
        
        scanner.close();
    }
}