package compose.dndapp.user.ui.view

//import androidx.annotation.DrawableRes
import dndappmp.composeapp.generated.resources.Res
import dndappmp.composeapp.generated.resources.character_bottomicon
import dndappmp.composeapp.generated.resources.dice_d20_outline_bottomicon
import dndappmp.composeapp.generated.resources.inventory_bottomicon
import dndappmp.composeapp.generated.resources.note_bottomicon
import dndappmp.composeapp.generated.resources.skill_bottomicon
import org.jetbrains.compose.resources.DrawableResource

sealed class Screen(
    val desc: String,
    val title: String,
    val route: String
){
    sealed class BottomScreen(
        val bDesc: String,
        val bTitle: String,
        val bRoute: String,
        val icon: DrawableResource
    ): Screen(bDesc, bTitle, bRoute)
    {
        data object Stats: BottomScreen(
            "Character Information and Stats",
            "Stats",
            "stats",
            Res.drawable.character_bottomicon)

        data object Skills: BottomScreen(
            "Skills and Abilities",
            "Skills",
            "skills",
            Res.drawable.skill_bottomicon)

        data object Roll: BottomScreen(
            "Dice Roll",
            "Roll",
            "roll",
            Res.drawable.dice_d20_outline_bottomicon)

        data object Items: BottomScreen(
            "Inventory and Items",
            "Items",
            "items",
            Res.drawable.inventory_bottomicon)

        data object Notes: BottomScreen(
            "Notes and Descriptions",
            "Notes",
            "notes",
            Res.drawable.note_bottomicon)
    }

//    sealed class DrawerScreen(
//        val dTitle: String,
//        val dRoute: String,
//        @DrawableRes val icon: Int
//    ): Screen(dTitle, dRoute)
//    { //Set up Singletons
//        data object Account: DrawerScreen(
//            "Account",
//            "account",
//            R.drawable.account_icon
//        )
//
//        data object Settings: DrawerScreen(
//            "Settings",
//            "settings",
//            R.drawable.settings_icon
//        )
//    }
}



val screensInBottom = listOf(
    Screen.BottomScreen.Stats,
    Screen.BottomScreen.Skills,
    Screen.BottomScreen.Roll,
    Screen.BottomScreen.Items,
    Screen.BottomScreen.Notes
)

//val screensInDrawer = listOf(
//    Screen.DrawerScreen.Account,
//    Screen.DrawerScreen.Settings
//)