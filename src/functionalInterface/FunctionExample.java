package functionalInterface;

import java.util.function.Function;

public class FunctionExample {
    public void main(){
        Function<Integer,Boolean> checkEven = a ->  a%2==0;

      //  System.out.println(checkEven.apply(10));

        Function<Integer,Integer> mul = a ->  a*2;
        mul = mul.andThen(a -> a+5);

        System.out.println(mul.apply(6));

        //the order changes when compose is used.
        Function <Integer,Integer> mul2 = a -> a*2;
        mul2 = mul2.compose(a -> a+5);

        System.out.println(mul2.apply(6));


        //simply returns whatever is passed
        Function<Integer,Integer> identifyNum = Function.identity();
        System.out.println(identifyNum.apply(101));


    }
}
