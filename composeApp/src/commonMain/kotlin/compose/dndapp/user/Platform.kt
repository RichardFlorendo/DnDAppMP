package compose.dndapp.user

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform