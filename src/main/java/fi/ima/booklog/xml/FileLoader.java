package fi.ima.booklog.xml;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fi.ima.booklog.api.v1.domain.BookLogEntry;
import fi.ima.booklog.dao.BookLogRepository;

@Component
public class FileLoader {

	@Autowired
	private BookLogRepository repository;

	@Value("${xml.dir}")
	private String xmlDirectoryPath;

	@Value("${xml.filter}")
	private String postFixFilter;

	public void load() {
		System.out.println("Directory " + xmlDirectoryPath + ", Filter=" + postFixFilter);

		File dir = new File(xmlDirectoryPath);
		if (!dir.isDirectory()) {
			System.out.println("Directory " + dir.getAbsolutePath() + " is not a directory.");
		}
		File[] xmlfiles = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(postFixFilter);
			}
		});

		if (xmlfiles == null || xmlfiles.length == 0) {
			System.out.println("NO FILES TO LOAD. SKIP.");
			return;
		}

		for (File file : xmlfiles) {
			System.out.println("Processing file " + file.getName());
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(file);
				BookLogFile booklog = BookLogFile.parse(fileReader);
				repository.insert(cleanData(booklog.getEntries()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				System.out.println("Error in parsing file " + file.getName() + ": " + e.getMessage());
			} finally {
				try {
					fileReader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	List<BookLogEntry> cleanData(List<BookLogEntry> entries) {
		for (BookLogEntry bookLogEntry : entries) {
			if (bookLogEntry.getNotes() != null && bookLogEntry.getNotes().getReview() != null) {
				bookLogEntry.getNotes().getReview().trim();
			}
		}
		return entries;
	}

}
