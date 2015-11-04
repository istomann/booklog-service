package fi.ima.booklog.api.v1;

import java.util.Date;

import fi.ima.booklog.api.v1.domain.BookLogEntry;

public class BookLogListItem {

	private String id;

	private String title;

	private String author;

	private Date readingDate;

	public BookLogListItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookLogListItem(BookLogEntry entry) {
		super();
		if (entry != null) {
			this.setId(entry.getId());
			if (entry.getBook() != null) {
				this.setTitle(entry.getBook().getTitle());
				if (entry.getBook().getAuthors() != null && !entry.getBook().getAuthors().isEmpty()) {
					this.setAuthor(entry.getBook().getAuthors().get(0));
				}
			}
			if (entry.getNotes() != null && entry.getNotes().getReadingDate() != null) {
				this.setReadingDate(entry.getNotes().getReadingDate());
			}
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	@Override
	public String toString() {
		return "BookLogListItem [id=" + id + ", title=" + title + ", author=" + author + ", readingDate=" + readingDate + "]";
	}

}
