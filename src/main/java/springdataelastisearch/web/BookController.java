package springdataelastisearch.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springdataelastisearch.entity.Book;

@Controller
@RequestMapping("/books")
public class BookController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Book> listBooks() {
		Book book = new Book();
		book.setTitle("Tintin est en plein test");
		book.setPrice(23.5);
		book.setSerie("T");
		book.setEditor("Casterman");
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		return books;
	}
}
