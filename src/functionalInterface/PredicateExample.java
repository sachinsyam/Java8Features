package functionalInterface;

import com.sun.source.tree.BreakTree;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public void main(){
        Predicate<Integer> checkEven = a -> a%2==0;

        System.out.println(checkEven.test(4));

        IntPredicate intPredicate = a -> a%2==0;

        System.out.println(intPredicate.test(41));

        BiPredicate<Integer,Integer> checkEquals = (num1,num2) -> num1==num2;

        System.out.println(checkEquals.test(4,4));
    }
}
