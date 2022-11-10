package com.example.translate.image.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class TranslateService {

	public Object calculateInfosProb( MultipartFile multipartFile ) throws IOException {
		
		File file = new File("C:/tess4J/targetFile.png");

		multipartFile.transferTo(file);

		Tesseract tess4j = new Tesseract( );
		
        tess4j.setDatapath("C:/tess4J/Tess4J-3.4.8-src/Tess4J");
        tess4j.setLanguage("por");
        
        try {
            String result = tess4j.doOCR(file);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        
        return null;
	}

}
