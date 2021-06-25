package com.example.demo.util.reconciliation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/6/24 15:36
 */
public class Reconciliation {

    public static void main(String[] args) {
        File file = new File("D:\\20210621\\");
        File[] files = file.listFiles();
        BufferedReader reader = null;//字符输入流进行读取操作读取
        String tempString = null;//每一行的内容
        InputStream intput = null;
        List<BillDto> list = new ArrayList<>();
        try {
            BillDto dto = null;
            for (File file1 : files) {
                intput = new FileInputStream(file1);
                reader = new BufferedReader(new InputStreamReader(intput));
                while ((tempString = reader.readLine()) != null) {
                    System.out.println(tempString);
                    String[] split = tempString.split("\\|\\|");
                    dto = new BillDto(split[0].trim(),split[1].trim(),Integer.parseInt(split[2].trim()),
                            split[3].trim(),split[4].trim(),split[5].trim(),split[6].trim(),
                            split[7].trim(),split[8].trim(),split[9].trim());
                    list.add(dto);
                }
            }
            list.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                reader.close();
                intput.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
