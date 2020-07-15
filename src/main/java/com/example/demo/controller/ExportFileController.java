package com.example.demo.controller;

import com.example.demo.service.ExportFileService;
import com.example.demo.util.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "ExportFile Controller")
@RestController
@RequestMapping("pub/test/export")
public class ExportFileController {

    @Autowired
    private ExportFileService service;
    
    @ApiOperation(value = "excel", tags = "excel")
    @GetMapping("/excel")
    public ResponseBase exportExcel(HttpServletResponse response) throws IOException {

        service.exportExcel(response);

        return new ResponseBase("200", "OK");
    }

}
