package org.example.arithmetic.array;

/**
 * 无序数组的优点：插入快，如果知道下标，可以很快的存取
 * 无序数组的缺点：查找慢，删除慢，大小固定
 * @author hzq
 * @date 2020/6/28 14:15
 */
public class Array {

    private String[] strArray;
    /**
     * 数组元素个数
     */
    private int lenght = 0;

    public Array(int max) {
        strArray = new String[max];
    }

    /**
     * 检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
     * @param target
     * @return
     */
    public int contians(String target){
        for (int i = 0; i < lenght; i++) {
            if(target.equals(strArray[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 插入
     * @param element
     * @return
     */
    public void insert(String element){
        strArray[lenght] = element;
        lenght++;
    }

    /**
     * 删除某个指定的元素值，删除成功则返回true，否则返回false
     * @param target
     * @return
     */
    public boolean delete(String target){
        int index = -1;
        if((index = contians(target)) != -1){
            for (int i = index; i < lenght - 1; i++) {
                //删除元素之后的所有元素都向前移动一位
                strArray[i] = strArray[i + 1];
            }
            lenght--;
            return true;
        }else{
            return false;
        }
    }

    public void display(){
        for (int i = 0; i < lenght; i++) {
            System.out.print(strArray[i] + "\t");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Array array = new Array(6);
        array.insert("si");
        array.insert("wang");
        array.insert("jing");
        array.insert("su");
        array.insert("you");
        array.insert("xi");

        array.display();
        array.delete("jing");
        array.display();
    }
}
