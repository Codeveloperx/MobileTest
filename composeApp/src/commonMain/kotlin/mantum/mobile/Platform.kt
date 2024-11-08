package mantum.mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform