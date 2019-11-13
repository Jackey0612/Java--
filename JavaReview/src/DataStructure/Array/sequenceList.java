package DataStructure.Array;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

/*
    一般的数组是不能随机读写的，也无法随机插入，顺序表实现了这个功能。
 */
public class sequenceList {
    private static final int DEFAULT_CAPACITY =10;
     int[] arr;
     int size;
    //实例化默认长度是顺序表
    public sequenceList(){
        arr= (int[]) Array.newInstance(int.class,DEFAULT_CAPACITY);
        size=0;
    }
    //实例化一个任意sz长度的顺序表
    public sequenceList(int[] obj, int sz){
        arr=(int[])Array.newInstance(int.class,sz);
        size=0;
    }

    //清空顺序表
    public void clear(){
        size=0;
    }
    //获取顺序表长度
    public int getSize(){
        return  size;
    }
    //判断顺序表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //获取指定下标的元素
    public int getElement(int index){
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }
    //设置指定下标的元素
    public int setElement(int index,int newVal){
        if (index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        int old=arr[index];
        arr[index]=newVal;
        return old;
    }
    //确保顺序表长度够用
    public void ensureCapacity(int newSize){
        if (newSize<arr.length) return;
        int[]old=arr;
        arr=new int[newSize];
        for (int i=0;i<old.length;i++){
            arr[i]=old[i];
        }
        return;
    }
    //当担心长度不够时，扩容
    public void trimToSize(){
        ensureCapacity(size);
    }
    //指定下标插入元素
    public void insert(int index,int target){
        if (index<0)
            throw new ArrayIndexOutOfBoundsException();
        //每次插入意味着顺序表总长度+1，要先判断是否还有空位可供插入，若无空位需扩容
        if (size==arr.length)
            ensureCapacity(size*2-1);
        for (int i = size; i >index ; i--) {
            arr[i]=arr[i-1];
        }
        arr[index]=target;
        size++;
    }
    //在顺序表末尾插入数据
    public boolean add(int target){
        insert(size,target);
        return true;
    }

    //指定下标删除元素
    public int delete(int index){
        int removeEmt=arr[index];
        if (index<0||index>=size)
            throw new ArrayIndexOutOfBoundsException();
        for (int i = index; i <arr.length-1 ; i++) {
            arr[i]=arr[i+1];
        }
        size--;
        return removeEmt;
    }
    //在顺序表末尾删除数据
    public boolean remove(){
        delete(size-1);
        return true;
    }
    //查找指定元素的下标
    public int getIndex(int target){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==target)
                return i;
        }
        //如果遍历整个数组都没有和target相等的元素，返回-1
        return -1;
    }
}
