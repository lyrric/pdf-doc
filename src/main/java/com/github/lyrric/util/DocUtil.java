package com.github.lyrric.util;

import com.github.lyrric.entity.*;
import org.apache.commons.io.IOUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created on 2020-01-15.
 *
 * @author wangxiaodong
 */
public class DocUtil {

    private static TemplateEngine engine = new TemplateEngine();

    /**
     * 渲染
     * @return
     */
    public static void generator(String savePath) throws IOException {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        //模板所在目录，相对于当前classloader的classpath
        resolver.setPrefix("tpl/");
        //模板文件后缀
        resolver.setSuffix(".tpl");
        resolver.setTemplateMode(TemplateMode.HTML);
        TemplateEngine engine = new TemplateEngine();
        engine.addDialect(new Java8TimeDialect());
        engine.setTemplateResolver(resolver);
        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("credentials", Credential.getDefaultData());
        context.setVariable("educations", Education.getDefaultData());
        context.setVariable("jobs", Job.getDefaultData());
        context.setVariable("projects", Project.getDefaultData());
        User user = User.getDefaultData();
        user.setProfilePhoto(base64ImageByPath(user.getProfilePhoto()));
        context.setVariable("user", user);
        //渲染模板
        FileWriter writer = new FileWriter(savePath);
        engine.process("template",context, writer);
        writer.close();
    }

    /**
     * 将图片base64编码
     * @param imagePath 本地路径
     * @return
     * @throws IOException
     */
    private static String base64ImageByPath(String imagePath) throws IOException {
        InputStream is = DocUtil.class.getClassLoader().getResourceAsStream(imagePath);
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] data = IOUtils.toByteArray(is);
        is.close();
        return encoder.encode(data);
    }
}
