package tz.co.asoft.kotlinhtml.staff

import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.label
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.*

class StaffForm : RComponent<RProps, RState>() {

    private fun RBuilder.form() =styledForm {
        css{
            display = Display.grid
            gridTemplateColumns = GridTemplateColumns("1fr 1fr")
            justifyContent = JustifyContent.center
            alignItems = Align.center

        }
        attrs.id = "add-staff"


        styledInput(type = InputType.text) {
            css {
                + StaffFormStyles.inputs
            }
            attrs {
                name = "name"
                placeholder = "Name"
                required = true
            }
        }

        styledSelect {
            css{
                + StaffFormStyles.inputs
            }
            attrs {
                name = "region"
                required = true
            }
            styledOption {
                attrs { value = "" }
                +"Select Region"
            }
            styledOption { +"Dar" }
            styledOption { +"Arusha" }
            styledOption { +"Mwanza" }
        }

        styledInput(type = InputType.date) {
            css {
                + StaffFormStyles.inputs
            }
            attrs {
                name = "dob"
                placeholder = "Date of Birth"
                required = true
            }
        }

        styledInput(type = InputType.text) {
            css {
                + StaffFormStyles.inputs
            }
            attrs {
                name = "title"
                placeholder = "title"
                required = true
            }
        }

        styledDiv {
            styledInput(type = InputType.radio) {
                css {
                    + StaffFormStyles.inputs
                }
                attrs {
                    name = "gender"
                    value = "Male"
                }
            }

            styledLabel {
                + "Male"
            }

        }


        styledDiv {

            styledInput (type = InputType.radio) {
                css {
                    color = Color.blue
                }
                attrs {
                    name = "gender"
                    value = "Female"
                }
            }

            styledLabel {
                + "Female"
            }
        }


        styledInput(type = InputType.submit) {
            css {
                gridColumn = GridColumn("2/3")
                color = Color.white
                backgroundColor = Color("#1581d6")
                margin(2.em)
                padding(all = 8.px)
                border = "solid 1px black"
                borderRadius = 5.px
            }
            attrs {
                value = "Submit"
            }
        } }

    override fun RBuilder.render(): dynamic = styledDiv {
        + "Add Staff"
        css{
            margin(8.em)
            height = 100.vh
            textAlign = TextAlign.center
        }
        form()
    }
}