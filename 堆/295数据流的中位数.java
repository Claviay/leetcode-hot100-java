import java.util.*;

class MedianFinder {
    Queue<Integer> A, B; // A是小顶堆，B是大顶堆

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半元素
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半元素
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            // 如果 A 的元素数量多于 B，将 num 插入 A，然后将 A 堆顶移动到 B
            A.add(num);
            B.add(A.poll());
        } else {
            // 如果 A 和 B 元素数量相同，将 num 插入 B，然后将 B 堆顶移动到 A
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        // 如果 A 和 B 元素数量不同，中位数为 A 的堆顶元素
        // 如果相同，中位数为 A 和 B 堆顶元素的平均值
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
