package com.example.translate.image.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kong.unirest.json.JSONObject;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class TranslateService {

	// camada de serviço, onde estancia o TESS4J, lê a imagem e converte em texto, retornando para o 
	// front em JSON
	public String calculateInfosProb( MultipartFile multipartFile ) throws IOException {
		
		File file = new File("C:/tess4J/targetFile.png");

		multipartFile.transferTo(file);

		Tesseract tess4j = new Tesseract( );
		
        tess4j.setDatapath("C:/tess4J/Tess4J-3.4.8-src/Tess4J/tessdata");
        tess4j.setLanguage("por");

        JSONObject obj = new JSONObject();
        try {
            String result = tess4j.doOCR(file);
            
            obj.put("infos", result);
            
            return obj.toString();
            
        } catch (TesseractException e) 
        {
        	return obj.put("infos", "error").toString();
        }
	}

}
