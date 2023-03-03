package com.seventhson.rickandmorty.ui.navigation


sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Detail : Screen("detail/{id}?name={name}&image={image}") {
        const val id = "id"
        const val name = "name"
        const val image = "image"
        fun createRoute(id: Int, name: String? = null, image: String? = null) = "detail/$id?name=$name&image=$image"
    }
    object Episode : Screen("episode/{id}") {
        const val id = "id"

        fun createRoute(id: Int) = "episode/$id"
    }
}