package com.neu.myapplication.view;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.neu.myapplication.pojo.Transaction;
import com.neu.myapplication.pojo.User;

public class PdfReportView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> arg0, Document doc, PdfWriter arg2, HttpServletRequest request, HttpServletResponse arg4) throws Exception {
		Transaction trans = (Transaction) request.getSession().getAttribute("transaction");	
        User u = (User) request.getSession().getAttribute("user");
         
			Paragraph para1 = new Paragraph();
			para1.add("Transaction Details");
			para1.setAlignment(Element.ALIGN_CENTER);
	       doc.add(para1);
	       doc.add(Chunk.NEWLINE);
	       doc.add(new LineSeparator());
	       doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	       Paragraph para2 = new Paragraph();
	       para2.add("User Name : " + u.getFirstName() + "" + u.getLastName());
	       para2.setAlignment(Element.ALIGN_LEFT);
	       doc.add(para2);
	       doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	       Paragraph para3 = new Paragraph();
	       para3.add("Date Of Birth  : " + u.getDob());
	       para3.setAlignment(Element.ALIGN_LEFT);
	       doc.add(para3);
	       doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	       Paragraph para4 = new Paragraph();
	       para4.add("Transaction Amount : " + trans.getTransactionAmount());
	       para4.setAlignment(Element.ALIGN_LEFT);
	       doc.add(para4);
	       doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	       Paragraph para5 = new Paragraph();
	       para5.add("Transaction status : Paid");
	       doc.add(para5);
	       doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	        doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	       doc.add(new LineSeparator());
	       Paragraph para6 = new Paragraph();
	       para6.add("Thank you!!!!!");
	       para6.setAlignment(Element.ALIGN_JUSTIFIED);
	       doc.add(para6);
	       doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	        doc.add(Chunk.NEWLINE);
	       doc.add(Chunk.NEWLINE);
	       doc.close();
	}

        
		
	}

