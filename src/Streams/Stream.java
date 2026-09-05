package Streams;

import java.util.List;
import java.util.Optional;

public class Stream
{
    public static  void  main(String[] args)
    {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        List<Integer> even = nums.stream().filter(n->n%2 == 0).toList();
        List<Integer> sort = nums.stream().sorted( ((a,b)->b-a) ).toList();
        int sum = nums.stream().reduce(0, (a,b)->a+b);
        Optional<Integer> max = nums.stream().max((a, b)->a.compareTo(b));
        Optional<Integer> min = nums.stream().min((a, b)->a.compareTo(b));

        List<String> words = List.of("hello", "world", "java");
        List<Integer> len = words.stream().map(a->a.length()).toList();

        List<List<Integer>> nested = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );
        List<Integer> flat = nested.stream().flatMap(a->a.stream()).toList();

//to create use collection_name.strram()
// intermediate operations: filer,map,flatMap,sort
// terminal opertaion: toList(),max(),min(),reduce(),toArray()
    }
}
