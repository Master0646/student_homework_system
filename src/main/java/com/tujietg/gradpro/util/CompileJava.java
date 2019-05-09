package com.tujietg.gradpro.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * 
 * Created by tujietg on Apr 21, 2019
 */
public class CompileJava {
	
	public void CompileJavaMethod(String fileName) {
		try {
			// 获取一个线程，这个线程可以和操作系统的命令行进行交互。
			Runtime rt = Runtime.getRuntime();
			// windowscd /Users/tujietg/Desktop/ && java HelloWorld
			String command = "javac " + "Task.java";
			// 调用命令行执行命令
			Process proc = rt.exec(command, null, new File(new Constant().rootDir));
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("<ERROR>");
			while ((line = br.readLine()) != null)
				System.out.println(line);
			System.out.println("</ERROR>");
			// int exitVal = proc.waitFor();
			// System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
