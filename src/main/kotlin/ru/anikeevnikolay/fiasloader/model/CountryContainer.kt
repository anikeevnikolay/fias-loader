package ru.anikeevnikolay.fiasloader.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement
class CountryContainer {

    @JacksonXmlProperty(localName = "country")
    private val countries: MutableList<Country> = mutableListOf()
}