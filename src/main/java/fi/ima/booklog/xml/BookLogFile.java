package fi.ima.booklog.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fi.ima.booklog.api.v1.domain.BookLogEntry;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "readingDiary")
public class BookLogFile {

	@XmlElement(name = "book")
	List<BookLogEntry> entries;

	public List<BookLogEntry> getEntries() {
		return entries;
	}

	public static BookLogFile parse(Reader reader) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(BookLogFile.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BookLogFile booklog = (BookLogFile) jaxbUnmarshaller.unmarshal(reader);
			return booklog;
		} catch (JAXBException e) {
			throw new RuntimeException("Failed parsing xml", e);
		}
	}

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("C:\\Users\\Isto\\Dropbox\\My Texts\\Kronikat\\Lukupäiväkirja\\reading-diary-2011.xml");
			BookLogFile booklog = BookLogFile.parse(reader);
			for (BookLogEntry entry : booklog.entries) {
				System.out.println(entry);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
