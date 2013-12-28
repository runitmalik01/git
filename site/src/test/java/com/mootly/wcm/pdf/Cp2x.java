package com.mootly.wcm.pdf;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;


public class Cp2x {

    static StreamResult streamResult;
    static TransformerHandler handler;
    static AttributesImpl atts;
    public static final String PDF = "C:\\Users\\admin\\Downloads\\form16dalbirkomila\\komila.pdf";
    public static void main(String[] args) throws IOException {

            try {
                    Document document = new Document();
                    document.open();
                    PdfReader reader = new PdfReader(PDF);
                    PdfDictionary page = reader.getPageN(2);
                    
                    PdfArray pdfArray = page.getAsArray(PdfName.CONTENTS);
                    for (Iterator<PdfObject> it = pdfArray.iterator();it.hasNext();) {
                    	PdfObject po = it.next();

                    }
                    
                    PRIndirectReference objectReference = (PRIndirectReference) page
                                    .getAsIndirectObject(PdfName.CONTENTS);
                    PRStream stream = (PRStream) PdfReader
                                    .getPdfObject(objectReference);
                    byte[] streamBytes = PdfReader.getStreamBytes(stream);
                    PRTokeniser tokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(streamBytes)));

                    StringBuffer string_buffer = new StringBuffer();
                    while (tokeniser.nextToken()) {
                            if (tokeniser.getTokenType() == PRTokeniser.TokenType.STRING) {
                                    string_buffer.append(tokeniser.getStringValue());
                            }
                    }
                    String test = string_buffer.toString();
                    streamResult = new StreamResult("c:\\temp\\test.xml");
                    initXML();
                    process(test);
                    closeXML();
                    document.add(new Paragraph(".."));
                    document.close();
            } catch (Exception e) {
            	e.printStackTrace();
            }
    }

    public static void initXML() throws ParserConfigurationException,
                    TransformerConfigurationException, SAXException {
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory
                            .newInstance();

            handler = tf.newTransformerHandler();
            Transformer serializer = handler.getTransformer();
            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            serializer.setOutputProperty(
                            "{http://xml.apache.org/xslt}indent-amount", "4");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            handler.setResult(streamResult);
            handler.startDocument();
            atts = new AttributesImpl();
            handler.startElement("", "", "Document", atts);
    }

    public static void process(String s) throws SAXException {
            String[] elements = s.split("\\|");
            atts.clear();
            handler.startElement("", "", "Note", atts);
            handler.characters(elements[0].toCharArray(), 0, elements[0].length());
            handler.endElement("", "", "Note");
    }

    public static void closeXML() throws SAXException {
            handler.endElement("", "", "Document");
            handler.endDocument();
    }
}
