class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int start = 0, end = rows * cols - 1;
        
        while (start <= end) {
            int mid = (end + start) / 2;
            
            if (matrix[mid / cols][mid % cols] == target) return true;
            else if (matrix[mid / cols][mid % cols] > target) end = mid - 1;
            else start = (mid + 1);
        }
        return false;
    }
}
