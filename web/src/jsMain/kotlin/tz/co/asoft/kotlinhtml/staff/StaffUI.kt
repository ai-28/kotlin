package tz.co.asoft.kotlinhtml.staff

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import styled.*
import tz.co.asoft.kotlinhtml.Staff
import tz.co.asoft.kotlinhtml.staff.StaffUI.Props as Props
import tz.co.asoft.kotlinhtml.staff.StaffUI.State as State

class StaffUI : RComponent<Props, State>() {

    object Props : RProps {
        var staff = Staff()
    }

    class State : RState {
        var currentUI = UI.Few
    }

    init {
        state = State()
    }

    enum class UI {
        Few,
        More
    }

    private fun RBuilder.few() = styledDiv {
        css {
            textAlign = TextAlign.center
            padding(10.px)
        }

        styledLabel {

            css {
                textAlign = TextAlign.center
                color = Color.white
            }

            +props.staff.name
            br { }
            +props.staff.title
        }
    }

    private fun RBuilder.more() = styledTable {

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
                +"Gender"
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
                +props.staff.gender
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
                +"D.O.B"
            }
            styledTd {
                css {
                    border = "1px solid white"
                }
                +props.staff.date.toDateString()
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
                +props.staff.region
            }
        }
    }

    private fun handleShowMore() = setState {
        currentUI = if (state.currentUI == UI.More) {
            UI.Few
        } else {
            UI.More
        }
    }

    override fun RBuilder.render(): dynamic = styledDiv {

        css {
            border = "solid 1px blue"
            width = 60.pct
            height = 60.vh
            padding(all = 85.px)
            margin(4.em)
            backgroundColor = Color("#1581d6")

        }

        few()

        if (state.currentUI == UI.More) {
            more()
        }

        styledDiv {
            css {
                textAlign = TextAlign.center
            }
            styledButton {
                css {
                    +StaffFormStyles.button
                }

                attrs.onClickFunction = { handleShowMore() }

                if (state.currentUI == UI.Few) {
                    +"Show More"
                } else {
                    +"Show Less"
                }
            }
        }
    }
}