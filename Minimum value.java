

import java.util.*;

public class minimum {
    public static int minOfMaxBrightness(int k, int n, int[] brightness) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> maxValues = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && brightness[deque.peekLast()] <= brightness[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        for (int i = k; i < n; i++) {
            maxValues.add(brightness[deque.peekFirst()]);
            
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && brightness[deque.peekLast()] <= brightness[i]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
        }
        
        maxValues.add(brightness[deque.peekFirst()]);
        
        return Collections.min(maxValues);
    }
}