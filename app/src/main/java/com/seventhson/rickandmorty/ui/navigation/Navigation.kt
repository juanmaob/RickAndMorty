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
import com.seventhson.rickandmorty.ui.episode.views.EpisodeScreen
import com.seventhson.rickandmorty.ui.main.views.MainScreen
import com.seventhson.rickandmorty.utils.encodeURL

@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Main.route) {
        addMainGraph(navController)
        addDetailGraph(navController)
        addEpisodeGraphGraph(navController)
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
            name = name,
            onClickBack = {
                navController.popBackStack()
            },
            onClickEpisode = { episodeId ->
                navController.navigate(
                    Screen.Episode.createRoute(id = episodeId)
                )
            }
        )
    }
}

private fun NavGraphBuilder.addMainGraph(navController: NavHostController) {
    composable(route = Screen.Main.route) {
        MainScreen(
            onItemClick = { character ->
                navController.navigate(
                    Screen.Detail.createRoute(
                        id = character.id,
                        name = character.name,
                        image = character.image.encodeURL()
                    )
                )
            }
        )
    }
}

private fun NavGraphBuilder.addEpisodeGraphGraph(navController: NavHostController) {
    composable(
        route = Screen.Episode.route,
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id") ?: 0

        EpisodeScreen(
            id = id,
            onClickBack = {
                navController.popBackStack()
            },
            onClickCharacter = { characterId ->
                navController.navigate(
                    Screen.Detail.createRoute(id = characterId)
                )
            }
        )
    }
}