package mantum.mobile.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company
)

@Serializable
data class  Address (
  val street: String,
  val suite: String,
  val city: String,
  val zipcode: String
)

@Serializable
data class  Company (
   val name: String,
   val catchPhrase: String,
   val bs: String
)