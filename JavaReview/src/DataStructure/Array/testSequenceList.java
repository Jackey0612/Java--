package DataStructure.Array;

//扩容！
public class testSequenceList {
    public static void main(String[] args) {


        sequenceList sequencelsit=new sequenceList();

        for (int i = 0; i <6 ; i++) {
            sequencelsit.add(i);
        }
        for (int i = 0; i <6 ; i++) {
            System.out.println(sequencelsit.getElement(i));
        }

        System.out.println("顺序表长度为："+sequencelsit.getSize());
        sequencelsit.insert(3,100);
        System.out.println("插入数据后顺序表元素为：");
        for (int i = 0; i <sequencelsit.size ; i++) {
            System.out.print(sequencelsit.getElement(i)+" ");
        }
        sequencelsit.delete(3);
        System.out.println("删除数据后顺序表元素为：");
        for (int i = 0; i <sequencelsit.size ; i++) {
            System.out.print(sequencelsit.getElement(i)+" ");
        }
        sequencelsit.clear();
        System.out.println("清空数据后顺序表元素为：");
        for (int i = 0; i <sequencelsit.size ; i++) {
            System.out.print(sequencelsit.getElement(i)+" ");
        }
    }
}
