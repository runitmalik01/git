package com.mootly.wcm.pdf;

import java.io.PrintWriter;

import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class MyTextRenderListener extends LocationTextExtractionStrategy implements RenderListener {


	/** The print writer to which the information will be written. */
    protected PrintWriter out;
 
    /**
     * Creates a RenderListener that will look for text.
     */
    public MyTextRenderListener(PrintWriter out) {
        this.out = out;
    }
 
    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#beginTextBlock()
     */
    public void beginTextBlock() {
        out.print("<");
    }
 
    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#endTextBlock()
     */
    public void endTextBlock() {
        out.println(">");
        out.flush();
    }
 
    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#renderImage(
     *     com.itextpdf.text.pdf.parser.ImageRenderInfo)
     */
    public void renderImage(ImageRenderInfo renderInfo) {
    }
 
    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#renderText(
     *     com.itextpdf.text.pdf.parser.TextRenderInfo)
     */
    public void renderText(TextRenderInfo renderInfo) {
        out.print("<");
        //out.print ( "X:" + renderInfo.getBaseline().getBoundingRectange());
        out.print ( "X:" + renderInfo.getBaseline().getBoundingRectange().getX());
        out.print ( "Y:" + renderInfo.getBaseline().getBoundingRectange().getY());
        
        out.print ( "Y:" + renderInfo.getBaseline().getStartPoint());
        out.print ( "Y:" + renderInfo.getBaseline().getEndPoint());
        
        out.print(renderInfo.getText());
        out.print(">");
    }
    
    
    
}
