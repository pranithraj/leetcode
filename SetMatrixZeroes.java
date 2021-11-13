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
}
