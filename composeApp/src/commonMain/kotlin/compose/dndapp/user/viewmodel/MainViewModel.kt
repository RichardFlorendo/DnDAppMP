package compose.dndapp.user.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import compose.dndapp.user.ui.view.Screen

class MainViewModel: ViewModel() {
    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.BottomScreen.Stats)

    val currentScreen: MutableState<Screen>
        get() = _currentScreen

    fun setCurrentScreen(screen: Screen){
        _currentScreen.value = screen
    }
}