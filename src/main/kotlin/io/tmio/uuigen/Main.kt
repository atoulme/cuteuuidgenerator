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

    fun createColorElement(bits: Long) : String {
        val hexString = java.lang.Long.toHexString(Math.abs(bits % 4096L));
        return "000".substring(hexString.length) + hexString;
    }

    @RequestMapping("/rest/uuid", method = arrayOf(GET))
    fun generateUUID() : Map<String, String> {
        val uuid = UUID.randomUUID()
        val color = createColorElement(uuid.mostSignificantBits) +
                createColorElement(uuid.leastSignificantBits)
        return hashMapOf<String, String>("uuid" to uuid.toString(), "color" to color)
    }
}

@SpringBootApplication
open class Application {

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}