package springapp.domain;

import java.io.Serializable;

public class Book implements Serializable {

    private String bookId;
    private String bookPath;
    private Integer galId;
    
    public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookPath() {
		return bookPath;
	}

	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}

	public Integer getGalId() {
		return galId;
	}

	public void setGalId(Integer galId) {
		this.galId = galId;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("galId: " + galId + ";");
        buffer.append("bookId: " + bookId + ";");
        buffer.append("bookPath: " + bookPath);
        return buffer.toString();
    }
}