package com.example.demo.service;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.demo.dto.MyUser;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportFileService {

    public void exportExcel(HttpServletResponse response) {
        List<MyUser> dataList = new ArrayList<>();

        MyUser user1 = new MyUser();
        MyUser user2 = new MyUser();
        MyUser user3 = new MyUser();

        user1.setName("张一");
        user2.setName("王二");
        user3.setName("李三");

        user1.setAge(10.10);
        user2.setAge(20.0001);
        user3.setAge(3.02);

        user1.setEmail("18867139077@163.com");
        user2.setEmail("3150103635@zju.edu.cn");
        user3.setEmail("123132215465");

        dataList.add(user1);
        dataList.add(user2);
        dataList.add(user3);

        try {
            String fileName = URLEncoder.encode("询价", "UTF-8");
            //String fileName = new String("导出".getBytes("GBK"), "ISO8859-1");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

            Sheet sheet = new Sheet(1, 0, MyUser.class);

            writer.write(dataList, sheet);

            writer.finish();

            out.close();

        } catch (Exception e) {

        }




    }

}
