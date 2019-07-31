package tz.co.asoft.kotlinhtml

import kotlinx.css.*
import styled.StyleSheet

object AppStyles : StyleSheet("app") {
    val menuItems by css {
        fontSize = 1.2.rem
        display = Display.flex
        justifyContent = JustifyContent.center
        alignItems = Align.center
        color = Color.white
        border = "solid 1px blue"
        padding(all = 8.px)
        borderRadius = 5.px
        cursor = Cursor.pointer
        margin(vertical = 4.px, horizontal = 4.px)
    }
}