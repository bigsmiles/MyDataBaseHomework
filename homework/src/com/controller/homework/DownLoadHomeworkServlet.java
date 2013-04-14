package com.controller.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DownLoadHomeworkServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {


		String aFileName = new String(request.getParameter("homeworkfilename").getBytes(
				"iso8859-1"), "gbk");

		File fileLoad = new File("d:/Eclipse/work/homework/web/homework", aFileName);

		FileInputStream in = null; //  ‰»Î¡˜
		OutputStream out = response.getOutputStream();
		byte b[] = new byte[1024];

		try {

			 response.setContentType("application/x-msdownload;");

			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(aFileName.getBytes("GBK"), "ISO-8859-1"));

			// download the file.
			in = new FileInputStream(fileLoad);
			int n = 0;
			while ((n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

}
