package springdataelastisearch.entity;

import java.util.List;

public class AggregationDTO {

	private String name;
	
	private List<BucketDTO> buckets;
	
	public String getName() {
		return name;
	}

	public List<BucketDTO> getBuckets() {
		return buckets;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBuckets(List<BucketDTO> buckets) {
		this.buckets = buckets;
	}
	
}
