package swapi.mongo


import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KafkaListener(
    clientId = "shopkart-order-consumer",
    groupId = "order-consumer",
    batch = true,
    offsetReset = OffsetReset.EARLIEST
)
class Consumer(private val personController: PersonController ) {


    @Topic("order-producer")
    fun receive(people: List<People>) {
       // val prn=gson.fromJson(response, People::class.java)
        personController.save(people[0]).block()

    }
}