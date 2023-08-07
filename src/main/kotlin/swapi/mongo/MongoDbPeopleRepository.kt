package swapi.mongo

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection
import io.micronaut.core.annotation.NonNull
import jakarta.inject.Singleton
import jakarta.validation.Valid
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono



@Singleton
open class MongoDbPeopleRepository(
    private val mongoConf: MongoDbConfiguration,
    private val mongoClient: MongoClient
) : PersonRepository {

    override fun save(@Valid people: People): Mono<Boolean> =
        Mono.from(collection.insertOne(people))
            .map { true }
            .onErrorReturn(false)

    @NonNull
    override fun list(): Publisher<People> = collection.find()

    private val collection: MongoCollection<People>
        get() = mongoClient.getDatabase(mongoConf.name)
            .getCollection(mongoConf.collection, People::class.java)
}
