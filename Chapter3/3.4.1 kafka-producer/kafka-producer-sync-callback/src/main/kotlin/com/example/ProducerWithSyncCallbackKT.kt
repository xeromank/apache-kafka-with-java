package com.example

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.LoggerFactory
import java.util.Properties

object ProducerWithSyncCallbackKT {
    private val logger = LoggerFactory.getLogger(ProducerWithSyncCallbackKT::class.java)
    private const val TOPIC_NAME = "alter.test"
    private const val BOOTSTRAP_SERVERS = "my-kafka:9092"
    @JvmStatic
    fun main(args: Array<String>) {
        val configs = Properties()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = BOOTSTRAP_SERVERS
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
//        configs.put(ProducerConfig.ACKS_CONFIG, "0");

        val producer = KafkaProducer<String, String>(configs)
        val record = ProducerRecord(TOPIC_NAME, "Pangyo", "Pangyo")
        try {
            val metadata = producer.send(record).get()
            logger.info(metadata.toString())
        } catch (e: Exception) {
            logger.error(e.message, e)
        } finally {
            producer.flush()
            producer.close()
        }
    }
}
