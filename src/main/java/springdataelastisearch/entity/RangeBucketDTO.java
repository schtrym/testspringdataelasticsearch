package springdataelastisearch.entity;

public class RangeBucketDTO implements BucketDTO {
	private String key;

	private long docCount;

	private Number from;

	private Number to;

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

	public Number getFrom() {
		return from;
	}

	public Number getTo() {
		return to;
	}

	public void setFrom(Number from) {
		this.from = from;
	}

	public void setTo(Number to) {
		this.to = to;
	}

}
