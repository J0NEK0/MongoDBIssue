package stackoverflow.issues.r329433.mongodb.pojos;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator(key = "type", value = "Item")
public abstract class GenericItem<T extends Identification> extends BasicDBItem<T> {

	@BsonCreator
	public GenericItem(@BsonProperty("id") T id, @BsonProperty("genericProperty") String genericProperty) {
		super(id);
		
	}
	
	public abstract void foo();
}
