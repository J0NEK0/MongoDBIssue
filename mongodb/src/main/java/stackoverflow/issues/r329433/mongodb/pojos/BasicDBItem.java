package stackoverflow.issues.r329433.mongodb.pojos;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator(key = "type", value = "BasicDBItem")
public abstract class BasicDBItem<T extends Identification> {

	@BsonId
	private T id;
	
	private int number; // just to illustrate some common properties

	@BsonCreator
	public BasicDBItem(@BsonProperty("id") T id) {
		this.id = id;
		this.setNumber(12345);
	}
	
	public T getId() {
		return this.id;
	}
	
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
