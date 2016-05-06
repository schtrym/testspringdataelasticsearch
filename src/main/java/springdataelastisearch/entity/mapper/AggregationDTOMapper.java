package springdataelastisearch.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.range.Range;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.springframework.stereotype.Component;

import springdataelastisearch.entity.AggregationDTO;
import springdataelastisearch.entity.BucketDTO;
import springdataelastisearch.entity.RangeBucketDTO;
import springdataelastisearch.entity.TermsBucketDTO;

@Component
public class AggregationDTOMapper {

	public AggregationDTO toDTO(Aggregation agg) {
		AggregationDTO dto = new AggregationDTO();
		dto.setName(agg.getName());
		if (agg instanceof Terms) {
			dto.setBuckets(toDTOTerms((Terms)agg));
		}
		if (agg instanceof Range) {
			dto.setBuckets(toDTORange((Range)agg));
		}
		return dto;
	}
	
	private List<BucketDTO> toDTOTerms(Terms terms) {
		List<BucketDTO> bucketDTOs = new ArrayList<>();
		for (Terms.Bucket b : terms.getBuckets()) {
			TermsBucketDTO bucketDTO = new TermsBucketDTO();
			bucketDTO.setKey(b.getKey());
			bucketDTO.setDocCount(b.getDocCount());
			bucketDTOs.add(bucketDTO);
		}
 		return bucketDTOs;
	}

	private List<BucketDTO> toDTORange(Range range) {
		List<BucketDTO> bucketDTOs = new ArrayList<>();
		for (Range.Bucket b : range.getBuckets()) {
			RangeBucketDTO bucketDTO = new RangeBucketDTO();
			bucketDTO.setKey(b.getKey());
			bucketDTO.setDocCount(b.getDocCount());
			bucketDTO.setFrom(b.getFrom());
			bucketDTO.setTo(b.getTo());
			bucketDTOs.add(bucketDTO);
		}
		return bucketDTOs;
	}
}
