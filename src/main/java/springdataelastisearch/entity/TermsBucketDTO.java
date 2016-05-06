package springdataelastisearch.entity;

public class TermsBucketDTO implements BucketDTO {

	private String key;
	
	private long docCount;

	public String getKey() {
		return key;
	}

	public long getDocCount() {
		return docCount;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setDocCount(long docCount) {
		this.docCount = docCount;
	}
	
}
