package com.example.demo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class MyUser extends BaseRowModel {
    @ColumnWidth(20)
    @ExcelProperty(value = "名字", index = 0)
    private String name;

    @NumberFormat("#.#####%")
    @ColumnWidth(40)
    @ExcelProperty(value = "年龄", index = 1)
    private Double age;

    @ColumnWidth(80)
    @ExcelProperty(value = "邮箱", index = 2)
    private String email;
}
