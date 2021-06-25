package com.example.demo.util.clazz;


import com.example.demo.eip.DataModel;
import com.example.demo.elsfk.fk.L;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/4 14:24
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<ClassData> list = new LinkedList<>();
        List<String> list1 = Arrays.asList("3301","3303");
        list.add(new ClassData("3301", 1));
        list.add(new ClassData("3302", 1));
        list.add(new ClassData("3303", 1));
        Map<String, ClassData> collect = list.stream().collect(Collectors.toMap(ClassData::getClassCode, v -> v));
        List<ClassData> result = new ArrayList<>();
        for (String s : list1) {
            ClassData data = collect.get(s);
            if (data == null) {
                data = new ClassData(s, 0);
            }
            if (s.equals("3301")) {
                data.add(Optional.ofNullable(collect.get("3302")).orElse(new ClassData(s, 0)));
            }
            result.add(data);
        }
     Object o = null;
        String s = o.toString();
        result.forEach(System.out::println);
    }

}
