package swapi.mongo

import jakarta.validation.Valid
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono


interface PersonRepository {

    fun list(): Publisher<People>
    fun save(@Valid people: People): Mono<Boolean>



}