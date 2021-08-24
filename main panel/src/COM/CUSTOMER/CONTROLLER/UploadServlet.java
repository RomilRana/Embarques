package COM.CUSTOMER.CONTROLLER;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import java.io.File;
import javax.servlet.*;
import javax.servlet.http.*;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import com.oreilly.servlet.multipart.FilePart;





/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/CUSTOMER/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	private String fileSavePath;
    private static final String UPLOAD_DIRECTORY = "D:\\ff";

    public void init() {
        fileSavePath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;/*save uploaded files to a 'Upload' directory in the web app*/
        if (!(new File(fileSavePath)).exists()) {
            (new File(fileSavePath)).mkdir();    // creates the directory if it does not exist        
        }
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String resp = "";
       int i = 1;
       resp += "<br>Here is information about uploaded files.<br>";
       try {
           MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 1024);  /* file limit size of 1GB*/
           Part _part;
           while ((_part = parser.readNextPart()) != null) {
               if (_part.isFile()) {
                   FilePart fPart = (FilePart) _part;  // get some info about the file
                   String name = fPart.getFileName();
                   if (name != null) {
                       long fileSize = fPart.writeTo(new File(fileSavePath));
                       resp += i++ + ". " + fPart.getFilePath() + "[" + fileSize / 1024 + " KB]<br>";
                   } else {
                       resp = "<br>The user did not upload a file for this part.";
                   }
               }
           }// end while 
       } catch (java.io.IOException ioe) {
           resp = ioe.getMessage();
       }
       request.setAttribute("message", resp);
	}
}
