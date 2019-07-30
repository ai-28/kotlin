package tz.co.asoft.kotlinhtml

import kotlinx.css.*
import react.*
import styled.css
import styled.styledDiv
import tz.co.asoft.kotlinhtml.App.State
import tz.co.asoft.kotlinhtml.home.Home
import tz.co.asoft.kotlinhtml.staff.StaffForm
import tz.co.asoft.kotlinhtml.staff.StaffUI

class App : RComponent<RProps, State>() {
    class State : RState {
        var showing = UI.Home
    }

    init {
        state = State()
    }

    enum class UI {
        Home,
        StaffUI,
        StaffForm
    }

    private fun RBuilder.navigation() = child(Navigation::class.js, Navigation.Props) {
        attrs.onHomeClicked = {
            setState { showing = UI.Home }
        }

        attrs.onStaffClicked = {
            setState { showing = UI.StaffUI }
        }

        attrs.onAddStaff = {
            setState { showing = UI.StaffForm }
        }
    }

    private fun RBuilder.showHome() = child(Home::class) {}
    private fun RBuilder.showStaffUI() = child(StaffUI::class) {}
    private fun RBuilder.showStaffForm() = child(StaffForm::class) {}

    private fun RBuilder.body() = styledDiv {
        css {
            width = 80.pct
        }
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