package com.seventhson.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.seventhson.rickandmorty.ui.detail.views.DetailScreen
import com.seventhson.rickandmorty.ui.main.views.MainScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Main.route) {
        addMainGraph(navController)
        addDetailGraph(navController)
    }
}

@ExperimentalPagerApi
private fun NavGraphBuilder.addDetailGraph(navController: NavHostController) {
    //si no pones arguments puedes obtener el argumento con get("key") o getString("key) pero te devuelve un string siempre
    composable(
        route = Screen.Detail.route,
        arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("name") { type = NavType.StringType },
            navArgument("image") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id") ?: 0
        val name = backStackEntry.arguments?.getString("name") ?: ""
        val image = backStackEntry.arguments?.getString("image") ?: ""
        DetailScreen(
            id = id,
            picture = image,
            name = name
        ) {
            navController.popBackStack()
        }
    }
}

private fun NavGraphBuilder.addMainGraph(navController: NavHostController) {
    composable(route = Screen.Main.route) {
        MainScreen { character ->
            navController.navigate(
                Screen.Detail.createRoute(
                    id = character.id,
                    name = character.name,
                    //URLs deben ser codificadas para pasarlas como argumento, si no, salta una excepción.
                    image = URLEncoder.encode(character.image, StandardCharsets.UTF_8.toString())
                )
            )
        }
    }
}