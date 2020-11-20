package stackoverflow.issues.r329433.mongodb.pojos;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonIgnore;

@BsonDiscriminator(key = "type", value = "Identification")
public abstract class Identification {
	@BsonIgnore
	public abstract Class<? extends Identification> getType();
}
