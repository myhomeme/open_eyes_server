package com.sitech.paas.admin.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 测试controller
 *
 * @author huangzb
 * @date 2022/4/24
 */
@Api("测试controller")
@RestController
@RequestMapping("test")
public class MyTestController {

    @RequestMapping("hello")
    public String testMethod() {
        return "Hello World!";
    }

    @RequestMapping("exception")
    public int getException() {
        HashMap<String, Integer> map = new HashMap<>(8);
        map.put("1", 1);
        map.put("2", 0);
        return map.get("1") / map.get("2");
    }

    @RequestMapping("myException")
    public int myException() {
        int i;
        try {
            HashMap<String, Integer> map = new HashMap<>(8);
            map.put("1", 1);
            map.put("2", 0);
            i = map.get("1") / map.get("2");
        } catch (Exception e) {
            throw new RuntimeException("除数为0了!");
        }
        return i;
    }


    /**
     * 文件下载实例接口
     * @param response 响应数据流
     * @throws IOException 此类是由失败或中断的 I/O 操作产生的一般异常类
     */
    @RequestMapping("download")
    public void myDownload(HttpServletResponse response) throws IOException {
        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //out为OutputStream，需要写出到的目标流
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=test.xls");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

}
