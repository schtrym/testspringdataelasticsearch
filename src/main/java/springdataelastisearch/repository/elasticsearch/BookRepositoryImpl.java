package springdataelastisearch.repository.elasticsearch;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public Aggregations retrieveAggregations(String book) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
			.withQuery(matchAllQuery())
			.withIndices("books")
			.withTypes("book")
			.addAggregation(AggregationBuilders.terms("byEditor").field("editor"))
			.addAggregation(AggregationBuilders.terms("bySerie").field("serie"))
			.addAggregation(AggregationBuilders.range("byPriceRange").field("price")
					.addUnboundedTo(10)
					.addRange(10, 15)
					.addRange(15, 20)
					.addRange(20, 25)
					.addUnboundedFrom(20))
			.build();
		Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
			@Override
			public Aggregations extract(SearchResponse response) {
				return response.getAggregations();
			}
		});
		return aggregations;
	}

}
