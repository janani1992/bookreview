package springapp.domain;

public class Review {
	private String userName;
	private String source;
	private String review;
	private Integer rating;
	private String revHeading;
	
	public String getRevHeading() {
		return revHeading;
	}
	public void setRevHeading(String revHeading) {
		this.revHeading = revHeading;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
