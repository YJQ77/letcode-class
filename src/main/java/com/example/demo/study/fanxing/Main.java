package com.example.demo.study.fanxing;

import com.example.demo.elsfk.fk.L;
import com.example.demo.study.fanxing.FanXing;
import com.example.demo.study.fanxing.Student;
import com.example.demo.study.fanxing.Teacher;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/3/30 16:31
 */
public class Main {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDate.parse("2021-02-28").atStartOfDay().plusDays(-1);
        System.out.println(localDateTime);
        Student student = new Student();
        Student student1 = FanXing.setName(student);
        System.out.println(student1.getName());

        Calendar instance = Calendar.getInstance();
        int currentYear = instance.get(Calendar.YEAR);
        instance.add(Calendar.YEAR, -3);
        Date time = instance.getTime();
        String format = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(time);
        System.out.println(format);

        Teacher teacher = new Teacher();
        Teacher teacher1 = FanXing.setName(teacher);
        System.out.println(teacher1.getName());

        Map<String, Object> map = new HashMap<>();
        map.put("name", "haha");
        Map<String, Object> map1 = FanXing.setName(map);
        System.out.println(map1.get("name"));

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "yinjiaqi", 30));
        list.add(new Student(2, "yinjiaqi2", 40));
        list.add(new Student(3, "yinjiaqi", 50));
        list.add(new Student(4, "yinjiaqi2", 30));
        list.add(new Student(5, "yinjiaqi", 60));
        List<Student> list2 = new ArrayList<>();
        Supplier<TreeMap> supplier = () -> new TreeMap<String, List<Student>>((k1, k2) -> k2.compareTo(k1));
        TreeMap<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(o -> (o.getName()), supplier, Collectors.toList()));
        collect.forEach((key, value) -> {
            value.stream().reduce((a, b) -> new Student(a.getId() + b.getId(), a.getName(), a.getSocre() + b.getSocre())).ifPresent(list2::add);
        });
        list2.forEach(System.out::println);

        Collection<Student> collect1 = list.stream()
                .collect(Collectors.toMap(Student::getName,
                        Function.identity(), (oldVal, newVal) -> newVal)).values();
        collect1.forEach(System.out::println);

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> newList = Arrays.asList(6,7,9,8,7,5);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(newList);
        linkedList.addAll(numList);
        linkedList.forEach(System.out::println);



        int result = numList.stream().reduce(1, (a, b) -> a + b);
        System.out.println(result);

        List<Integer> numList2 = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        String result2 = numList2.stream().reduce("", (a, b) -> a + b, (a, b) -> "");
        System.out.println(result2);
    }
}
