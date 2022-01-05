// https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/
class FrequencySort {
    public int[] frequencySort(int[] nums) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
    Arrays.stream(nums).forEach(n -> frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1));

    return Arrays.stream(nums).boxed().sorted((a, b) -> frequencyMap.get(a) != frequencyMap.get(b) ?
            frequencyMap.get(a) - frequencyMap.get(b) : b - a).mapToInt(n -> n).toArray();
    }
}
