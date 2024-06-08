import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,2,3,3,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            if(freq.containsKey(num)){
                freq.put(num, freq.getOrDefault(num, 0) + 1); // if it contains num we add 1 by default
            }else{
                freq.put(num, 1);
            }
        }

        PriorityQueue<Integer> freqQueue = new PriorityQueue<>(
                (a, b) -> freq.get(b) - freq.get(a));

        freqQueue.addAll(freq.keySet());

        int[] topKElements = new int[k];
        int index = 0;

        while(k > 0){

            topKElements[index++] = freqQueue.poll();
            k--;
        }

        return topKElements;
    }


}
