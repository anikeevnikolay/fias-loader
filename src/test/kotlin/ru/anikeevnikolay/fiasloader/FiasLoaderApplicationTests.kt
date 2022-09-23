package ru.anikeevnikolay.fiasloader

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.apache.commons.lang3.time.DurationFormatUtils
import org.junit.jupiter.api.Test
import ru.anikeevnikolay.fiasloader.model.Param
import java.io.BufferedWriter
import java.io.FileInputStream
import java.io.FileWriter
import java.time.Duration
import java.time.Instant
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants


//@SpringBootTest
class FiasLoaderApplicationTests {

//	private val testFilePath = "/Volumes/Elements/fias/gar_xml/05/AS_HOUSES_PARAMS_20220922_5fbf0d12-0e43-493c-a167-344ef4938fdb.XML"
	private val testFilePath = "/Users/nikolayanikeev/IdeaProjects/fias-loader/src/main/resources/test-params.xml"
	private val testOutputFilePath = "/Users/nikolayanikeev/IdeaProjects/fias-loader/src/main/resources/output.txt"

	@Test
	fun contextLoads() {
		val startDate = Instant.now()
		val xmlMapper = XmlMapper()
		val xmlInputFactory = XMLInputFactory.newInstance()
		val xmlReared = xmlInputFactory.createXMLStreamReader(FileInputStream( testFilePath))
		val writer = BufferedWriter(FileWriter(testOutputFilePath))


		val startLoopDate = Instant.now()
		while (xmlReared.hasNext()) {
			xmlReared.next()
			if (xmlReared.eventType == XMLStreamConstants.START_ELEMENT) {
				println(xmlReared.localName)
				if ("PARAM" == xmlReared.localName) {
					val param: Param = xmlMapper.readValue(xmlReared, Param::class.java)
					writer.write(param.toString())
					writer.newLine()
				}
			}
		}
		writer.flush()
		writer.close()
		val endDate = Instant.now()

		val firstDuration = Duration.between(startDate, startLoopDate)
		println("Предварительные заботы заняли ${firstDuration.toReadableString()}")

		val secondDuration = Duration.between(startLoopDate, endDate)
		println("Вся работа заняла ${secondDuration.toReadableString()}")
	}

	private fun Duration.toReadableString(): String = DurationFormatUtils.formatDuration(this.toMillis(), "HH:mm:ss.SSSS")
}
