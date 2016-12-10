package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import springapp.domain.Book;

public class JdbcBookDao extends SimpleJdbcDaoSupport  implements BookDao{

	public List<Book> getBookList() {
		// TODO Auto-generated method stub
        List<Book> books = getSimpleJdbcTemplate().query(
                "select * from book_gallery", new BookMapper());
        for(Book bk:books)
        {
        	System.out.println(bk.getBookId());
        }
        return books;
	}

	 private static class BookMapper implements ParameterizedRowMapper<Book> {

			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Book bk = new Book();
				bk.setGalId(rs.getInt("gal_id"));
				//bk.setBookPath("http://localhost:8081"+rs.getString("book_path")+rs.getString("book_id"));
				bk.setBookPath(rs.getString("book_path")+rs.getString("book_id"));
				bk.setBookId(rs.getString("book_id"));
				return bk;
			}

	    }
}
