package com.seventhson.rickandmorty.ui.navigation


sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Detail : Screen("detail/{id}/{name}/{image}") {
        fun createRoute(id: Int, name: String, image: String) = "detail/$id/$name/$image"
    }
    object Episode : Screen("episode/{id}") {
        fun createRoute(id: Int) = "episode/$id"
    }
}