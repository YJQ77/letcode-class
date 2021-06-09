package com.example.demo.service;

import com.example.demo.eip.DataModel;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/7 9:57
 */
public interface DataModelService {
    List<DataModel> getList();

    List<Map<String,Object>> getMap();

    List<Map<String,Object>> getMap2();
}
