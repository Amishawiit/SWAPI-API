package swapi.mongo

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.HttpStatus.CONFLICT
import io.micronaut.http.HttpStatus.CREATED


import jakarta.validation.Valid
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import swapi.mongo.People
import swapi.mongo.PersonRepository

@Controller("/person")

open class PersonController (private val personService: PersonRepository){
    @Get
    fun list(): Publisher<People> = personService.list()
    @Post
    open fun save(@Valid people: People): Mono<HttpStatus> {
        return personService.save(people)
            .map { added: Boolean -> if (added) CREATED else CONFLICT }
    }


}
