class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        
        dfs(0, nums, new ArrayList<>(), visited);

        return result;
    }

    public void dfs(int depth, int[] nums, List<Integer> list, boolean[] visited) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(depth + 1, nums, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    } 
}