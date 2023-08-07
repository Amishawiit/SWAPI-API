package swapi.mongo
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable



@Controller("/swapi")
class SWAPIController(private val swapiService: SWAPIService) {

    @Get("/{resource}/{id}")
    fun getSWAPIResponse(@PathVariable resource: String, @PathVariable id: Int): String {
        return when (resource) {
            "people" -> swapiService.fetchPeople(id).body() ?: "Error fetching data from SWAPI"
            "planets" -> swapiService.fetchPlanets(id).body() ?: "Error fetching data from SWAPI"
            else -> "Invalid resource type. Supported resource types: 'people', 'planets'"
        }
    }
}



