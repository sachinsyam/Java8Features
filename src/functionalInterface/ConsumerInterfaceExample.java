package functionalInterface;

import java.util.ArrayList;
import java.util.List;
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

    }



}
