package swapi.mongo

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.runtime.Micronaut
import jakarta.inject.Singleton
import jakarta.validation.Valid
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import com.google.gson.Gson


@Singleton
class SWAPIService(@Client("https://swapi.dev/api") private val httpClient: HttpClient,private val producer: Producer) {


    private val cachedPeopleResponses = mutableMapOf<Int, String>()
    private val cachedPlanetsResponses = mutableMapOf<Int, String>()

    @Get("/people/{id}")
    fun fetchPeople(id: Int): HttpResponse<String> {
        if (cachedPeopleResponses.containsKey(id)) {
            return HttpResponse.ok(cachedPeopleResponses[id])
        }

        val response = httpClient.toBlocking().retrieve("/people/$id")
        val gson = Gson()

        val prn=gson.fromJson(response, People::class.java)

        producer.send(id,prn)



        cachedPeopleResponses[id] = response


        return HttpResponse.ok(response)
    }

    @Get("/planets/{id}")
    fun fetchPlanets(id: Int): HttpResponse<String> {
        if (cachedPlanetsResponses.containsKey(id)) {
            return HttpResponse.ok(cachedPlanetsResponses[id])
        }

        val response = httpClient.toBlocking().retrieve("/planets/$id")
        cachedPlanetsResponses[id] = response
        return HttpResponse.ok(response)
    }


}
