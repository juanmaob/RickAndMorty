package com.seventhson.rickandmorty.ui.navigation


sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Detail : Screen("detail/{characterId}") {
        fun createRoute(characterId: Int) = "detail/$characterId"
    }
}