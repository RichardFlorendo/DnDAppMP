package compose.dndapp.user.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import compose.dndapp.user.viewmodel.MainViewModel
import compose.dndapp.user.ui.view.screens.CharacterView

@Composable
fun Navigation(
    navController: NavController,
    viewModel: MainViewModel,
    pd: PaddingValues
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.BottomScreen.Stats.route, //Default route
        modifier = Modifier.padding(pd))
    {//Can also be builder = {}
        composable(Screen.BottomScreen.Stats.bRoute){
            CharacterView()
        }
        composable(Screen.BottomScreen.Skills.bRoute){

        }
        composable(Screen.BottomScreen.Roll.bRoute){

        }
        composable(Screen.BottomScreen.Items.bRoute){

        }
        composable(Screen.BottomScreen.Notes.bRoute){

        }

//        composable(Screen.DrawerScreen.Account.route){
//            CharacterView() //brings the user to AccountView activity
//        }
//        composable(Screen.DrawerScreen.Settings.dRoute){
//
//        }
    }
}