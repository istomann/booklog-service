package fi.ima.booklog.api.v1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "details")
public class Book {

	@XmlElement(name = "title")
	private String title;

	@XmlElement(name = "author")
	private List<String> authors = new ArrayList<String>();

	@XmlElement(name = "publisher")
	private String publisher;

	@XmlElement(name = "label")
	private String label;

	@XmlElement(name = "year")
	private int year;

	@XmlElement(name = "originalTitle")
	private String originalTitle;

	@XmlElement(name = "originalYear")
	private int originalYear;

	@XmlElement(name = "translator")
	private List<String> translators = new ArrayList<String>();

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String... authors) {
		super();
		this.title = title;
		if (authors != null) {
			for (String author : authors) {
				this.authors.add(author);
			}
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public int getOriginalYear() {
		return originalYear;
	}

	public void setOriginalYear(int originalYear) {
		this.originalYear = originalYear;
	}

	public List<String> getTranslators() {
		return translators;
	}

	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + "]";
	}

}
