package com.seventhson.rickandmorty.ui.navigation


sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Detail : Screen("detail?id={id}&name={name}&image={image}") {
        fun createRoute(id: Int, name: String? = null, image: String? = null) = "detail?id=$id&name=$name&image=$image"
    }
    object Episode : Screen("episode/{id}") {
        fun createRoute(id: Int) = "episode/$id"
    }
}