package Jav8;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    void printAvg(findAvg avg,int []arr){
        System.out.println("Without avg: "+ avg.getAvg(arr));
    }

    public static void main(String[] args) {
        int[] arr = {23,11,22,32,65,89};
        IntStream res = Arrays.stream(arr);
        float first = (float)res.average().getAsDouble();

        findAvg second = arr1 -> { float res1 = 0; for(int i:arr1){
        res1 = res1+i;
        }
        return res1/arr1.length;
        };

        new Main().printAvg(second,arr);

        System.out.println("With avg: "+first +"\nNumber of n = 0: "+ Arrays.stream(arr).filter(value -> value ==0).count() + "\nNumber of n > 0: "+
                Arrays.stream(arr).filter(value -> value > 0).count());
        Arrays.stream(arr).map(operand -> operand *2).forEach(System.out::println);

        System.out.println(IntStream.range(0,arr.length).mapToObj(index -> String.format("%d -> %s",arr[index],
                index)).min((o1, o2) -> o1.compareTo(o2)));
    }
}

@FunctionalInterface
interface findAvg{
     float getAvg(int[] arr);


}
