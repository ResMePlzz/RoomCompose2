package com.example.roomcompose2.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.roomcompose2.presentation.AddNoteScreen
import com.example.roomcompose2.presentation.DetailsScreen
import com.example.roomcompose2.presentation.StartScreen
import com.example.roomcompose2.presentation.viewModels.StartScreenViewModel

sealed class AllScreens(val route: String) {

    object StartScreen : AllScreens(
        route = "StartScreen"
    )

    object AddNoteScreen : AllScreens(
        route = "AddNoteScreen"
    )

    object DetailsScreen : AllScreens(
        route = "DetailsScreen"
    )

}

@Composable
fun MyNavHost(navigation: NavHostController, startScreenViewModel: StartScreenViewModel) {


    NavHost(navController = navigation, startDestination = AllScreens.StartScreen.route) {
        composable(route = AllScreens.StartScreen.route

        ) {
            StartScreen(navigation, startScreenViewModel)
        }
        composable(route = AllScreens.DetailsScreen.route+ "/{modelID}",
                arguments = listOf(
                navArgument(name = "modelID") {
                    type = NavType.LongType
                }
                )
        ){
            val modelID = it.arguments?.getLong("modelID")
            DetailsScreen(navigation = navigation, modelID = modelID ?: 0, startScreenViewModel  )
        }

        composable(route = AllScreens.AddNoteScreen.route){
            AddNoteScreen(navigation = navigation, startScreenViewModel)
        }
    }


}


