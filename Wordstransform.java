import java.util.*;

public class transform{
    public static int minSwapsToTransform(String A, String B) {
        if (A.length() != B.length() || !isTransformable(A, B)) {
            return -1;
        }
        int n = A.length();
        int[] pos = new int[n];

        Map<Character, Queue<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.putIfAbsent(A.charAt(i), new LinkedList<>());
            indexMap.get(A.charAt(i)).offer(i);
        }

        for (int i = 0; i < n; i++) {
            pos[i] = indexMap.get(B.charAt(i)).poll();
        }

        return countInversions(pos);
    }

    private static boolean isTransformable(String A, String B) {
        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        return Arrays.equals(aArr, bArr);
    }

    private static int countInversions(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int inversions = mergeSort(arr, temp, left, mid);
        inversions += mergeSort(arr, temp, mid + 1, right);
        inversions += merge(arr, temp, left, mid, right);
        return inversions;
    }

    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, inversions = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1);
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, left, arr, left, right - left + 1);
        return inversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String A = scanner.next();
        String B = scanner.next();
        scanner.close();
        
        System.out.println(minSwapsToTransform(A, B));
    }
}