package COM.CUSTOMER.CONTROLLER;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import COM.CUSTOMER.BEAN.BEAN_IMAGE_FILE;
import COM.CUSTOMER.DAO.DAO_IMAGE_FILE;

@WebServlet("/CUSTOMER/IMAGE_ONE")
@MultipartConfig(fileSizeThreshold = 1024*1024*10,
maxFileSize = 1024*1024*50,
maxRequestSize = 1024*1024*100)
public class CONTROLLER_IMAGE extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String act = req.getParameter("action");
		if(act.equalsIgnoreCase("submit"))
		{
					
					Part p1 = req.getPart("one");
					String path = req.getServletContext().getRealPath("/") + "upload\\"+p1.getSubmittedFileName();
					
					String gs="";
					gs=path.substring(path.indexOf("upload\\"));
					p1.write(path);
					
					System.out.println(path);
					System.out.println(gs);
					
					BEAN_IMAGE_FILE second = new BEAN_IMAGE_FILE();
					
					second.SET_IMAGE_NAME(gs);
					
					DAO_IMAGE_FILE one = new DAO_IMAGE_FILE();
					one.insertdata(second);
					
					req.getRequestDispatcher("view_image.jsp").forward(req,res);
		}
	}

}
