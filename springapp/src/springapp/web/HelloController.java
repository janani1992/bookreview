package springapp.web;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import springapp.repository.BookDao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    private BookDao bookDao;
   
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {

			String now = (new Date()).toString();
			logger.info("Returning hello view with " + now);
			System.out.println("----------------------------------------------------");
			System.out.println(this.bookDao.getBookList().get(0).getBookPath());
			System.out.println(this.bookDao.getBookList().get(0).getBookId());
			System.out.println("----------------------------------------------------");
			return new ModelAndView("hello", "imageList", this.bookDao.getBookList());

			}



}