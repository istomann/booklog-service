package fi.ima.booklog.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.ima.booklog.api.v1.domain.BookLogEntry;
import fi.ima.booklog.dao.BookLogRepository;
import fi.ima.booklog.xml.FileLoader;

@RestController
@RequestMapping(value = "/booklog/api/v1")
public class BookLogController {

	@Autowired
	private BookLogRepository repository;
	
	@Autowired
	private FileLoader loader;

	@RequestMapping(value = "/entries", method = RequestMethod.GET)
	public List<BookLogListItem> findAll() {
		List<BookLogListItem> items = new ArrayList<BookLogListItem>();
		List<BookLogEntry> findAll = repository.findAll();
		for (BookLogEntry bookLogEntry : findAll) {
			items.add(new BookLogListItem(bookLogEntry));
    }
		return items;
	}

	@RequestMapping(value = "/entries/{id}", method = RequestMethod.GET)
	public BookLogEntry get(@PathVariable("id") String id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/entries", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookLogEntry insert(@RequestBody BookLogEntry entry) {
		if (entry.getId() != null) {
			throw new IllegalArgumentException("Book entry " + entry.getId() + " cannot be inserted because it has id already.");
		}
		System.out.println("Create new entry " + entry);
		return repository.insert(entry);
	}

	@RequestMapping(value = "/entries", method = RequestMethod.PUT)
	public BookLogEntry update(@RequestBody BookLogEntry entry) {
		System.out.println("Update existing entry " + entry);
		if (entry != null && entry.getId() != null) {
			return repository.save(entry);			
		} 
		return entry;
	}
	
	@RequestMapping(value = "/entries/{id}", method = RequestMethod.DELETE)
	public void removeEntry(@PathVariable("id") String id) {
		System.out.println("Remove existing entry " + id);
		repository.delete(id);
	}

	@RequestMapping("/ping")
	public String ping() {
		return "Pong v1";
	}

	@RequestMapping(value = "/entries/load", method = RequestMethod.POST)
	public String load() {
		System.out.println("Load");
		loader.load();
		return "Loaded sampledata";
	}

	@RequestMapping(value = "/entries", method = RequestMethod.DELETE)
	public String clear() {
		System.out.println("Clear");
		repository.deleteAll();
		return "Cleared repository";
	}

}
