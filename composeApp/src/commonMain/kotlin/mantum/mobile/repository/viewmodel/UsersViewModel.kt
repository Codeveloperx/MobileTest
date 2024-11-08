package mantum.mobile.repository.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import mantum.mobile.data.model.User
import mantum.mobile.repository.UserRepository


class UserViewModel(private val userRepository: UserRepository) {
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users;

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error : State<String?> = _error


    fun getUsersList() {
        viewModelScope.launch {
           _isLoading.value = true
            try {
                 _users.value = userRepository.getUsers()
                _error.value = null
            } catch (e: Exception) {
            _error.value = "Error to get users"
            }
            _isLoading.value = false
       }
    }
}