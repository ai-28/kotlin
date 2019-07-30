package tz.co.asoft.kotlinhtml

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.br
import styled.css
import styled.styledDiv
import tz.co.asoft.kotlinhtml.Navigation.Props

class Navigation : RComponent<Props, RState>() {
    object Props : RProps {
        var onHomeClicked = {}
        var onAddStaff = {}
        var onStaffClicked = {}
    }

    private fun RBuilder.addStaff() = styledDiv {
        css {
            +AppStyles.menuItems
            marginTop = 2.em
            textAlign = TextAlign.center
        }
        attrs.onClickFunction = {
            props.onAddStaff()
        }
        +"+"
        br { }
        +"Add Staff"
    }

    private fun RBuilder.menuItem(title: String) = styledDiv {
        css {
            +AppStyles.menuItems
        }
        attrs.onClickFunction = {
            props.onStaffClicked()
        }
        +title
    }

    override fun RBuilder.render(): dynamic = styledDiv {
        css {
            width = 20.pct
            backgroundColor = Color("#1581d6")
        }
        styledDiv {
            css {
                height = 10.pct
                fontSize = 1.5.rem
                color = Color.white
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = Align.center
                marginBottom = 1.em
            }
            attrs.onClickFunction = {
                props.onHomeClicked()
            }
            +"aSoft Staff"
        }

        menuItem("Andy")
        menuItem("Luge")
        menuItem("Justine")
        addStaff()
    }
}