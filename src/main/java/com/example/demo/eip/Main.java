package com.example.demo.eip;

import com.example.demo.util.clazz.DtoToMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/28 14:04
 */
public class Main {

    public static void main(String[] args) {
        List<DataModel> list = new ArrayList<>();
        list.add(new DataModel("330100", 2, 1, 2, 1));
        list.add(new DataModel("330102", 2, 1, 2, 1));
        list.add(new DataModel("330103", 2, 1, 2, 1));
        list.add(new DataModel("330203", 2, 1, 2, 1));
        list.add(new DataModel("330204", 2, 1, 2, 1));
        list.add(new DataModel("330300", 2, 1, 2, 1));
        list.add(new DataModel("330307", 2, 1, 2, 1));
        list.add(new DataModel("330308", 2, 1, 2, 1));

        List<DataModel> list1 = new ArrayList<>();
        list1.add(new DataModel("330100", 3, 1));
        list1.add(new DataModel("330103", 2, 1));
        list1.add(new DataModel("330203", 2, 1));
        list1.add(new DataModel("330307", 2, 1));

        List<String> code = Arrays.asList("330100", "330102", "330103", "330200", "330203", "330204", "330206", "330300", "330307", "330308");

        Map<String, DataModel> map2 = list.stream().collect(Collectors.toMap(DataModel::getQydm, v -> v));
        list1.forEach(e -> {
            if (map2.containsKey(e.getQydm())) {
                map2.get(e.getQydm()).add(e);
            }
        });
        HashMap<String, List<DataModel>> map = list.stream().collect(Collectors.groupingBy(k -> k.getQydm().substring(0, 4),
                HashMap::new, Collectors.toList()));
        HashMap<String, DataModel> map1 = new HashMap<>();
        for (Entry<String, List<DataModel>> entry : map.entrySet()) {
            List<DataModel> value = entry.getValue();
            DataModel temp = new DataModel();
            value.forEach(e -> temp.add2(e));
            //  DataModel model = value.stream().reduce((x, y) -> x.add3(y)).get();
            //map1.put(entry.getKey()+"00",value.stream().reduce((x,y) -> x.add(y)).get());
            map1.put(entry.getKey() + "00", temp);
        }

        List<DataModel> list3 = new ArrayList<>();
        DataModel total = new DataModel();
        total.setQydm("000000");
        total.setQydmName("总计");
        list3.add(total);
        DataModel model = null;
        for (String s : code) {
            if (!map2.containsKey(s) && !map1.containsKey(s)) {
                model = new DataModel(s, 0, 0, 0, 0, 0, 0);
                model.setZj();
                model.setKpzj();
            } else if (s.endsWith("00")) {
                DataModel model1 = map1.get(s);
                model = new DataModel(model1);
                model.setZj();
                model.setKpzj();
                total.add2(model);
                total.setZj();
                total.setKpzj();
            } else {
                model = map2.get(s);
                model.setZj();
                model.setKpzj();
            }
            model.setQydm(s);
            model.setQydmName(QymcNameEnum.getNameByCode(s));
            list3.add(model);
        }
        list3.forEach(System.out::println);

        List<Map<String, Object>> mapList = new ArrayList<>();
        List<String> fileName = new ArrayList<String>();
        fileName.add("qydm");fileName.add("qydmName");
        fileName.addAll(DanWeiEnum.getNameByCode("0"));
        fileName.addAll(DanWeiEnum.getNameByCode("2"));
        for (DataModel m : list3) {
            Map map3 = DtoToMap.dtoToMap(m,fileName);
            mapList.add(map3);
        }
        System.out.println("========================================================================================");
        for (Map p : mapList) {
            System.out.print(p);
            System.out.println(p.get("qydm"));
        }
    }
}
