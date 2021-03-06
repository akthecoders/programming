/**
 * SearchInRowWiseColumnWiseSortedMatrix
 */
public class SearchInRowWiseColumnWiseSortedMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

        search(mat, 4, 29);
    }

    public static void search(int[][] mat, int n, int element) {
        int i = 0, j = n - 1;
        while(i < n && j >= 0) {
            if(mat[i][j] == element) {
                System.out.println("Element found at : " + i + " " + j);
                return;
            }
            
            if(mat[i][j] > element) {
                j--;
            }
            else {
                i++;
            }
        }
        System.out.print("n Element not found"); 
        return;
    }
}