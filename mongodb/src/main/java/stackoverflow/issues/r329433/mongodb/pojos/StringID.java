package stackoverflow.issues.r329433.mongodb.pojos;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator(key = "type", value = "StringID")
public class StringID extends Identification {

	@BsonId
	private String id;

	@BsonCreator
	public StringID(@BsonProperty("id") String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	@BsonIgnore
	@Override
	public Class<? extends Identification> getType() {
		return StringID.class;
	}

}
