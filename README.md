## **一、排序算法说明**

#### **1.1、排序的定义**

对一序列对象根据某个关键字进行排序。

#### **1.2、术语说明**

- **稳定**：如果 a 原本在 b 前面，而 a=b，排序之后 a 仍然在 b 的前面。
- **不稳定**：如果 a 原本在 b 前面，而 a=b，排序之后 a 可能会出现在 b 的后面。
- **内排序**：所有排序操作都在内存中完成。
- **外排序**：由于数据太大，因此把数据放在磁盘中，而排序通过磁盘和内存的数据传输才能进行。
- **时间复杂度**：一个算法执行所耗费的时间。
- **空间复杂度**：运行完一个程序所需内存的大小。

#### **1.3、算法总结**

![img](https://mmbiz.qpic.cn/mmbiz_png/PzGicd0keQaEgwuT0ibtIjrdXvAwbL7AZuOrWuw1bVJj0JLNq2qKt720gnJrbgaxagDvLib3ee0tzCcpjQqluPQPQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

**图片名词解释：**

- n：数据规模
- k：“桶” 的个数
- In-place：占用常数内存，不占用额外内存
- Out-place：占用额外内存

#### **1.4、算法分类**

![img](https://mmbiz.qpic.cn/mmbiz_png/PzGicd0keQaEgwuT0ibtIjrdXvAwbL7AZuKbcVwf1X7xsibibplSGichUGVuYTfFyYpYxWT8xUibicRiaRYV4tsAA8XhGg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

#### **1.5、比较和非比较的区别**

常见的**冒泡排序、快速排序、堆排序、归并排序**等属于**比较排序**。在排序的最终结果里，元素之间的次序依赖于它们之间的比较。每个数都必须和其它数进行比较，才能确定自己的位置。

在**冒泡排序**之类的排序中，问题规模为 n ，又因为需要比较 n 次，所以平均时间复杂度为 O (n²) 。在**快速排序、归并排序**之类的排序中，问题规模通过**分治法**消减为 log N 次，所以时间复杂度平均 O (n log n)。

比较排序的优势是，适用于各种规模的数据，也不在乎数据的分布，都能进行排序。可以说，**比较排序适用于一切需要排序的情况**。

**计数排序、桶排序、基数排序**则属于**非比较排序**。非比较排序是通过确定每个元素之前，应该有多少个元素来排序。针对数组 arr ，计算 arr [i] 之前有多少个元素，则唯一确定了 arr [i] 在排序后数组中的位置。

非比较排序只要确定每个元素之前的已有的元素个数即可，所以一次遍历即可解决。算法时间复杂度 O (n) 。

**非比较排序时间复杂度低，但由于非比较排序需要占用空间来确定唯一位置。所以对数据规模和数据分布有一定的要求。**

## **二、十大排序算法**

### **2.1、冒泡排序（Bubble Sort）**

冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把

它们交换过来。走访数列的工作是重复地进行，直到没有数据再需要交换，也就是说该数列已经排序完成。

这个算法的名字由来是因为越小的元素会不断交换，慢慢 “浮” 到数列的顶端。

#### **2.1.1、算法描述**

1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
3. 针对所有的元素重复以上的步骤，除了最后一个；
4. 重复步骤 1~3，直到排序完成。

#### **2.1.2、动图演示**

![img](https://mmbiz.qpic.cn/mmbiz_gif/QCu849YTaIOOdfiakqsTRHKk9icjqQZJYuffv5BticjiaK3BNNtdH6dRFglibdwgA9w2oR6QZTadJeZHdOsicqyjasPg/640?tp=webp&wxfrom=5&wx_lazy=1)

#### **2.1.3、代码实现**

```
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
```

#### **2.1.4、算法分析**

最佳情况：T (n) = O (n)
最差情况：T (n) = O (n²)
平均情况：T (n) = O (n²)

### **2.2、选择排序（Selection Sort）**

表现**最稳定的排序算法之一**（时间复杂度都是 O (n²)），因为无论什么数据进去都是 O (n²) 的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间。

选择排序（Selection-Sort）是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，知道所有的元素均排序完毕。

#### **2.2.1、算法描述**

n 个记录的直接选择排序可经过 n-1 趟直接选择排序得到有序结果。具体算法描述如下：

1. 初始状态：无序区为 R [1...n]，有序区为空；
2. 第 i 趟排序（i=1,2,3...n-1）开始时，当前有序区和无序区分别为 R [1...i-1] 和 R (i...n) 。该趟排序从当前无序区中选出关键字最小的记录 R [k] ，将它与无序区的第 1 个记录 R 交换，使 R [1...i] 和 R [i+1...n) 分别变为记录个数增加 1 个的新有序区和记录个数减少 1 个的新无序区；
3. n-1 趟结束，数组有序化了。

#### **2.2.2、动图演示**

![img](https://mmbiz.qpic.cn/mmbiz_gif/QCu849YTaIOOdfiakqsTRHKk9icjqQZJYuROpQscX9fen1nqP1nia2lUADm29QpKHn7IqPn2Aiaic4DoPQ72GYKak6w/640?tp=webp&wxfrom=5&wx_lazy=1)

#### **2.2.3、代码实现**

```
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
```

#### **2.2.4、算法分析**

最佳情况：T (n) = O (n²)
最差情况：T (n) = O (n²) 
平均情况：T (n) = O (n²)

### **2.3、插入排序（Insertion Sort）**

插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用 In-space 排序（即只需用到 O (1) 的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

#### **2.3.1、算法描述**

一般来说，插入排序都采用 In-space 在数组上实现。具体算法描述如下：

1. 从第一个元素开始，该元素可以认为已经被排序；
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
4. 重复步骤 3 ，直到找到已排序的元素小于或者等于新元素的位置；
5. 将新元素插入到该位置后；
6. 重复步骤 2~5 。

#### **2.3.2、动图演示**

![img](https://mmbiz.qpic.cn/mmbiz_gif/QCu849YTaIOOdfiakqsTRHKk9icjqQZJYusIFPUq7PlJn7maGNCmlhzTnLCkRcNjulAZk34Elic3oeVka2u4icXWDA/640?tp=webp&wxfrom=5&wx_lazy=1)

#### **2.3.3、代码实现**

```
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
```

#### **2.3.4、算法分析**

最佳情况：T (n) = O (n)
最差情况：T (n) = O (n²)
平均情况：T (n) = O (n²)

### **2.4、希尔排序（Shell Sort）**

希尔排序是希尔（Donald Shell）于 1959 年提出的一种排序算法。希尔排序也是一种插入排序，它是直接插入排序经过改进之后的一个更高效的版本，也称为**缩小增量排序**，同时该算法是冲破 O (n²) 的第一批算法之一。它与插入排序不同之处在于，它会优先比较距离较远的元素。

希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止。

#### **2.4.1、算法描述**

我们来看下希尔排序的基本步骤，在此我们选择增量 gap=length/2 ，缩小增量继续以 gap=gap/2 的方式，这种增量选择我们可以用一个序列来表示，**{n/2,(n/2)/2...1}**，称为**增量序列**。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。

先将整个待排序的记录序列分割成若干子序列，分别进行直接插入排序，具体算法描述：

1. 选择一个增量序列 t1，t2，...，tk，其中 ti>tj，tk=1；
2. 按增量序列个数 k ，对序列进行 k 趟排序；
3. 每趟排序，根据对应的增量 ti ，将待排序列分割成若干长度为 m 的子序列，分别对各子序列进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

#### **2.4.2、过程演示**

![img](https://mmbiz.qpic.cn/mmbiz_png/PzGicd0keQaEgwuT0ibtIjrdXvAwbL7AZuEiaVtwNb6gmEw4Xy7aEd0zEgXXUibbAK8qHXVPibnDw8ypo6zGjqpcHdg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

#### **2.4.3、代码实现**

```
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
```

#### **2.4.4、算法分析**

最佳情况：T (n) = O (n log₂ n)
最坏情况：T (n) = O (n log₂ n)
平均情况：T (n) = O (n log₂ n)

### **2.5、归并排序（Merge Sort）**

和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是 O (n log₂ n) 的时间复杂度。代价是需要额外的内存空间。

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列间有序。若将两个有序表合并成一个有序表，称为 2 - 路归并。

#### **2.5.1、算法描述**

1. 把长度为 n 的输入序列分成两个长度为 n/2 的子序列；
2. 对这两个子序列分别采用归并排序；
3. 将两个排序好的子序列合并成一个最终的排序序列。

#### **2.5.2、动图演示**

![img](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)

#### **2.5.3、代码实现**

```
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
```

#### **2.5.4、算法分析**

最佳情况：T (n) = O (n log₂ n)
最坏情况：T (n) = O (n log₂ n)
平均情况：T (n) = O (n log₂ n)

### **2.6、快速排序（Quick Sort）**

快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

#### **2.6.1、算法描述**

快速排序使用分治法把一个串（list）分为两个子串（sub_lists）。具体算法描述如下：

1. 从数列中挑出一个元素，称为 “基准”（pivot）；
2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆放在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
4. 

#### **2.6.2、动图演示**

![img](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)

![img](https://mmbiz.qpic.cn/mmbiz_png/PzGicd0keQaEgwuT0ibtIjrdXvAwbL7AZuiaFcAtd449CQibsT67lGqyecjCGLQVJ4yUFBlkVHvJ2Fr58qeee1IJeQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

#### **2.6.3、代码实现**

```
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
```

#### **2.6.4、算法分析**

最佳情况：T (n) = O (n log₂ n)
最坏情况：T (n) = O (n²)
平均情况：T (n) = O (n log₂ n)

### **2.7、堆排序（Heap Sort）**

堆排序（Heap-Sort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子节点的键值或索引总是小于（或者大于）它的父节点。

#### **2.7.1、算法描述**

1. 将初始待排序关键字序列（R1,R2,...Rn）构建成大顶堆，此堆为初始的无序区；
2. 将堆顶元素 R [1] 与最后一个元素 R [n] 交换，此时得到新的无序区（R1,R2,...Rn-1）和新的有序区（Rn），且同时满足 R [1,2...n-1]<=R [n] ；
3. 由于交换后新的堆顶 R [1] 可能违反堆的性质，因此需要对当前无序区（R1,R2,...Rn-1）调整为新堆，然后再次将 R [1] 与无序区最后一个元素交换，得到新的无序区（R1,R2,...Rn-1）和新的有序区（Rn-1,Rn）。不断重复此过程直到有序区的元素个数为 n-1 ，则整个排序过程完成。
4. 

#### **2.7.2、动图演示**

![img](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)

#### **2.7.3、代码实现**

注意：这里用到了完全二叉树的部分性质：详情见《数据结构二叉树知识点总结》

```
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
```

#### **2.7.4、算法分析**

最佳情况：T (n) = O (n log₂ n)
最坏情况：T (n) = O (n log₂ n)
平均情况：T (n) = O (n log₂ n)

### **2.8、计数排序（Counting Sort）**

计数排序的核心在于将输入的数据值转化为键存储的额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

计数排序（Counting-Sort）是一种稳定的排序算法。计数排序使用一个额外的数组 C ，其中第 i 个元素是待排序数组 A 中值等于 i 的元素的个数。然后根据数组 C 来将 A 中的元素排到正确的位置。它只能对整数进行排序。

#### **2.8.1、算法描述**

1. 找出待排序的数组中最大和最小的元素；
2. 统计数组中每个值为 i 的元素出现的次数，存入数组 C 的第 i 项；
3. 对所有的计数累加（从 C 中的第一个元素开始，每一项和前一项相加）；
4. 反向填充目标数组：将每个元素 i 放在新数组的第 C (i) 项，每放一个元素就将 C (i) 减去 1 。
5. 

#### **2.8.2、动图演示**

![img](https://mmbiz.qpic.cn/mmbiz_gif/QCu849YTaIOOdfiakqsTRHKk9icjqQZJYu0t2QuZRYMJqzEAUiaiagwpngltGHrJyegsZCwr7GpxQoRcSpTmypS3ag/640?tp=webp&wxfrom=5&wx_lazy=1)

#### **2.8.3、代码实现**

```
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
```

#### **2.8.4、算法分析**

当输入的元素是 n 个 0 到 k 之间的整数时，它的运行时间是 O (n+k) 。计数排序不是比较排序，排序的速度快于任何比较排序算法。由于用来计数的数组 C 的长度取决于待排序数组中数据的范围（等于待排序数组的最大值和最小的差加上 1 ），这使得计数排序对于数据范围很大的数组，需要大量的时间和内存。

最佳情况：T (n) = O (n+k) 
最差情况：T (n) = O (n+k) 
平均情况：T (n) = O (n+k)

### **2.9、桶排序（Bucket Sort）**

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。

桶排序（Bucket-Sort）的工作原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）

#### **2.9.1、算法描述**

1. 人为设置一个 BucketSize，作为每个桶所能放置多少个不同数值（例如当 BucketSize==5 时，该桶可以存放 {1,2,3,4,5} 这几种数字，但是容量不限，即可以存放 100 个 3 ）；
2. 遍历输入数据，并且把数据一个一个放到对应的桶里去；
3. 对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
4. 从不是空的桶里把排好序的数据拼接起来。

**注意，如果递归使用桶排序为各个桶排序，则当桶数量为 1 时，要手动减少 BucketSize 增加下一循环桶的数量，否则会陷入死循环，导致内存溢出。**

#### **2.9.2、图片演示**

![img](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)

#### **2.9.3、代码实现**

```
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
```

#### **2.9.4、算法分析**

桶排序最好情况下使用线性时间 O (n) ，桶排序的时间复杂度，取决于对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为 O (n) 。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。

最佳情况：T (n) = O (n+k) 
最差情况：T (n) = O (n²) 
平均情况：T (n) = O (n+k)

### **2.10、基数排序（Radix Sort）**

基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为 O (kn) ，n 为数组长度，k 为数组中的数的最大的位数；

基数排序是按照低位优先排序，然后收集；再按照高位排序，然后再收集；以此类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。

#### **2.10.1、算法描述**

1. 取得数组中的最大数，并取得位数；
2. arr 为原始数组，从最低位开始取每个位组成的 radix 数组；
3. 对 radix 进行计数排序（利用计数排序适用于小范围数的特点）。

#### **2.10.2、动图演示**

![img](data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVQImWNgYGBgAAAABQABh6FO1AAAAABJRU5ErkJggg==)

#### **2.10.3、代码实现**

```
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
```

#### **2.10.4、算法分析**

最佳情况：T (n) = O (n*k) 
最差情况：T (n) = O (n*k) 
平均情况：T (n) = O (n*k)

基数排序有两种方法：

MSD 从高位开始进行排序
LSD 从低位开始进行排序

**基数排序 vs 计数排序 vs 桶排序**

这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：

- 基数排序：根据键值的每位数字来分配桶
- 计数排序：每个桶只存储单一键值
- 桶排序：每个桶存储一定范围的数值