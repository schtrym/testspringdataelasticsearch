package springdataelastisearch.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springdataelastisearch.entity.AggregationDTO;
import springdataelastisearch.entity.Book;
import springdataelastisearch.entity.mapper.AggregationDTOMapper;
import springdataelastisearch.repository.elasticsearch.BookRepository;
import springdataelastisearch.repository.mongo.BookMongoRepository;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private BookMongoRepository mongoRepository;
	
	@Autowired
	private AggregationDTOMapper aggregationDTOMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Book> listBooks(@RequestParam(required = false, value="editor") String editor, @RequestParam(required = false, value="title") String title) {
		List<Book> books = new ArrayList<Book>();
		if (editor == null && title == null) {
			repository.findAll().forEach(b -> books.add(b));
		}
		else if (editor != null){
			repository.findByEditeur(editor).forEach(b -> books.add(b));
		}
		else if (title != null) {
			repository.findByTitre(title).forEach(b -> books.add(b));
		}
		return books;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void createBook(@RequestBody Book book) {
		System.err.println("Create a book");
		mongoRepository.save(book);
	}
	
	@RequestMapping(value = "aggs", method = RequestMethod.GET)
	public @ResponseBody List<AggregationDTO> listAggregations() {
		Aggregations retrieveAggregations = repository.retrieveAggregations("tintin");
		return retrieveAggregations.asMap().values().stream().map(a -> aggregationDTOMapper.toDTO(a)).collect(Collectors.toList());
	}
}
