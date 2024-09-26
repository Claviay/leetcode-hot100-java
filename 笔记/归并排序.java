import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array) {
        // 如果数组为空或长度小于 2，则无需排序
        if (array == null || array.length < 2) {
            return;
        }
        // 调用递归的归并排序方法
        mergeSort(array, 0, array.length - 1);
    }

    // 递归函数：将数组从 left 到 right 进行排序
    private static void mergeSort(int[] array, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2; // 找到中间位置
        // 递归分割数组
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        // 合并两个有序数组
        merge(array, left, mid, right);
    }

    // 合并两个有序数组
    private static void merge(int[] array, int left, int mid, int right) {
        // 创建一个临时数组用于合并
        int[] tempArray = new int[right - left + 1];
        int i = left;    // 左半部分起点
        int j = mid + 1; // 右半部分起点
        int k = 0;       // 临时数组的索引

        // 合并两个有序部分到临时数组
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }

        // 处理左半部分剩余元素
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }

        // 处理右半部分剩余元素
        while (j <= right) {
            tempArray[k++] = array[j++];
        }

        // 将合并后的内容复制回原数组
        for (int p = 0; p < tempArray.length; p++) {
            array[left + p] = tempArray[p];
        }
    }

    // 测试方法
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 9, 3, 5};
        mergeSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(array));
    }
}
