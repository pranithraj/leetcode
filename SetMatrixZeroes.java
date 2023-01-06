/* https://leetcode.com/problems/set-matrix-zeroes */

import java.util.Arrays;

public class SetMatrixZeroes {
 public static void main(String[] args) {
  int[][] inputArray = new int[3][4];
  for (int i = 0; i < 3; i++) {
   for (int j = 0; j < 4; j++) {
    inputArray[i][j] = 1;
   }
  }
  inputArray[0][0] = 0;
  inputArray[0][3] = 0;

  setMatrixZeroes(inputArray);
 }

 private static void setMatrixZeroes(int[][] matrix) {
  int row = matrix.length, col = matrix[0].length, col0 = 1;
  for (int i = 0; i < row; i++) {
   if (matrix[i][0] == 0) {
    col0 = 0;
   }
   for (int j = 1; j < col; j++) {
    if (matrix[i][j] == 0) {
     matrix[i][0] = 0;
     matrix[0][j] = 0;
    }
   }
  }

  for (int i = row - 1; i >= 0; i--) {
   for (int j = col - 1; j >= 1; j--) {
    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
     matrix[i][j] = 0;
    }
   }

   if (col0 == 0) {
    matrix[i][0] = 0;
   }
  }

  System.out.println(Arrays.toString(matrix));
 }
 
 // Easier to understand
 public void setZeroes2(int[][] matrix) {
        int cols = matrix[0].length - 1, rows = matrix.length - 1;
        boolean setRow = false, setCol = false;
        
        if (matrix[0][0] != 0) {
            for (int i = 1; i <= rows; i++) {
                if (matrix[i][0] == 0) {
                    setCol = true;
                    matrix[0][0] = 0;
                }
            }
            
            for (int i = 1; i <= cols; i++) {
                if (matrix[0][i] == 0) {
                    setRow = true;
                    matrix[0][0] = 0;
                }
            }
        } else {
            setRow = true;
            setCol = true;
        }

        // Setting the first element of row and col to 0 if we encounter a 0
        for (int i = rows; i > 0; i--) {
            for (int j = cols; j > 0; j--) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Traverse the first row except 0th index
        for (int i = rows; i > 0; i--) {
            for (int j = cols; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        if(setCol) for (int i = rows; i > 0; i--) matrix[i][0] = 0;
        if(setRow) for (int i = cols; i > 0; i--) matrix[0][i] = 0;
    }
}
