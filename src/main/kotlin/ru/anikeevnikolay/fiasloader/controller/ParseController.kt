package ru.anikeevnikolay.fiasloader.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.anikeevnikolay.fiasloader.service.ParseService

@RestController
@RequestMapping("parse")
private class ParseController(
    private val service: ParseService
) {

    @GetMapping("start/test")
    fun testLoad() = service.testParse()
}