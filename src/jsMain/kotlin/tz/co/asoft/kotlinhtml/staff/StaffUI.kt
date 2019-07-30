package tz.co.asoft.kotlinhtml.staff

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.styledDiv

class StaffUI : RComponent<RProps, RState>() {
    override fun RBuilder.render(): dynamic = styledDiv {
        +"Staff here"
    }
}