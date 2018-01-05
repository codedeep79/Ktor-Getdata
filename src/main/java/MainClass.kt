import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.io.File
import java.nio.charset.Charset


fun main(args: Array<String>) {
    embeddedServer(Netty, 8888) {
        routing {
            get("/") {
                val json = getJsonFromFile("mydata.json")
                call.respondText(json, ContentType.Text.JavaScript)
            }
        }
    }.start(wait = true)
}

fun getJsonFromFile(fileName:String):String{
    val file = File(fileName)
    return file.readText(Charset.defaultCharset())
}
