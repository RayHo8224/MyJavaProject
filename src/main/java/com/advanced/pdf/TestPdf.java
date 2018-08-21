package com.advanced.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPdf {

	public static void main(String[] args) {

		try {
			new TestPdf().create();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//		public static final String sql="Select no from fpr_fddr where no like '%FPR%' order by no desc";
//		ResultSet rs=null;
		public void create() throws FileNotFoundException, DocumentException{
			Document doc=new Document(); //必須先產生Document
			doc.setPageSize(PageSize.A4); //可以設定文件尺寸，有標準A1, A2, A3...等
			Date simpledate=new Date();
			PdfWriter.getInstance(doc, new FileOutputStream("/Users/HO/Documents/test/"+simpledate.getTime()+".pdf"))
			.setInitialLeading(20);
			//要產生pdf，當然就要有pdfwriter，getInstance是直接產生實例供使用，也可以new一個實例，後者適用未來較複雜的應用
			//只是加入Time只是因為測試過程中，避免檔名相同丟出Exception
			//setInitialLeading是指行距
			doc.open();//要加入內容前要先open.....
			try {
//				rs=new GetDAOResultSet().getResultSet(sql);//從資料庫拿data
//				while(rs.next()){
				BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", 
						BaseFont.NOT_EMBEDDED); 
				Font font = new Font(bf, 12); // The font size is 12.
//					Font font = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.GRAY);//設定字型
					
					doc.add(new Chunk("第一個測試PDF", font));//Chunk是最小的單元，我是把它想成StringWriter
					doc.add(Chunk.NEWLINE);//換行
					doc.add(new Chunk("第一個測試123", font));//Chunk是最小的單元，我是把它想成StringWriter
					doc.add(Chunk.NEWLINE);//換行
					doc.add(new Chunk("第一個測試abc", font));//Chunk是最小的單元，我是把它想成StringWriter
					doc.add(Chunk.NEWLINE);//換行
//				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doc.close(); //完畢後要close，iText會自動close FileOutputStream
			System.out.println("OK!!");
		}


}
