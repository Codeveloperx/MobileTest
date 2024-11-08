package mantum.mobile.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import mantum.mobile.data.model.User
import mantum.mobile.util.Constant.BASE_URL

class ApiServiceImpl(private val client: HttpClient) : ApiServices {

    override suspend fun getUsers(): List<User> {
        val response: HttpResponse = client.get("$BASE_URL/users")
        if (response.status == HttpStatusCode.OK) {
            return response.body()
        } else {
            throw Exception("Error fetching users: ${response.status}")
        }
    }

    override suspend fun getByUserId(userId: Int): User {
        val response: HttpResponse = client.get("$BASE_URL/$userId")
        if (response.status == HttpStatusCode.OK) {
            return response.body()
        } else {
            throw Exception("Error fetching user with ID $userId: ${response.status}")
        }
    }
}
