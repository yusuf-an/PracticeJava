package org.example.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //Empty streams
        Stream<String> streamEmpty = Stream.empty();
        //to avoid the following
        /*
        * public Stream<String> streamOf(List<String> list) {
                return list == null || list.isEmpty() ? Stream.empty() : list.stream();
         }
        * */


        //Stream of collection
        Collection<String> list =Arrays.asList("A","B","C");

        //Stream.builder()
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();


        // primitive: count(), max(), min(), and sum()

        

    }




}
