package com.niuzhendong.sort.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author niuzhendong
 * @package_name com.niuzhendong.sort.utils
 * @project_name sort
 * @date 2019/10/8
 */
public class SortUtils {

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current = 0;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        int length = array.length;
        int current, gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && current < array[preIndex]) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            //调用快速排序方法，并返回指针所在位置
            int index = sortAndGetIndex(array, left, right);
            //递归调用，分别对排序好的左右两小部分（左边小于原先基准数的数列，右边大于原先基准数的数列）
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    public static int sortAndGetIndex(int[] array, int left, int right) {
        //数组的第一个元素为基准数
        int key = array[left];
        while (left < right) {
            //从右边开始比对。大于基准数，right指针左移一位；小于基准数，把当前的数赋值给left指针所在位置
            while (left < right && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            //小于基准数，left指针右移一位；大于基准数，把当前的数赋值给right指针所在位置
            while (left < right && array[left] <= key) {
                left++;
            }
            array[right] = array[left];
        }
        //最后将基准数放到指针重合位置
        array[left] = key;
        return left;
    }

    /**
     * 堆排序算法
     *
     * @param array
     * @return
     */
    /**
     * 声明全局变量，用于记录数组array的长度
     */
    static int len;

    public static int[] heapSort(int[] array) {
        len = array.length;
        if (len < 1) {
            return array;
        }
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    public static void swap(int[] array, int maxIndex, int i) {
        int temp = array[maxIndex];
        array[maxIndex] = array[i];
        array[i] = temp;
    }

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] countingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }

    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    public static void main(String[] args) {
        /**
         * 冒泡排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //冒泡排序
        System.out.print("1、冒泡排序结果：");
        int[] bubbleSortArray = bubbleSort(array);
        System.out.println(Arrays.toString(bubbleSortArray));
        System.out.println();

        /**
         * 选择排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //选择排序
        System.out.print("2、选择排序结果：");
        int[] selectionSortArray = selectionSort(array);
        System.out.println(Arrays.toString(selectionSortArray));
        System.out.println();

        /**
         * 插入排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //插入排序
        System.out.print("3、插入排序结果：");
        int[] insertionSortArray = insertionSort(array);
        System.out.println(Arrays.toString(insertionSortArray));
        System.out.println();

        /**
         * 希尔排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //希尔排序
        System.out.print("4、希尔排序结果：");
        int[] shellSortArray = shellSort(array);
        System.out.println(Arrays.toString(shellSortArray));
        System.out.println();

        /**
         * 归并排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //归并排序
        System.out.print("5、归并排序结果：");
        int[] mergeSortArray = mergeSort(array);
        System.out.println(Arrays.toString(mergeSortArray));
        System.out.println();

        /**
         * 快速排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //快速排序
        System.out.print("6、快速排序结果：");
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println();

        /**
         * 堆排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //堆排序
        System.out.print("7、堆排序结果：");
        int[] heapSortArray = heapSort(array);
        System.out.println(Arrays.toString(heapSortArray));
        System.out.println();

        /**
         * 计数排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //计数排序
        System.out.print("8、计数排序结果：");
        int[] countingSortArray = countingSort(array);
        System.out.println(Arrays.toString(countingSortArray));
        System.out.println();

        /**
         * 桶排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.addAll(CollectionUtils.arrayToList(array));
        System.out.println(Arrays.toString(arrayList.toArray()));

        //桶排序
        System.out.print("9、桶排序结果：");
        ArrayList bucketSortArray = bucketSort(arrayList, 10);
        System.out.println(Arrays.toString(bucketSortArray.toArray()));
        System.out.println();

        /**
         * 基数排序测试
         */
        //排序前的数组
        System.out.print("#、排序前的数组：");
        array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
        System.out.println(Arrays.toString(array));

        //基数排序
        System.out.print("10、基数排序结果：");
        int[] radixSortArray = radixSort(array);
        System.out.println(Arrays.toString(radixSortArray));
        System.out.println();
    }
}
