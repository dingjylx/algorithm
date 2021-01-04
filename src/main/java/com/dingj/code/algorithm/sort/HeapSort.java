package com.dingj.code.algorithm.sort;

/**
 * 堆排序
 * 对简单选择排序的优化。
 * 1、将待排序数组构建成一个大顶堆，也就是变换原始数组中元素的位置，使之满足大顶堆的定义。
 * 2、将堆顶节点与堆中末尾节点交换，也就是数组的首尾元素交换，此时末尾节点已为最大元素，考虑剩余节点形成的堆。
 * 3、将最新的堆重新构造成大顶堆。
 * 4、重复第2步、第3步直到堆中节点全部输出。
 */
public class HeapSort {


    /**
     * 大顶堆（升序）：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 小顶堆（降序）：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //1.构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr    待调整堆
     * @param parent 父节点
     * @param length 堆长度
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        // 将tmp作为父节点
        int tmp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            // 右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (tmp >= arr[lChild]) {
                break;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            arr[parent] = arr[lChild];
            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = tmp;// 将tmp值放到最终的位置

    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
