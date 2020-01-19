package com.github.lyrric.controller;

import com.github.lyrric.util.DocUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created on 2020-01-19.
 *
 * @author wangxiaodong
 */
@RestController
public class DocPdfController {

    /**
     * xml to doc
     */
    @GetMapping(value = "/doc")
    String downPdf(HttpServletResponse response){
        try {
            String fileName = System.currentTimeMillis()+".doc";
            DocUtil.generator(fileName);
            download(fileName, response);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return "doc生成失败";
        }
    }

    /**
     * html to df
     */
    @GetMapping(value = "/pdf")
    String downDoc(HttpServletResponse response){
        String fileName = System.currentTimeMillis()+".pdf";
        try {
            InputStream is = Runtime.getRuntime().exec("wkhtmltopdf http://localhost:8080/html "+ fileName).getErrorStream();
            String s = IOUtils.toString(is, StandardCharsets.UTF_8);
            is.close();
            System.out.println(s);
            download(fileName, response);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return "pdf生成失败";
        }
    }

    private void download(String fileName, HttpServletResponse response) throws IOException {
        File file = new File(fileName);
        char[] buf = IOUtils.toCharArray(new FileInputStream(file), StandardCharsets.ISO_8859_1);
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        response.setContentType("application/octet-stream");
        writer.write(buf);
        file.delete();
    }
}
