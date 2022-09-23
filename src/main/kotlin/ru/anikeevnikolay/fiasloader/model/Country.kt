package ru.anikeevnikolay.fiasloader.model

class Country {
    var id: String? = null
    var name: String? = null
    var language: String? = null
    var code: String? = null

    override fun toString(): String {
        return "Country(id=$id, name=$name, language=$language, code=$code)"
    }
}