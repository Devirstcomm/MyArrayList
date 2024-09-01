import org.lists.MyArrayList;


public class Solution {
    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>(5);
        myArrayList.add("10"); //0
        myArrayList.add("11"); //1
        myArrayList.add("12"); //2
        myArrayList.add("13"); //3
        myArrayList.add("14"); //4
        myArrayList.add("15"); //5
        myArrayList.add("16"); //6
        myArrayList.set(6, "100"); //7
        myArrayList.add("18"); //8
        myArrayList.remove(4);
        myArrayList.add("21"); //10

//        myArrayList.add("Голова"); //0
//        myArrayList.add("Волосы"); //1
//        myArrayList.add("Руки"); //2


        //Сортировка чисел по возрастанию с реализованным компаратором
        myArrayList.sortAsNumbers();

        //Сортировка с переданным компаратором
//        myArrayList.sort();

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));
        }

    }
}
