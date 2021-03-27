package com.example.demo.util;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.util.List;
import java.util.Map;

/**
 * 描述：
 * excle工具类
 *
 * @author yinjiaqi
 * @date 2021/3/26 9:10
 */
public class ExcleUtil {
    /**
     * 根据标题内容数据返回excle文件
     *
     * @param sheetName
     * @param title
     * @param dataList
     * @param wb
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook(String sheetName, String[] title, List<Map<String, Object>> dataList, XSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new XSSFWorkbook();
        }
        //第二步，创建一个sheet
        XSSFSheet sheet = wb.createSheet(sheetName);
        //第三步，创建一个row
        XSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        //声明列对象
        XSSFCell cell = null;
        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //创建内容
        Map<String, Object> map = null;
        for (int j = 0; j < dataList.size(); j++) {
            map = dataList.get(j);
            row = sheet.createRow(j + 1);
            row.createCell(0).setCellValue(map.get("0").toString());
            row.createCell(1).setCellValue(map.get("1").toString());
            row.createCell(2).setCellValue(map.get("2").toString());
        }

        return wb;
    }
}
