package com.seventhson.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seventhson.rickandmorty.ui.detail.DetailScreen
import com.seventhson.rickandmorty.ui.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            MainScreen { characterId ->
                navController.navigate(Screen.Detail.createRoute(characterId = characterId))
            }
            
        }
        //si no arguments puedes obtener el argumento con get("key") o getString("key) pero te devuelve un string siempre
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId") ?: 0
            DetailScreen(id = characterId)
        }
    }
}