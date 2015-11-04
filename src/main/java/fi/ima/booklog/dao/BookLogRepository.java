package fi.ima.booklog.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fi.ima.booklog.api.v1.domain.BookLogEntry;

public interface BookLogRepository extends MongoRepository<BookLogEntry, String> {

	public List<BookLogEntry> findByBook_Title(String title);
	
	public List<BookLogEntry> findByNotes_ReadingDate(Date readingDate);

}
