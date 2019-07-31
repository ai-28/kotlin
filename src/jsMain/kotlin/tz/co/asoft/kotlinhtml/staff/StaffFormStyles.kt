package tz.co.asoft.kotlinhtml.staff

import kotlinx.css.*
import styled.StyleSheet

object StaffFormStyles : StyleSheet("StaffFormStyles") {

    val mainDiv by css {

    }

    val inputs by css {
        margin(2.em)
        padding(all = 8.px)
        border = "solid 1px black"
        borderRadius = 5.px
    }

    val button by css {
        padding(5.px)
        color = Color.white
        backgroundColor = Color.blue
        borderRadius = 5.px
        margin(10.px)
    }

}