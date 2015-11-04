package fi.ima.booklog.api.v1.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "notes")
public class Notes {

	@XmlElement(name = "readingDate")
	private Date readingDate;

	@XmlElement(name = "rating")
	private Double rating;

	@XmlElement(name = "description")
	private String review;

	public Notes() {
	}

	public Notes(Date readingDate, Double rating) {
		super();
		this.readingDate = readingDate;
		this.rating = rating;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
  public String toString() {
	  return "Notes [readingDate=" + readingDate + ", rating=" + rating + "]";
  }
	
	

}
