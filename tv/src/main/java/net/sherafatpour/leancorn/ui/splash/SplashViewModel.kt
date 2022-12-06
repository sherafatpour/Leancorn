package net.sherafatpour.leancorn.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.sherafatpour.leancorn.util.flow.mutableEventFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor():ViewModel() {

    private val _shouldGoToHome= mutableEventFlow<Boolean>()
    val shouldGoToHome=_shouldGoToHome.asSharedFlow()

    init {
        viewModelScope.launch {  delay(1500)
        _shouldGoToHome.tryEmit(true)
        }
    }


}