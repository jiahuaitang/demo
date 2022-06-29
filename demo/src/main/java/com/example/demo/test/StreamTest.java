package com.example.demo.test;

import com.example.demo.entity.StandaryEntity;
import com.example.demo.vo.StandaryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        //StreamTest.demo1();
        //StreamTest.demo2();
        //StreamTest.demo3();
        //StreamTest.demo4();
        //StreamTest.demo5();
        //StreamTest.demo6();
        //StreamTest.demo7();
        //StreamTest.demo8();
        //StreamTest.demo9();
        //StreamTest.demo10();
        //StreamTest.demo11();
        //StreamTest.demo12();
        //StreamTest.demo13();
        //StreamTest.demo14();
        //StreamTest.demo15();
        //StreamTest.demo16();
        //StreamTest.demo17();
        //StreamTest.demo18();
        //StreamTest.demo19();
        StreamTest.demo20();


    }
    public static void demo20(){
        int[] arr = {1,2,3};
        StandaryEntity standary1 = new StandaryEntity();
        standary1.setId(1);
        standary1.setName("ces");
        StandaryEntity standary2 = new StandaryEntity();
        standary2.setId(2);
        standary2.setName("ces");
        StandaryEntity standary3 = new StandaryEntity();
        standary3.setId(3);
        standary3.setName("ces");
        StandaryEntity standary4 = new StandaryEntity();
        standary4.setId(4);
        standary4.setName("ces");
        List<StandaryEntity> list = new ArrayList<>();
        list.add(standary1);
        list.add(standary2);
        list.add(standary3);
        list.add(standary4);

        List<StandaryVo> ll = null;

        ll = list.stream().filter(a -> {
            boolean status = true;
            for (int i = 0; i < arr.length; i++) {
                if (a.getId() == arr[i]) {
                    status = false;
                }
                if (!status) {
                    return status;
                }
            }
            return status;
        }).flatMap(air -> {
                    StandaryVo s = new StandaryVo();
                    s.setId(air.getId());
                    s.setName(air.getName());
                    return s;
                }
        ).collect(Collectors.toList());
        System.out.println(ll);







    }

    public static void demo19(){
        String[] arr = {"123","32131","sdad"};
        List<String> ints = Arrays.asList(arr);
        Map<String, List<String>> collect = ints.stream().collect(Collectors.groupingBy(String::valueOf));
        System.out.println(collect);

    }

    public static void demo18(){
        String str = "abcdef";
        String[] split = str.split("");
        Stream<String> sorted = Arrays.asList(split).stream().sorted(Comparator.reverseOrder());
        System.out.println(Arrays.toString(sorted.toArray()));

    }

    public static void demo17(){
        String[] arr = {"123","32131","sdad"};
        List<String> ints = Arrays.asList(arr);
        String reduce = ints.stream().reduce("1", String::join);
        System.out.println(reduce);

    }

    public static void demo16(){
        Integer[] arr = {1,23};
        List<Integer> ints = Arrays.asList(arr);
        Integer reduce = ints.stream().reduce( 1,Integer::compareTo);
        System.out.println(reduce);

    }

    public static void demo15(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Optional<Integer> any = ints.parallelStream().filter(i->i<10).findAny();
        System.out.println(any);

    }

    public static void demo14(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Optional<Integer> first = ints.stream().filter(i -> i < 1).sorted(Comparator.reverseOrder()).findFirst();
        System.out.println(first.orElse(-1));

    }

    public static void demo13(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> stream = ints.stream();
        long count = stream.count();
        System.out.println(count);

    }
    public static void demo12(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> stream = ints.stream();
        if(stream.noneMatch(i->i>30)){
            System.out.println("123");
        }else{
            System.out.println("4");
        }

    }

    public static void demo11(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> stream = ints.stream();
        if(stream.anyMatch(i->i==4)){
            System.out.println("123");
        }else{
            System.out.println("4");
        }

    }

    public static void demo10(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> stream = ints.stream();
        if(stream.allMatch(i->i>3)){
            System.out.println("123");
        }else{
            System.out.println("4");
        }

    }

    public static void demo9(){
        List<String> list = Arrays.asList("123","cess","321 123");
        //List<String> collect = list.stream().map(i -> i.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        Stream<String> stringStream = list.stream().map(i -> i.split(" ")).flatMap(Arrays::stream);
        System.out.println(Arrays.toString(stringStream.toArray()));

    }

    public static  void demo1(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> stream = ints.stream();
        Stream<Integer> distinct = stream.distinct();
        System.out.println(Arrays.toString(distinct.toArray()));
    }
    public static void demo2(){
        int[] arr = {1,23,4,5,6,7,8,1,2};
        IntStream stream = Arrays.stream(arr);
        IntStream distinct = stream.distinct();
        System.out.println(Arrays.toString(distinct.toArray()));

    }

    public static void demo3(){
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(5);
        Stream<Integer> distinct = limit.distinct();
        System.out.println(Arrays.toString(distinct.toArray()));

    }
    public static void demo4(){
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
        Stream<Double> distinct = limit.distinct();
        System.out.println(Arrays.toString(distinct.toArray()));

    }

    public static void demo5(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> integerStream = ints.stream().filter(i -> !ObjectUtils.isEmpty(i) && i > 4);
        System.out.println(Arrays.toString(integerStream.toArray()));

    }
    public static void demo6(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> integerStream = ints.stream().filter(i -> !ObjectUtils.isEmpty(i) && i > 4).sorted(Comparator.reverseOrder()).limit(1);
        System.out.println(Arrays.toString(integerStream.toArray()));

    }

    public static void demo7(){
        Integer[] arr = {1,23,4,5,6,7,8,1,2};
        List<Integer> ints = Arrays.asList(arr);
        Stream<Integer> integerStream = ints.stream().skip(2);
        System.out.println(Arrays.toString(integerStream.toArray()));

    }

    public static void demo8(){
        List<String> list = Arrays.asList("123","cess","3121");
        List<Integer> collect = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));

    }


}
