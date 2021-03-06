/**
 * InPlaceMatrixRotate90Degree
 */
public class InPlaceMatrixRotate90Degree {

    public static void main(String[] args) {
        int N = 4; 
        int mat[][] = { 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 }, 
            { 13, 14, 15, 16 } 
        }; 
  
        rotateMatrix(N, mat); 
        displayMatrix(N, mat); 
    }

    public static void rotateMatrix(int N, int [][] mat) {
        for(int x = 0; x < N/2; x++) {
            for(int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - x - 1];
                mat[y][N-x-1] = mat[N-x-1][N-y-1];
                mat[N-x-1][N-y-1] = mat[N-y-1][x];
                mat[N-y-1][x] = temp;
            }
        }
    }

    static void displayMatrix(int N, int mat[][]) { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + mat[i][j]); 
  
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
    } 
}