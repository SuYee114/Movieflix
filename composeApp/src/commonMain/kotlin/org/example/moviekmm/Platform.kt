package org.example.moviekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform