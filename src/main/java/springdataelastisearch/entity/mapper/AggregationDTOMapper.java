package springdataelastisearch.entity.mapper;

import java.util.ArrayList;

import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.springframework.stereotype.Component;

import springdataelastisearch.entity.AggregationDTO;
import springdataelastisearch.entity.BucketDTO;

@Component
public class AggregationDTOMapper {

	public AggregationDTO toDTO(Terms terms) {
		AggregationDTO dto = new AggregationDTO();
		dto.setName(terms.getName());
		dto.setBuckets(new ArrayList<>());
		for (Bucket b : terms.getBuckets()) {
			BucketDTO bucketDTO = new BucketDTO();
			bucketDTO.setKey(b.getKey());
			bucketDTO.setDocCount(b.getDocCount());
			dto.getBuckets().add(bucketDTO);
		}
 		return dto;
	}
}
