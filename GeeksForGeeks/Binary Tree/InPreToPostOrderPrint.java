import java.util.Arrays;

/**
 * InPreToPostOrderPrint
 */
public class InPreToPostOrderPrint {

    public static void main(String[] args) {
        int in1[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        int n = in1.length;
        System.out.println("Postorder traversal ");
        printPostOrder(in1, pre, n);
    }

    public static void printPostOrder(int[] in1, int[] pre, int n) {
        int root = search(in1, pre[0], n);
        
        if(root != 0) {
            printPostOrder(in1, Arrays.copyOfRange(pre, 1, n), root);
        }
        if(root != n-1) {
            printPostOrder(Arrays.copyOfRange(in1, root + 1, n), Arrays.copyOfRange(pre, root + 1, n), n - root -  1);
        }

        System.out.println(pre[0] + " ");
    }

    static int search(int arr[], int x, int n) {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }
}