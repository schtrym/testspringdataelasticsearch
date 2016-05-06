package springdataelastisearch.repository;

import org.elasticsearch.search.aggregations.Aggregations;

public interface BookRepositoryCustom {

	public Aggregations retrieveAggregations(String book);
	
}
