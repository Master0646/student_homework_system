package com.tujietg.gradpro.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Created by tujietg on Apr 17, 2019
 */
@Controller
public class CodeReview {

	@RequestMapping(value = "/CodeReview")
	public void tempDownLoad(HttpServletRequest request, HttpServletResponse response) {

		InputStream in = null;
		try {
			in = new FileInputStream(
					"/Users/tujietg/java/Eclipse-WorkSpace-dxMall/shw/201402021420天天数据结构与算法第二次作业.java");
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			do {
				bytesRead = in.read(buffer, 0, buffer.length);
				response.getOutputStream().write(buffer, 0, bytesRead);
			} while (bytesRead == buffer.length);

		} catch (Exception e) {

		} finally {
			try {
				if (in != null) {
					in.close();
				}
				response.getOutputStream().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
