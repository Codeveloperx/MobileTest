package mantum.mobile.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true  // Ignore keys unknown in JSON
                },
                contentType = ContentType.Application.Json
            )
        }
    }

    fun getClient(): HttpClient {
        return client
    }
}