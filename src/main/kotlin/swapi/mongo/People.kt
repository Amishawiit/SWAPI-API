package swapi.mongo

import io.micronaut.core.annotation.Creator
import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.constraints.NotBlank
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty

@Serdeable

data class People @Creator @BsonCreator constructor(
    @field:BsonProperty("name") @param:BsonProperty("name") @field:NotBlank val name: String,
    @field:BsonProperty("height") @param:BsonProperty("height") @field:NotBlank val height: String,
    @field:BsonProperty("mass") @param:BsonProperty("mass") var mass: String?,
    @field:BsonProperty("hair_color") @param:BsonProperty("hair_color") var hair_color: String?,
    @field:BsonProperty("skin_color") @param:BsonProperty("skin_color") var skin_color: String?,
    @field:BsonProperty("eye_color") @param:BsonProperty("eye_color") var eye_color: String?,
    @field:BsonProperty("birth_year") @param:BsonProperty("birth_year") var birth_year: String?,
    @field:BsonProperty("gender") @param:BsonProperty("gender") var gender: String?,
    @field:BsonProperty("homeworld") @param:BsonProperty("homeworld") var homeworld: String?,
    @field:BsonProperty("films") @param:BsonProperty("films") var films: List<String>?,
    @field:BsonProperty("species") @param:BsonProperty("species") var species: List<String>?,
    @field:BsonProperty("vehicles") @param:BsonProperty("vehicles") var vehicles: List<String>?,
    @field:BsonProperty("starships") @param:BsonProperty("starships") var starships: List<String>?,
    @field:BsonProperty("created") @param:BsonProperty("created") var created: String?,
    @field:BsonProperty("edited") @param:BsonProperty("edited") var edited: String?,
    @field:BsonProperty("url") @param:BsonProperty("url") var url: String?

) {
    constructor(name: String,height: String) : this(name,height,null,null,null,null,null,null,null,null,null,null,null,null,null,null)
}







