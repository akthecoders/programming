import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P768 {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        int nonzero = 0;

        int[] expect = arr.clone();
        Arrays.sort(expect);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int y = expect[i];

            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 0)
                nonzero--;
            if (count.get(x) == 1)
                nonzero++;

            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == 0)
                nonzero--;
            if (count.get(y) == -1)
                nonzero++;

            if (nonzero == 0)
                ans++;
        }
        return ans;
    }
}