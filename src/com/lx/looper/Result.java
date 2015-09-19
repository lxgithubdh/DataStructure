package com.lx.looper;

/**
 * 结果信息
 * Created by lx on 2015/9/19.
 */
public class Result {


    //结果码
    private int code;
    //结果内容
    private String content;


    public Result(int code,String content){
        this.code = code;
        this.content = content;
    }


    public int getCode() {
        return code;
    }


    public String getContent() {
        return content;
    }


    @Override
    public String toString(){
        return "Code is :"+code+",Content is :"+content;
    }
}
