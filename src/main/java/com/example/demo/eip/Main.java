package com.example.demo.eip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/5/28 14:04
 */
public class Main {

    public static void main(String[] args) {
        List<DataModel> list = new ArrayList<>();
//        list.add(new DataModel("330100",2,1));
//        list.add(new DataModel("330102",2,1));
//        list.add(new DataModel("330103",5,1));
//        list.add(new DataModel("330104",2,1));
//        list.add(new DataModel("330203",3,1));
//        list.add(new DataModel("330204",5,1));
//        list.add(new DataModel("330206",1,1));
//        list.add(new DataModel("330300",3,2));
//        list.add(new DataModel("330307",4,1));
//        list.add(new DataModel("330308",4,1));
//        list.add(new DataModel("330309",8,1));
//        list.add(new DataModel("330400",5,1));
//        list.add(new DataModel("330482",6,1));
//        list.add(new DataModel("330481",4,1));
//        list.add(new DataModel("330489",9,1));
//        list.add(new DataModel("330488",7,1));

        List<String> code = new ArrayList<>();
        code.add("330100");
        code.add("330102");
        code.add("330103");
        code.add("330104");
        code.add("330200");
        code.add("330203");
        code.add("330204");
        code.add("330206");
        code.add("330300");
        code.add("330307");
        code.add("330308");
        code.add("330309");
        code.add("330400");
        code.add("330482");
        code.add("330481");
        code.add("330489");
        code.add("330488");
        Map<String,DataModel> map2 = list.stream().collect(Collectors.toMap(DataModel::getQydm,v->v));
        HashMap<String, List<DataModel>> map =list.stream().collect(Collectors.groupingBy(k -> k.getQydm() .substring(0,4),
                HashMap::new, Collectors.toList()));
        HashMap<String, DataModel> map1 = new HashMap<>();
        for (Entry<String, List<DataModel>> entry : map.entrySet()) {
            List<DataModel> value = entry.getValue();
            map1.put(entry.getKey()+"00",value.stream().reduce((x,y) -> x.add(y)).get());
        }

        List<DataModel> list2 = new ArrayList<>();
        DataModel total = new DataModel();
        total.setQydm("000000");
        list2.add(total);
        DataModel model = null;
        for (String s : code){
           model = new DataModel();
           model.setQydm(s);
           if (!map2.containsKey(s)){
               model.setQydm(s);
               model.setJcsl(0);
               model.setGlsl(0);
               model.setResult();
           } else if (s.endsWith("00")){
               DataModel model1 = map1.get(s);
               model.setGlsl(model1.getGlsl());
               model.setJcsl(model1.getJcsl());
               model.setResult();
           }else{
               model  = map2.get(s);
               model.setResult();
           }
            total.add2(model);
            total.setResult();
            list2.add(model);
        }
        list2.forEach(System.out::println);
    }
}
