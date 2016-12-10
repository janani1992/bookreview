package springapp.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HttpServiceImpl implements HttpService {
	private final String USER_AGENT = "Mozilla/5.0";
	private final  String REV = "&rf=ns:";
    
	@Override
	public String checkSpellFromHtml(StringBuffer response){
		
			//Document doc = Jsoup.connect("https://www.google.co.in/?gfe_rd=cr&ei=uyhPVsn-IoXCuATKpLqoCw#q=the_foundainhead").get(); 
			//System.out.println("Response[a[class=spell]:"+response.toString());
			Document doc = Jsoup.parse(response.toString());
			String text1 = doc.select("div[id=_FQd] a.spell").text();
			String text2 = doc.select("div[id=_FQd] a").text();
			if(!text1.isEmpty())
			{
				text1=text1.replaceAll(" ", "+");
				return text1;
			}
			else if(!text2.isEmpty())
			{
				text2=text2.replaceAll(" ", "+");
				return text2;
			}
			else
				return text1;
	        
    }
	
	@Override
	public List<String> getDivFromHtml(StringBuffer response){
		List<String> revList = new ArrayList<String>();
		Document doc = Jsoup.parse(response.toString());
        ListIterator<Element> text = doc.select("div[class=single-review]").listIterator();
        while(text.hasNext()){
        	revList.add(text.next().toString().replaceAll("class=\"single-review\"","").replaceAll("class=\"aux\"",""));
        }
        return  revList;
    }
	
	@Override
    public List<String> findUrlFromHtml(StringBuffer response){
		//System.out.println("Entering findurl \n");
        Document doc = Jsoup.parse(response.toString());
        ListIterator<Element> link = doc.select("a").listIterator();
        /*System.out.println("anchor links\n");
        while(link.hasNext()) {
            Object element = link.next();
            System.out.print(element + " ");
         }*/
        
        String linkhref ="";
        while(link.hasNext()){
            String l = link.next().attr("href");
            if(l.contains("https://books.google.co.in/books?id")){
                linkhref =  link.next().attr("href");
                break;
            }
        }
        //System.out.println("Entering findurl \n"+linkhref);
        String urlStr = linkhref.subSequence(0,linkhref.indexOf("&")).toString();
        //System.out.println(urlStr);
        urlStr = urlStr+"&sitesec=reviews";
        List<String> urlList = new ArrayList<String>();
        for(int i=0;i<=5;i++){
            urlList.add(urlStr+REV+i);
        }
        //System.out.println("Entering findurl \n");
        return urlList;

    }
	
    @Override
	public StringBuffer sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        System.out.println(url);
        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result

        return response;

    }
}
