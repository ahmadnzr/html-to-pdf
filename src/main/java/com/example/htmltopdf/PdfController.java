package com.example.htmltopdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.thymeleaf.context.Context;

@Controller
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generate-pdf")
    public void generatePdf() throws Exception {
        Context context = new Context();
        context.setVariable("title", "Contoh PDF");
        context.setVariable("content", "Halo, ini adalah konten PDF yang di-generate menggunakan Thymeleaf dan XHTMLRenderer.");

        pdfService.generatePdf("template", context, "output.pdf");
    }
}