package com.controller.homework;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.action.homework.UpLoadAction;

public class UpLoadHomeworkServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	

	@SuppressWarnings("unchecked")
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		request.setCharacterEncoding("utf-8");
		
		String courseid = request.getParameter("courseid");
		String teacherid = request.getParameter("teacherid");
		String homeworkid = request.getParameter("homeworkid");
		System.out.println("what"+courseid);
		if (!isMultipart) return;
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		//String path = getInitParameter("absPath");
		 //在自己的项目中构造出一个用于存放用户照片的文件夹   
        String path = this.getServletContext().getRealPath("/homework/") ;   
        //如果此文件夹不存在，则构造此文件夹   
        File f = new File(path) ;   
        if(!f.exists()){   
            f.mkdir() ;   
        }   


		((DiskFileItemFactory) factory).setRepository(new File(path));
		//如果大于1024*1024才存储到临时目录下，如果小于就直接读取到内存中
		//((DiskFileItemFactory) factory).setSizeThreshold(1024 * 1024);
		((DiskFileItemFactory) factory).setRepository(f) ; 
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint
		upload.setSizeMax(10000000);
		// Parse the request
		List<FileItem> items = null;
		try
		{
			items = (List<FileItem>) upload.parseRequest(request);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (null == items) System.out.println("Error!");
		for (FileItem item : items)
		{
			if (item.isFormField())
			{
				continue;
			}
			else
			{
				String fieldName = item.getFieldName();
				String value = item.getName();
				int start = value.lastIndexOf("\\");

				String fileName = value.substring(start + 1);

				//System.out.println("fieldName is:" + fieldName + " fieldValue is:" + fileName);
				//保存
				try
				{
					item.write(new File(path, fileName));
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				UpLoadAction upload1 = new UpLoadAction();
				upload1.upLoadHomework(homeworkid,courseid,teacherid, fileName);

			}
		}

		response.sendRedirect("/homework/index.html");
	}
}