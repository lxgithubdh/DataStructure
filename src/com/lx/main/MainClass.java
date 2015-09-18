package com.lx.main;


import com.lx.runtime.Compiler;

import java.io.File;

/**
 * 运行入口
 * @author lx
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        File file = new File("d:\\ValueClass.java");
        Compiler compiler = new Compiler();
        try {
            compiler.compile(file);
            String result = compiler.run("com.test.ValueClass");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
