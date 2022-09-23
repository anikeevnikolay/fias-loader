package ru.anikeevnikolay.fiasloader.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

class Param {

    @JacksonXmlProperty(isAttribute = true, localName = "ID")
    var id: Int? = null
    @JacksonXmlProperty(isAttribute = true, localName = "OBJECTID")
    var objectId: Int? = null
    @JacksonXmlProperty(isAttribute = true, localName = "CHANGEID")
    var changeId: Int? = null
    @JacksonXmlProperty(isAttribute = true, localName = "CHANGEIDEND")
    var changeIdEnd: Int? = null
    @JacksonXmlProperty(isAttribute = true, localName = "TYPEID")
    var typeId: Int? = null
    @JacksonXmlProperty(isAttribute = true, localName = "VALUE")
    var value: String? = null
    @JacksonXmlProperty(isAttribute = true, localName = "UPDATEDATE")
    var updateDate: String? = null
    @JacksonXmlProperty(isAttribute = true, localName = "STARTDATE")
    var startDate: String? = null
    @JacksonXmlProperty(isAttribute = true, localName = "ENDDATE")
    var endDate: String? = null
    override fun toString(): String {
        return "Param(id=$id, objectId=$objectId, changeId=$changeId, changeIdEnd=$changeIdEnd, typeId=$typeId, value=$value, updateDate=$updateDate, startDate=$startDate, endDate=$endDate)"
    }
}