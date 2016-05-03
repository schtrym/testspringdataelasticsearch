package springdataelastisearch.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springdataelastisearch.entity.Book;
import springdataelastisearch.repository.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Book> listBooks() {
		List<Book> books = new ArrayList<Book>();
		repository.findAll().forEach(b -> books.add(b));
		return books;
	}
}
