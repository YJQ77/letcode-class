package com.example.demo.util;

import com.example.demo.eip.DanWeiEnum;
import com.example.demo.eip.DataModel;
import io.swagger.models.auth.In;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.util.List;
import java.util.Map;

/**
 * 描述： excle工具类
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


    /**
     * 根据标题内容数据返回excle文件
     *
     * @param sheetName
     * @param title
     * @param dataList
     * @param wb
     * @return
     */
    public static SXSSFWorkbook getSXSSFWorkbook(String sheetName, String[] title, List<Map<String, Object>> dataList, SXSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new SXSSFWorkbook();
        }
        //第二步，创建一个sheet
        SXSSFSheet sheet = wb.createSheet(sheetName);
        //第三步，创建一个row
        SXSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        //声明列对象
        SXSSFCell cell = null;
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

    public static SXSSFWorkbook getSXSSFWorkbook2(String sheetName, String[] title, List<DataModel> dataList, SXSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new SXSSFWorkbook();
        }
        //第二步，创建一个sheet
        SXSSFSheet sheet = wb.createSheet(sheetName);
        //第三步，创建一个row
        SXSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        //声明列对象
        SXSSFCell cell = null;
        //创建标题
        cell = row.createCell(0);
        cell.setCellValue("区域");
        cell.setCellStyle(style);

        CellRangeAddress region = null;
        region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);

        //第三步，创建一个row
        SXSSFRow row2 = sheet.createRow(1);
        int k = 1;
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(k);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);

            row2.createCell(k).setCellValue("开通单位数");
            row2.createCell(k+1).setCellValue("开票单位数");
            row2.createCell(k+2).setCellValue("开票占开通占比");

            region = new CellRangeAddress(0, 0, k, k+2);
            sheet.addMergedRegion(region);
            k= k+3;
        }


        //创建内容
        DataModel map = null;
        for (int j = 0; j < dataList.size(); j++) {
            map = dataList.get(j);
            row = sheet.createRow(j + 2);
            row.createCell(0).setCellValue(map.getQydmName());


            row.createCell(1).setCellValue(map.getZj());
            row.createCell(2).setCellValue(map.getKpzj());
            row.createCell(3).setCellValue(DataModel.jisuan(map.getZj(),map.getKpzj()));

            row.createCell(4).setCellValue(map.getGlsl());
            row.createCell(5).setCellValue(map.getKpglsl());
            row.createCell(6).setCellValue(DataModel.jisuan(map.getGlsl(),map.getKpglsl()));

            row.createCell(7).setCellValue(map.getJcsl());
            row.createCell(8).setCellValue(map.getKpjcsl());
            row.createCell(9).setCellValue(DataModel.jisuan(map.getJcsl(),map.getKpjcsl()));

            row.createCell(10).setCellValue(map.getXzdw());
            row.createCell(11).setCellValue(map.getKpxzdw());
            row.createCell(12).setCellValue(DataModel.jisuan(map.getXzdw(),map.getKpxzdw()));

        }
        return wb;
    }


    public static SXSSFWorkbook getSXSSFWorkbook3(String sheetName, String[] title, List<Map<String,Object>> mapList, SXSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new SXSSFWorkbook();
        }
        //第二步，创建一个sheet
        SXSSFSheet sheet = wb.createSheet(sheetName);
        //第三步，创建一个row
        SXSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        //声明列对象
        SXSSFCell cell = null;
        //创建标题
        cell = row.createCell(0);
        cell.setCellValue("区域");
        cell.setCellStyle(style);

        CellRangeAddress region = null;
        region = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(region);

        //第三步，创建一个row
        SXSSFRow row2 = sheet.createRow(1);
        int k = 1;
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(k);
            cell.setCellValue(DanWeiEnum.getValueByCode(title[i]));
            cell.setCellStyle(style);

            row2.createCell(k).setCellValue("开通单位数");
            row2.createCell(k+1).setCellValue("开票单位数");
            row2.createCell(k+2).setCellValue("开票占开通占比");

            region = new CellRangeAddress(0, 0, k, k+2);
            sheet.addMergedRegion(region);
            k= k+3;
        }
        //创建内容
        Map<String,Object> map = null;
        for (int j = 0; j < mapList.size(); j++) {
            map = mapList.get(j);
            row = sheet.createRow(j + 2);
            row.createCell(0).setCellValue(map.get("qydmName").toString());
            int index = 1;
            for (String s : title){
                Integer count1 = Integer.parseInt(map.get(DanWeiEnum.getNameByCode(s).get(0)).toString());
                Integer count2 = Integer.parseInt(map.get(DanWeiEnum.getNameByCode(s).get(1)).toString());

                row.createCell(index).setCellValue(count1);
                row.createCell(index+1).setCellValue(count2);
                row.createCell(index+2).setCellValue(DataModel.jisuan(count1,count2));
                index = index+3;
            }
        }
        return wb;
    }
}
