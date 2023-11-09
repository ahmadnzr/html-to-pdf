package com.example.htmltopdf;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class PdfService {
    @Autowired
    private TemplateEngine templateEngine;

    public void generatePdf(String templateName, org.thymeleaf.context.Context context, String outputPdfPath) throws Exception {
        String renderedHtml = templateEngine.process(templateName, (IContext) context);

        try (FileOutputStream outputStream = new FileOutputStream(outputPdfPath)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(renderedHtml);
            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }
    
}
