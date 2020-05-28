// Count Triplets That Can Form Two Arrays of Equal XOR
public class P1442 {
    public int countTriplets(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == 0) {
                    total += (j - i);
                }
            }
        }
        return total;
    }
}