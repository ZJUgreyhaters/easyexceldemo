package com.example.demo.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.example.demo.dto.MyUser;
import com.example.demo.util.ResponseBase;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExportFileService {

    public void exportExcel(HttpServletResponse response) throws IOException {
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
            String fileName = URLEncoder.encode("test", "UTF-8");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            ServletOutputStream out = response.getOutputStream();
            EasyExcel.write(out, MyUser.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("sheet1")
                    .doWrite(dataList);

        } catch (Exception e) {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            ResponseBase res = new ResponseBase("400", "导出异常");
            response.getWriter().println(JSON.toJSONString(res.toString()));
        }
    }

}
