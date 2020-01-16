package com.github.lyrric;

import com.github.lyrric.util.DocUtil;

import java.io.IOException;

/**
 * Created on 2018/6/6.
 *
 * @author wangxiaodong
 */

public class Application {


    public static void main(String[] args) throws IOException {
        DocUtil.generator("d:/"+ System.currentTimeMillis()+".doc");
        //这个example.html 放在resources 下面.这样机会生成一个result.html文件,结果都已经放进去了
    }
}
