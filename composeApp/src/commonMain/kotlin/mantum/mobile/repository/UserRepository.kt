package mantum.mobile.repository

import mantum.mobile.data.model.User
import mantum.mobile.data.remote.ApiServices

class UserRepository(private val api: ApiServices) {
    suspend fun getUsers(): List<User> = api.getUsers()
}
