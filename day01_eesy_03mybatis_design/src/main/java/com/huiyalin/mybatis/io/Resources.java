package com.huiyalin.mybatis.io;

import java.io.File;
import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入参数的类，获取一个字节输入流
     * @param File
     * @return
     */
    public static InputStream getResourceAsStream(String File){
        return Resources.class.getClassLoader().getResourceAsStream(File);
    }
}
