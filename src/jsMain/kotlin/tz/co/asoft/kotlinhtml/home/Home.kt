package tz.co.asoft.kotlinhtml.home

import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv

class Home : RComponent<RProps, RState>() {
    override fun RBuilder.render(): dynamic = styledDiv {
        css {
            fontSize = 6.em
            height = 100.pct
            display = Display.flex
            justifyContent = JustifyContent.center
            alignItems = Align.center
        }
        +"aSoft Staff"
    }
}