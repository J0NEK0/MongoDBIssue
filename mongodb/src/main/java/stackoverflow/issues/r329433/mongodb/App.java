package stackoverflow.issues.r329433.mongodb;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import stackoverflow.issues.r329433.mongodb.pojos.SpecificItem;
import stackoverflow.issues.r329433.mongodb.pojos.StringID;

public class App {
	
	public static void main(String[] args) {
		new App();
	}
	
	
	public App() {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder()
				.register("stackoverflow.issues.r329433.mongodb.pojos").build();

		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(pojoCodecProvider));
		/* setup mongo client */
		MongoClient client = MongoClients.create(MongoClientSettings.builder()
				.applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
				.codecRegistry(pojoCodecRegistry).build());
		MongoCollection<SpecificItem> collection = client.getDatabase("BSON-Test").getCollection("Items", SpecificItem.class);
		
		SpecificItem item = new SpecificItem(new StringID("Item-ID"), "Properties...");
		collection.insertOne(item);
		System.out.println("Success");
	}
}
