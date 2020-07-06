package org.example.arithmetic.array;

/**
 * 有序数组适用于查找频繁，而插入、删除操作较少的情况
 * @author hzq
 * @date 2020/6/28 14:32
 */
public class OrderArray {

    private int[] intArray;
    private int lenght = 0;

    public OrderArray(int max) {
        intArray = new int[max];
    }

    /**
     * 用二分查找法定位某个元素，如果存在返回其下标，不存在则返回-1
     * @param target
     * @return
     */
    public int find(int target){
        //搜索段最小元素下标
        int lowerBound = 0;

        //搜索段最大元素下标
        int upperBound = lenght - 1;

        //当前检测元素下标
        int curIn = 0;

        if(upperBound < 0){
            return -1;
        }

        while (true){
            curIn = (lowerBound + upperBound) / 2;

            if(target == intArray[curIn]){
                return curIn;
            } else if (curIn == lowerBound){
                //如果当前下标等于搜索段最小下标，表示当前搜索段只有一个或两个元素
                if(target != intArray[upperBound]){
                    //如果低位元素和高位元素都不等于目标元素，证明数组中没有目标元素，搜索结束
                    return -1;
                }
            }else{
                //搜索段中至少有三个元素，且当前元素不等于目标元素
                if(target > intArray[curIn]){
                    //如果当前元素小于目标元素，则将下一个搜索段的最小下标置为当前下标
                    lowerBound = curIn;
                } else {
                    //如果当前元素大于目标元素，则将下一个搜索段的最大下标置为当前下标
                    upperBound = curIn;
                }
            }
        }
    }

    /**
     * 插入
     * @param elem
     */
    public void insert(int elem) {
        int location = 0;

        //查询当前插入位置
        for (; location < lenght; location++) {
            if(elem < intArray[location]){
                break;
            }
        }

        //将插入位置后面的元素后移一位
        for (int i = lenght; i > location ; i--) {
            intArray[i] = intArray[i - 1];
        }

        intArray[location] = elem;
        lenght++;
    }

    /**
     * 删除某个指定的元素值，删除成功则返回true，否则返回false
     * @param target
     * @return
     */
    public boolean delete(int target){
        int index = -1;
        if((index = find(target)) != -1){
            for (int i = index; i < lenght - 1; i++) {
                //删除元素之后的所有元素都向前移动一位
                intArray[i] = intArray[i + 1];
            }
            lenght--;
            return true;
        }else{
            return false;
        }
    }

    public void display(){
        for (int i = 0; i < lenght; i++) {
            System.out.print(intArray[i] + "\t");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        OrderArray orderArray = new OrderArray(6);
        orderArray.insert(2);
        orderArray.insert(1);
        orderArray.insert(4);
        orderArray.insert(3);

        orderArray.display();
        orderArray.delete(3);
        orderArray.display();
    }
}
