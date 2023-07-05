package com.mukul.compose.temp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.getAndUpdate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("UNCHECKED_CAST")
class NavBundle {
    private val values = hashMapOf<String, Any>()
    fun put(key: String, value: Any) {
        values[key] = value
    }
    fun remove(key: String) {
        if(values.containsKey(key)) {
            values.remove(key)
        }
    }
    fun <T> read(key: String): T? {
        return if(values.containsKey(key)) {
            values[key] as T
        } else null
    }
}

abstract class Screen(open val host: NavHost) {
    abstract val route: String
    abstract var bundle: NavBundle?
    @Composable
    abstract fun present(modifier: Modifier)
}

class NavHost {
    private val _currentDestination = MutableStateFlow<Screen?>(null)
    val currentDestination: StateFlow<Screen?> get() = _currentDestination

    private val stack = mutableListOf<Screen>()
    private val destinations = mutableListOf<Screen>()

    fun addStartDestination(screen: Screen) {
        addDestination(screen)
        navigate(screen.route)
    }

    fun addDestination(screen: Screen) {
        if(!destinations.any { it.route == screen.route }) {
            destinations.add(screen)
        }
    }

    fun removeDestination(screen: Screen) {
        if(destinations.any { it.route == screen.route }) {
            destinations.remove(screen)
        }
    }

    fun navigate(route: String, bundle: NavBundle? = null) {
        val navigateTo = destinations.find { it.route == route }
        if (navigateTo != null && currentDestination.value?.route != navigateTo.route) {
            navigateTo.bundle = bundle
            if(stack.contains(navigateTo)) stack.remove(navigateTo)
            stack.add(navigateTo)
            _currentDestination.value = navigateTo
        }
    }

    fun navigateUp(bundle: NavBundle? = null) {
        val currentDestinationIndex = stack.indexOf(currentDestination.value)
        if(currentDestinationIndex > 0) {
            val navigateTo = stack[currentDestinationIndex - 1]
            if(bundle != null) navigateTo.bundle = bundle
            stack.removeAt(currentDestinationIndex)
            stack.add(navigateTo)
            _currentDestination.value = navigateTo
        }
    }
}

class GalleryScreen(
    override val host: NavHost,
    override var bundle: NavBundle?,
): Screen(host) {
    override val route: String get() = "gallery"

    @Composable
    override fun present(modifier: Modifier) {
        Column(modifier = modifier) {
            Text("Gallery")
            Button(onClick = {
                host.navigateUp()
            }) {
                Text("NavigateUp")
            }
        }
    }
}

class HomeScreen(
    override val host: NavHost,
    override var bundle: NavBundle?,
): Screen(host) {
    override val route: String get() = "home"

    @Composable
    override fun present(modifier: Modifier) {
        Column(modifier = modifier) {
            Text("Home")
            Button(onClick = {
                val bundle = NavBundle()
                bundle.put("id", "809")
                host.navigate("home/second", bundle)
            }) {
                Text("To Home/second")
            }
        }
    }
}

class HomeSecondScreen(
    override val host: NavHost,
    override var bundle: NavBundle?,
): Screen(host) {
    override val route: String get() = "home/second"

    @Composable
    override fun present(modifier: Modifier) {
        Column(modifier = modifier) {
            Text("Home/Second Bundle - ${bundle?.read<String>("id")}")
            Button(onClick = {
                host.navigate("gallery")
            }) {
                Text("To gallery")
            }
        }
    }
}

object NavController1 {
    val host = NavHost()

    init {
        host.addStartDestination(Screen.homeScreen)
        host.addDestination(Screen.galleryScreen)
        host.addDestination(Screen.homeSecondScreen)
    }

    object Screen {
        val homeScreen = HomeScreen(host, null)
        val galleryScreen = GalleryScreen(host, null)
        val homeSecondScreen = HomeSecondScreen(host, null)
    }
}

object NavController2 {
    val host = NavHost()

    init {
        host.addStartDestination(Screen.homeScreen)
        host.addDestination(Screen.galleryScreen)
        host.addDestination(Screen.homeSecondScreen)
    }

    object Screen {
        val homeScreen = HomeScreen(host, null)
        val galleryScreen = GalleryScreen(host, null)
        val homeSecondScreen = HomeSecondScreen(host, null)
    }
}

@Composable
fun NavigationMainView() {
    Column(modifier = Modifier.fillMaxSize().padding(50.dp)) {
        val host1 = NavController1.host
        val screen1 = host1.currentDestination.collectAsState()
        screen1.value
            ?.present(modifier = Modifier.weight(0.5f).background(Color.Blue.copy(0.3f)))

        val host2 = NavController2.host
        val screen2 = host2.currentDestination.collectAsState()
        screen2.value
            ?.present(modifier = Modifier.weight(0.5f).background(Color.Cyan.copy(0.3f)))
    }
}