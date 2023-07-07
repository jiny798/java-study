package Algorithm;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(5);
        pq.add(8);
        pq.add(10);
        pq.add(1);
        pq.add(2);

        System.out.println(pq.poll());// 1 작은것부터 나옴

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq2.add(5);
        pq2.add(8);
        pq2.add(10);
        pq2.add(1);
        pq2.add(2);

        System.out.println(pq2.poll());// 10 큰것부터 나옴
        System.out.println(pq2.poll()); // 8

    }
}
