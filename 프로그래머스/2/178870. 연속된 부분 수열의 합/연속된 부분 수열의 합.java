class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int left = 0, right = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < sequence.length && right < sequence.length) {
            if (sum == k) {
                int length = right - left;
                if (length < min) {
                    min = length;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                if (++right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left++];
            }
        }

        return answer;
    }
}
