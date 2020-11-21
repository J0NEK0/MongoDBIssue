package stackoverflow.issues.r329433.mongodb.pojos;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator(key = "type", value = "SpecificItem")
public class SpecificItem extends GenericItem<StringID> {

	private String genericProperty;
	
	@BsonCreator
	public SpecificItem(@BsonProperty("id") StringID id, @BsonProperty("genericProperty") String genericProperty) {
		super(id);
		this.genericProperty = genericProperty;
	}

	public String getGenericProperty() {
		return this.genericProperty;
	}

	@Override
	public void foo() {
		return;
	}

}
