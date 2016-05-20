package springdataelastisearch.repository.elasticsearch;

import org.elasticsearch.search.aggregations.Aggregations;

public interface BookRepositoryCustom {

	public Aggregations retrieveAggregations(String book);
	
}
