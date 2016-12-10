package springapp.repository;

import java.util.List;

public interface HttpService {

	List<String> getDivFromHtml(StringBuffer response);

	List<String> findUrlFromHtml(StringBuffer response);

	StringBuffer sendGet(String url) throws Exception;

	String checkSpellFromHtml(StringBuffer response);

}
