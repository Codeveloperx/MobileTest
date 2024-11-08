package mantum.mobile.data.remote

import mantum.mobile.data.model.User

interface ApiServices {
    suspend fun getUsers(): List<User>;
    suspend fun getByUserId(userId: Int): User;
}