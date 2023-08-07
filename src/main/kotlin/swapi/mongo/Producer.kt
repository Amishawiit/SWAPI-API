package swapi.mongo



import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic


@KafkaClient
interface Producer {

    @Topic("order-producer")
    fun send(@KafkaKey itemID: Int, people:People)
}