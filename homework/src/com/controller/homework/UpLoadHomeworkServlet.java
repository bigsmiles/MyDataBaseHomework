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
		 //���Լ�����Ŀ�й����һ�����ڴ���û���Ƭ���ļ���   
        String path = this.getServletContext().getRealPath("/homework/") ;   
        //������ļ��в����ڣ�������ļ���   
        File f = new File(path) ;   
        if(!f.exists()){   
            f.mkdir() ;   
        }   


		((DiskFileItemFactory) factory).setRepository(new File(path));
		//�������1024*1024�Ŵ洢����ʱĿ¼�£����С�ھ�ֱ�Ӷ�ȡ���ڴ���
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
				//����
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