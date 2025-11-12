import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //<num, count>
        HashMap<Integer, Integer> freq = new HashMap<>();

        //Build freq by one pass over nums
        for(int n: nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a[1], b[1])
        );

        //For each (num, count): push into min-heap, if heap.size() > K, pop smallest (by count)
        for(Map.Entry<Integer, Integer> e: freq.entrySet()){
            pq.offer(new int[] {e.getKey(), e.getValue()});
            if(pq.size() > k) pq.poll();
        }

        // extract heap content to return result
        int[] result = new int[k];
        for(int i = k - 1; i >= 0 ; i--){
            result[i] = pq.poll()[0];

        }

        return result;

    }
}
