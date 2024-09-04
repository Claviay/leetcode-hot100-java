import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int finishedCourses = 0; // 记录已经完成的课程数量

        // 初始化图结构，getLaterCourses[i] 是一个列表，表示修完课程 i 后可以修的课程
        List<List<Integer>> getLaterCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            getLaterCourses.add(new ArrayList<>());
        }

        // 入度数组，用于记录每门课程的入度（依赖其他课程的数量）
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int previous = pair[1]; // 前置课程
            int later = pair[0]; // 后置课程

            // 添加边：从前置课程到后置课程
            getLaterCourses.get(previous).add(later);

            // 注意：这里加上的是后置课程的入度
            inDegree[later]++;
        }

        // 使用双端队列（Deque）来存储所有入度为 0 的课程
        Deque<Integer> queue = new ArrayDeque<>();
        // 初始化队列，将所有入度为 0 的课程添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        // 执行拓扑排序
        while (!queue.isEmpty()) {
            int item = queue.pollFirst(); // 取出可以修的课程
            finishedCourses++; // 完成课程计数器加一

            // 遍历修完这门课程后可以修的其他课程
            for (int i : getLaterCourses.get(item)) {
                inDegree[i]--; // 当前课程的依赖减一
                if (inDegree[i] == 0) { // 如果某门课程的入度变为 0
                    queue.addLast(i); // 将其加入队列，表示可以修这门课程
                }
            }
        }

        // 如果所有课程都能完成，返回 true，否则返回 false（说明存在循环依赖）
        return finishedCourses == numCourses;
    }
}
