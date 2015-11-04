package fi.ima.booklog.api.v1.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book")
public class BookLogEntry {

	@Id
	private String id;

	@XmlElement(name = "details")
	private Book book;

	@XmlElement(name = "notes")
	private Notes notes;

	public BookLogEntry() {
	}

	public BookLogEntry(Book book, Notes notes) {
		super();
		this.book = book;
		this.notes = notes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	@Override
  public String toString() {
	  return "BookLogEntry [id=" + id + ", book=" + book + ", notes=" + notes + "]";
  }
	
	

}
