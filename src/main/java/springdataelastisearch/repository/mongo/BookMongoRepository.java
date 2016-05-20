package springdataelastisearch.repository.mongo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springdataelastisearch.entity.Book;

public interface BookMongoRepository extends CrudRepository<Book, String> {
	
	List<Book> findByEditeur(String editor);

	List<Book> findByTitre(String title);
	
}
