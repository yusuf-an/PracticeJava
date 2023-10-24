package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //Empty streams
//        Stream<String> streamEmpty = Stream.empty();
//        //to avoid the following
//        /*
//        * public Stream<String> streamOf(List<String> list) {
//                return list == null || list.isEmpty() ? Stream.empty() : list.stream();
//         }
//        * */
//
//
//        //Stream of collection
//        Collection<String> list = Arrays.asList("A", "B", "C");
//
//        //Stream.builder()
//        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();


        // primitive: count(), max(), min(), and sum()


        method1();
        method2();
        method3();
        method4();
        method5();
        method6();
        method7();
        method8();
        method9();
        method10();
        method11();

    }

    /*
     * Write a Java program to calculate the average of a list of integers using streams.
     * */
    public static void method1() {
        double data = getIntegerList().stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        printValue(data);
    }

    /*
     * 2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
     * */

    public static void method2() {
        List<String> out = getStringList().stream().map(a -> a.toUpperCase()).collect(Collectors.toList());
        printValue(out);
    }

    /**
     * 3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
     */
    public static void method3() {
        int out = getIntegerList().stream().filter(a -> a % 2 == 0).mapToInt(Integer::intValue).sum();
        printValue(out);
    }

    /**
     * 4. Write a Java program to remove all duplicate elements from a list using streams.
     */
    public static void method4() {
        List out = getIntegerList().stream().distinct().collect(Collectors.toList());
        printValue(out);
    }

    /**
     * 5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.
     */
    public static void method5() {

    }

    /**
     * 6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
     */
    public static void method6() {
        List<String> asc = getStringList().stream().sorted().collect(Collectors.toList());
        printValue(asc);
        List<String> desc = getStringList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        printValue(desc);

        List<Customer> list1 = getCustomerList().stream().sorted(Comparator.comparingInt(Customer::getAge)).collect(Collectors.toList());
        printValue(list1);
        List<Customer> list2 = getCustomerList().stream().sorted(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if (o1.getAge() == o2.getAge()) {
                    return o1.getName().compareTo(o2.getName());
                } else return o1.getAge() - o2.getAge();
            }
        }).collect(Collectors.toList());
        printValue(list2);
    }

    /**
     * 7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
     */
    public static void method7() {
        //or .max(Integer::compare)
        int count = getIntegerList().stream().max((o1, o2) -> o1.compareTo(o2)).orElse(0);
        System.out.println(count);
    }

    /**
     * 8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
     */
    public static void method8() {
        Integer a = getIntegerList().stream().distinct().sorted(Integer::compare).skip(1).findFirst().orElse(null);
        printValue(a);
        Integer b = getIntegerList().stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        printValue(b);
    }

    /**
     * Print pattern using stream
     */
    public static void method9() {
        int N = 5;
        IntStream.range(0, N).forEach(
                row -> {
                    IntStream.range(0, row).forEach(column -> System.out.print("*"));
                    System.out.println();
                }
        );
    }

    public static void method10() {
        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> longestString = words.stream()
                .reduce((word1, word2)
                        -> word1.length() > word2.length()
                        ? word1 : word2);

        // Displaying the longest String
        longestString.ifPresent(System.out::println);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        String[] array = { "Geeks", "for", "Geeks" };

        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> String_combine = Arrays.stream(array)
                .reduce((str1, str2)
                        -> str1 + "-" + str2);

        // Displaying the combined String
        if (String_combine.isPresent()) {
            System.out.println(String_combine.get());
        }

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Creating list of integers
        List<Integer> array1 = Arrays.asList(-2, 0, 4, 6, 8);

        // Finding sum of all elements
        int sum = array1.stream().reduce(0,
                (element1, element2) -> element1 + element2);

        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);





        //++++++++++++++++++++++++++++++++

        // To get the product of all elements
        // in given range excluding the
        // rightmost element
        int product = IntStream.range(2, 8)
                .reduce((num1, num2) -> num1 * num2)
                .orElse(-1);

        // Displaying the product
        System.out.println("The product is : " + product);
    }

    public static void method11() {
        Map<Object, List<Customer>> list=getCustomerList().stream().collect(Collectors.groupingBy(s->s.getAge()));
        printValue(list);

        Map<Object, Long> list1=getCustomerList().stream().collect(Collectors.groupingBy(s->s.getName(),Collectors.counting()));
        printValue(list1);
    }

    public static List<Integer> getIntegerList() {
        List<Integer> input = Arrays.asList(2, 4, 6, 8, 10, 12, 1, 3, 5, 7, 7, 3, 6);
        System.out.println("input: ");
        System.out.println(input);
        return input;
    }


    public static List<String> getStringList() {
        List<String> input = Arrays.asList("Apple", "Banana", "Peach", "Reddish", "Cat", "Cow");
        System.out.println("input: ");
        System.out.println(input);
        return input;
    }

    public static List<Customer> getCustomerList() {
        List<Customer> createdInput = Arrays.asList(new Customer("Amanda", 20, "Delhi"), new Customer("Bhuvan", 19, "Delhi"), new Customer("Dinesh", 20, "Noida"), new Customer("Gaurav", 23, "Noida"));
        System.out.println("input: ");
        System.out.println(createdInput);

        Stream<Customer> count=createdInput.stream().distinct();
        return createdInput;
    }

    public static void printValue(Object objectToPrint) {
        System.out.println("result: ");
        System.out.println(objectToPrint);
    }


}

class Customer {
    private String name;
    private int age;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age, this.city);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) return false;

        if (!(obj instanceof Customer)) {
            return false;
        }

        Customer c = (Customer) obj;

        return c.getAge() == this.getAge() && c.getCity() == this.city && c.getName() == this.getCity();
    }
}
