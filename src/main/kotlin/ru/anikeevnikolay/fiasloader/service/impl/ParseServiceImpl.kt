package ru.anikeevnikolay.fiasloader.service.impl

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import ru.anikeevnikolay.fiasloader.model.Country
import ru.anikeevnikolay.fiasloader.service.ParseService
import java.io.FileInputStream
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants.START_ELEMENT


@Service
private class ParseServiceImpl(
    private val streamBridge: StreamBridge
) : ParseService {

    private val testFilePath = "/Users/nikolayanikeev/IdeaProjects/fias-loader/src/main/resources/test-data.xml"

    override fun testParse() {
        val xmlMapper = XmlMapper()
        val xmlInputFactory = XMLInputFactory.newInstance()
        val xmlReared = xmlInputFactory.createXMLStreamReader(FileInputStream( testFilePath))

        while (xmlReared.hasNext()) {
            xmlReared.next()
            if (xmlReared.eventType == START_ELEMENT) {
                if ("country" == xmlReared.localName) {
                    val country: Country = xmlMapper.readValue(xmlReared, Country::class.java)
                    val message = MessageBuilder
                        .withPayload(country)
                        .setHeader(KafkaHeaders.MESSAGE_KEY, country.id)
                        .build()
                    streamBridge.send("testProducer-out-0", message)
                }
            }
        }
    }
}