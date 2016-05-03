package springdataelastisearch.repository;

import org.springframework.data.repository.CrudRepository;

import springdataelastisearch.entity.Book;

public interface BookRepository extends CrudRepository<Book, String>{

}
