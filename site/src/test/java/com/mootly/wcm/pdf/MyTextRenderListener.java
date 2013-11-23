package com.mootly.wcm.pdf;

import java.io.PrintWriter;

import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.LineSegment;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.parser.Vector;

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
        //out.print ( "X:" + renderInfo.getBaseline().getBoundingRectange().getX());
        //out.print ( "Y:" + renderInfo.getBaseline().getBoundingRectange().getY());
        
        out.print ( "I1:" + renderInfo.getBaseline().getStartPoint().get(Vector.I1));
        out.print ( "I2:" + renderInfo.getBaseline().getStartPoint().get(Vector.I2));
        out.print ( "I3:" + renderInfo.getBaseline().getStartPoint().get(Vector.I3));
        
        out.print(renderInfo.getText());
        out.print(">");
    }
    
    
    
}
