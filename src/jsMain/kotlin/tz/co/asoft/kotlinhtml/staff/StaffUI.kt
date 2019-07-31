package tz.co.asoft.kotlinhtml.staff

import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.*

class StaffUI : RComponent<RProps, RState>() {

//    private fun RBuilder.staffDetails() = styledDiv {
//
//    }
    override fun RBuilder.render(): dynamic = styledDiv {

        css {
            border = "solid 1px blue"
            width = 60.pct
            height = 60.vh
            padding(all= 85.px)
            margin(4.em)
            backgroundColor = Color("#1581d6")

        }

    styledDiv {

        css {
            textAlign = TextAlign.center
            padding(10.px)
        }

        styledLabel {

            css{
                textAlign = TextAlign.center
                color = Color.white
            }

            + "Name"
            br {  }
            + "Title"
        }
    }

    styledTable {

        css {
            width = 100.pct
            color = Color.black
            borderColor = Color.white
        }

        styledTr {
            css {
                border = "1px solid white"
                backgroundColor = Color.white
                width = 50.pct
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
                + "Gender"
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
            }
        }
        styledTr {
            css {
                border = "1px solid white"
                backgroundColor = Color.white
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
                + "D.O.B"
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
            }
        }
        styledTr {
            css {
                border = "1px solid white"
                backgroundColor = Color.white
            }
            styledTd {
                +"Region"
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
            }
        }
    }
        styledDiv {
            css {
                textAlign = TextAlign.center
            }
            styledButton {
                css {
                    + StaffFormStyles.button
                }
                + "Show More"
            }
        }
    }
}