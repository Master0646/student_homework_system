package com.tujietg.gradpro.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class FileClassLoader extends ClassLoader {

	// class文件的目录
	private String rootDir = new Constant().rootDir;

	public FileClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] getClassData(String className) {

		String path = rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		try {
			InputStream ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getResult(String fileName) {

		FileClassLoader loader = new FileClassLoader(rootDir);
		Object a = null;
		String file = "Task";
		try {
			// 传入class文件的全限定名
			// 利用了反射加载的是 指定路径上的class 文件
			Class<?> clazz = loader.loadClass(file);
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("result", null);
			// 获取方法返回的结果
			a = (Object) method.invoke(obj, null);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return a;
	}

}