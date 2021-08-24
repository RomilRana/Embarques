package COM.CONTROLLER;



import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import COM.CONNECT.CONNECT_FILE;

public class generate_pdf {
	
	public static void main(String[] args)
	{
		try
		{
			String f_name="D:\\generatepdf\\FullReport.pdf";
			Document document = new Document();
			document.setPageSize(PageSize.A1);
			PdfWriter.getInstance(document, new FileOutputStream(f_name));
			document.open();
			
			
			Font f=new Font(FontFamily.TIMES_ROMAN,50.0f,Font.UNDERLINE|Font.BOLD,BaseColor.RED);
			Paragraph pars = new Paragraph("Customer Table\n\n",f);
			
			pars.setAlignment(Element.ALIGN_CENTER);
			document.add(pars);
			
			document.addTitle("Customer Report");
			document.addCreator("Embarques Admin");
			
			PdfPTable table = new PdfPTable(6);
			
			Font f1=new Font(FontFamily.TIMES_ROMAN,20.0f,Font.BOLD,BaseColor.BLACK);
			
			/*
			 * PdfPCell c1 = new PdfPCell(new Phrase("Id",f1));
			 * c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			 * c1.setVerticalAlignment(Element.ALIGN_MIDDLE); table.addCell(c1);
			 */
			
			PdfPCell c1 = new PdfPCell(new Phrase("Customer Id",f1));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("First Name",f1));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Last Name",f1));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Email",f1));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Mobile Number",f1));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase("Date Of Join",f1));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c1);
			
			table.setHeaderRows(1);
 			
			Connection con =CONNECT_FILE.sqlConnection();
			
			 String query = "select * from cust_table";
			PreparedStatement ps = (PreparedStatement) con.prepareCall(query);

			ResultSet rs = ps.executeQuery();	
			
		    document.setMarginMirroring(false);
		
			while(rs.next())
			{
				table.addCell(String.valueOf(rs.getInt("cust_id")));
				table.addCell(rs.getString("first_name"));
				table.addCell(rs.getString("last_name"));
				table.addCell(rs.getString("cust_email"));
				table.addCell(rs.getString("contact"));	
				table.addCell(String.valueOf(rs.getInt("doi")));
			}
			
			document.add(table);
			document.close();
			
			System.out.println("Completed!");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}

}
