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
			Runtime rt = Runtime.getRuntime();
			// windowscd /Users/tujietg/Desktop/ && java HelloWorld
			String command = "javac " + "Task.java";
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
