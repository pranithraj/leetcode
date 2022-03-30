/* https://leetcode.com/problems/pascals-triangle */
class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) return result;

        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
          final List<Integer> currentRow = new ArrayList<>();

          currentRow.add(1);
          for (int j = 1; j < i; j++) {
            currentRow.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
          }
          currentRow.add(1);
          result.add(currentRow);
        }
        return result;
    }
}
