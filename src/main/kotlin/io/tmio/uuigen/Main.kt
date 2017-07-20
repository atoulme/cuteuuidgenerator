package io.tmio.uuigen

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Controller
class PublicApp {

}

@RestController
class RestAPI {

    @RequestMapping("/rest/uuid", method = arrayOf(GET))
    fun generateUUID() : Map<String, String> {
        val uuid = UUID.randomUUID()
        val color = java.lang.Long.toHexString(Math.abs(uuid.mostSignificantBits % 4096L)) +
                java.lang.Long.toHexString(Math.abs(uuid.leastSignificantBits % 4096L))
        return hashMapOf<String, String>("uuid" to uuid.toString(), "color" to color)
    }
}

@SpringBootApplication
open class Application {

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}