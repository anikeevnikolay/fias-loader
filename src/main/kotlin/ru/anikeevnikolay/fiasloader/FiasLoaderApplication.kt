package ru.anikeevnikolay.fiasloader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FiasLoaderApplication

fun main(args: Array<String>) {
	runApplication<FiasLoaderApplication>(*args)
}
