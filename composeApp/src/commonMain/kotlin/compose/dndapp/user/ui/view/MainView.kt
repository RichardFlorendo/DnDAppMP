package compose.dndapp.user.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import compose.dndapp.user.Greeting
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import compose.dndapp.user.viewmodel.MainViewModel

import dndappmp.composeapp.generated.resources.Res
import dndappmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun MainView() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val viewModel: MainViewModel = viewModel()

    //These 3 lines below allow us to find on which "View" or "Screen" we currently are in
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute =  navBackStackEntry?.destination?.route

    val currentScreen = remember {
        viewModel.currentScreen.value
    }

    val title = remember{
        mutableStateOf(currentScreen.desc) //dynamic screen name
    }

    val bottomBar: @Composable () -> Unit = {
//        if(currentScreen is Screen.DrawerScreen || currentScreen is Screen.BottomScreen.Stats){
        if(currentScreen is Screen.BottomScreen.Stats){
            BottomNavigation(modifier = Modifier.wrapContentSize()) {
                screensInBottom.forEach{
                        item ->
                    val isSelected = currentRoute == item.bRoute
                    val tint = if(isSelected) Color.White else Color.Black

                    BottomNavigationItem(selected = currentRoute == item.bRoute,
                        onClick = {
                            controller.navigate(item.bRoute)
                            title.value = item.bDesc
                        },
                        icon = {
                            Icon(
                                tint = tint,
                                painter = painterResource(item.icon),
                                contentDescription = item.bDesc
                            )
                        },
                        label = { Text(text = item.bTitle, color = tint) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        }
    }

    //presents interaction overlapping activities
    //Entire Scaffold should be inside ModalBottomSheet

    Scaffold (
        bottomBar = bottomBar,
        topBar = {
            TopAppBar(
                title = { Text(text = title.value) }
            )
        },
        scaffoldState = scaffoldState,
//        drawerContent = {//Allows to scroll through items in the drawer
//            LazyColumn (modifier = Modifier.padding(16.dp)){
//                items(screensInDrawer){//List of items in drawer
//                    item ->
//                    DrawerItem(selected = currentRoute == item.dRoute, item = item){
//                        scope.launch {
//                            scaffoldState.drawerState.close() //closes the drawer
//                        }
//                        if(item.dRoute == "settings"){
//                            dialogOpen.value = true
//                        }
//                        else{
//                            controller.navigate(item.dRoute)
//                            title.value = item.dTitle
//                        }
//                    }
//                }
//            }
//        }
    ){
        Navigation(navController = controller, viewModel = viewModel, pd = it)
    }
}

//@Composable
//fun DrawerItem(
//    selected: Boolean,
//    item: Screen.DrawerScreen,
//    onDrawerItemClicked: () -> Unit
//){
//    //Changes color depending on if it is selected or not
//    val background = if (selected) Color.DarkGray else Color.White
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 8.dp, vertical = 16.dp)
//            .background(background)
//            .clickable {
//                onDrawerItemClicked()
//            }
//    ){
//        Icon(
//            painter = painterResource(id = item.icon),
//            contentDescription = item.dTitle,
//            Modifier.padding(end = 8.dp, top = 4.dp)
//        )
//    }
//}

@Composable
@Preview()
fun MainPreview(){
    MainView()
}