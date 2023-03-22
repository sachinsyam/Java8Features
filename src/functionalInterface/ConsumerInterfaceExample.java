package functionalInterface;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {
    //    A consumer interface has 2 built in methods, 1. accept    2. andThen

    public void main(){
        System.out.println("Consumer Interface Example");
        Consumer<Integer> print = a -> System.out.println(a);
   //     print.accept(5);

        Consumer<List<Integer>> printList = list -> list.stream().forEach(a -> System.out.println(a));

        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);

    //    printList.accept(numList);

        Consumer<List<Integer>> modifyList = list -> {
            for (Integer listItem: list
                 ) {
                list.set(list.indexOf(listItem),2*listItem);
            }
        };


   //     using andThen function of consumer
        modifyList.andThen(printList).accept(numList);






        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");

        Consumer<List<String>> strPrint = list -> System.out.println(list);
        Consumer<List<String>> strAdd = list ->{
            for (String item: list) {
                list.set(list.indexOf(item),item+" is a fruit");
            }
        };

        strAdd.andThen(strPrint).accept(stringList);


        //      BiConsumer

        BiConsumer<String,Integer> biex = (a,b) -> System.out.println("String:"+a+" Integer:"+b);
        biex.accept("hello",5);

        BiConsumer<List<Integer>,List<Integer>> compareIntList = (list1,list2) -> {
            if(list1.size() != list2.size()){
                System.out.println("false");
            }
            else{
                for (int i = 0; i < list1.size(); i++) {
                    if(list1.get(i) != list2.get(i)){
                        System.out.println("false at"+i);
                        return;
                    }


                }

                System.out.println("true");
            }
        };

        List<Integer> numList1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numList2 = Arrays.asList(1,2,3,4,5);

        compareIntList.accept(numList1,numList2);




    }





}
