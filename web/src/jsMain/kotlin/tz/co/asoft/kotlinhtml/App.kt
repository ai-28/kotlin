package tz.co.asoft.kotlinhtml

import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import styled.css
import styled.styledDiv
import tz.co.asoft.kotlinhtml.App.State
import tz.co.asoft.kotlinhtml.home.Home
import tz.co.asoft.kotlinhtml.staff.StaffForm
import tz.co.asoft.kotlinhtml.staff.StaffUI
import tz.co.asoft.rx.subscriber.Subscriber
import tz.co.asoft.ui.module.ScopedRComponent
import tz.co.asoft.ui.theme.Theme
import tz.co.asoft.ui.theme.ThemeColors

class App : ScopedRComponent<RProps, State>() {
    private val viewModel = injectio.viewModel.app()

    class State : RState {
        var showing = UI.Home
        var staff = Staff()
        var staffs = mutableListOf<Staff>()
        var theme = Theme()
    }

    private val theme1 = Theme().apply {
        name = "Default Theme"
    }

    private val theme2 = Theme().apply {
        name = "Yellow Theme"
        primaryColor = ThemeColors(light = "#ffff5a", main = "#ffff00", dark = "#c7cc00")
        secondaryColor = ThemeColors()
        text.apply {
            onPrimary = ThemeColors(main = "#121212")
        }
    }

    private val themeList = listOf(theme1, theme2)

    init {
        state = State()
    }

    enum class UI {
        Home,
        StaffUI,
        StaffForm
    }

    override fun componentDidMount() {
        launch {
            viewModel.loadAll().subscribe { allStaffs->
                setState { staffs = allStaffs }
            }
        }
    }

    private fun RBuilder.navigation() = child(Navigation::class.js, Navigation.Props) {
        attrs.staffs = state.staffs
        attrs.onHomeClicked = {
            setState { showing = UI.Home }
        }

        attrs.onStaffClicked = {
            setState {
                staff = it
                showing = UI.StaffUI
            }
        }

        attrs.onAddStaff = {
            setState { showing = UI.StaffForm }
        }
    }

    private fun RBuilder.showHome() = child(Home::class) {}
    private fun RBuilder.showStaffUI() = child(StaffUI::class.js, StaffUI.Props) {
        attrs {
            staff = state.staff
        }
    }

    private fun RBuilder.showStaffForm() = child(StaffForm::class.js, StaffForm.Props) {
        attrs.theme = state.theme
        attrs.onStaffAdded = { _ ->

        }
    }

    private fun RBuilder.themes() = styledDiv {
        themeList.forEach { t ->
            styledDiv {
                css {
                    display = Display.inline
                    padding(1.em)
                }
                attrs.onClickFunction = {
                    setState { theme = t }
                }
                +t.name
            }
        }
    }

    private fun RBuilder.body() = styledDiv {
        css {
            width = 80.pct
        }
        themes()
        when (state.showing) {
            UI.Home -> showHome()
            UI.StaffUI -> showStaffUI()
            UI.StaffForm -> showStaffForm()
        }
    }

    override fun RBuilder.render(): dynamic = styledDiv {
        css {
            height = 100.vh
            display = Display.flex
        }
        navigation()
        body()
    }
}