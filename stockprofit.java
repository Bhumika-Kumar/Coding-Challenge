

import java.util.*;

public class stockprofit {
    public static int maxProfit(int n, int[] prices) {
        if (n < 2) return 0;
        
        int minPrice = prices[0]; 
        int maxProfit = 0; 
        
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        System.out.println(maxProfit(n, prices));
        scanner.close();
    }
}
