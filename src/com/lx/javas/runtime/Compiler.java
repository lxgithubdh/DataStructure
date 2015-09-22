package com.lx.javas.runtime;

import java.io.*;

/**
 * 简单的java编译器
 * Created by lx on 2015/9/18.
 */
public class Compiler {


    //java程序运行环境
    Runtime runtime;


    public Compiler(){
        runtime = Runtime.getRuntime();
    }


    /**
     * 编译
     * @param resource 源文件路径
     * @Exception 编译失败
     */
    public void compile(File resource) throws Exception {
        String path = resource.getAbsolutePath();
        String command = "javac -d bin\\ " + path;       //-d path 将class文件放在path目录下
        Process process = runtime.exec(command);      //获取执行进程
        process.waitFor();             //等待进程执行结束
        int resultCode = process.exitValue();         //获取进程执行结果，0表示正常结束
        if(resultCode!=0){
            InputStream errorMsg= process.getErrorStream();  //获取错误输入流
            String error = getResult(errorMsg);
            throw new Exception(error);        //抛出异常信息
        }
    }


    /**
     * 运行class文件
     * @param className 类名
     * @throws Exception  运行异常
     * @return 运行结果
     */
    public String run(String className) throws Exception{
        String result = null;
        String command = "java " + className;  //运行class文件，必须带包名
        File curDir = new File("bin");        //运行目录
        Process process = runtime.exec(command,null,curDir);  //获取运行进程
        process.waitFor();          //等待进程运行结束
        int resultCode = process.exitValue();
        if(resultCode==0){
            result = getResult(process.getInputStream());
        }else {
            throw new Exception(getResult(process.getErrorStream()));
        }
        return result;
    }


    /**
     * 获取输入流信息
     * @param is 输入流
     * @return  信息
     * @throws IOException
     */
    private String getResult(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"gbk"));
        String temp;
        StringBuffer result = new StringBuffer();
        while(null!=(temp = reader.readLine())){
            result.append(temp);
        }
        return result.toString();
    }
}
