package springapp.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.xeustechnologies.googleapi.spelling.Configuration;
import org.xeustechnologies.googleapi.spelling.Language;
import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellCorrection;
import org.xeustechnologies.googleapi.spelling.SpellRequest;
import org.xeustechnologies.googleapi.spelling.SpellResponse;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import springapp.repository.HttpService;

public class ReviewController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    protected final String path ="" ;
    
    private HttpService httpService;
    
	public HttpService getHttpService() {
		return httpService;
	}

	public void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}
	
	private static String getTextFromImage(String imagePath)
    {
        File imageFile = new File("C:\\Users\\c5228738\\Documents\\instant\\images\\image9.JPG");
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        instance.setDatapath("C:\\Users\\c5228738\\workspace1\\springapp\\src\\springapp\\tessdata");
        String finresult = "";
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
            
            finresult = result.replaceAll("\n", " ").replaceAll("\r", " ");
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

        return finresult;
    }

	public ModelAndView handleRequest(HttpServletRequest request, 
    		HttpServletResponse response)
            throws ServletException, IOException {
			String fileName =request.getParameter("imgId")+".jpg";
			String filePath =path+"\\"+fileName;
			String teserract = this.getTextFromImage("");
			String query = teserract.replaceAll(" ", "+");
			List<String> revList = new ArrayList<>();
			try {

				String prevUrl = "https://www.google.co.in/search?tbm=bks&q="+query;
				StringBuffer spellResponse = this.httpService.sendGet(prevUrl);
				String spellCorrectedTitle = this.httpService.checkSpellFromHtml(spellResponse);
				if(spellCorrectedTitle.isEmpty()){
					spellCorrectedTitle = query;
				}
	            System.out.println("Testing 1 - Send Http GET request");
	            String url ="https://www.google.co.in/search?tbm=bks&q="+spellCorrectedTitle;
	            StringBuffer responseStr = this.httpService.sendGet(url);
	            List<String> urlList = this.httpService.findUrlFromHtml(responseStr);
	
	            for(int i=0;i<=5;i++)
	            {
	            	System.out.println("Review for "+i);
	            	
	            	revList.addAll(this.httpService.getDivFromHtml(
	            			this.httpService.sendGet(urlList.get(i))));
	            }
	            
	        }catch (Exception e){
	            e.printStackTrace();
	        }
    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
       
        return new ModelAndView("review", "revList", revList);
    }


}
