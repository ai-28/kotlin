package tz.co.asoft.kotlinhtml.staff

import kotlinx.html.InputType
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.*

class StaffForm : RComponent<RProps, RState>() {

    override fun RBuilder.render(): dynamic = styledForm {
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
            attrs {
                name = "title"
                placeholder = "title"
                required = true
            }
        }

        styledInput(type = InputType.submit) {
            attrs {
                value = "Submit"
            }
        }
    }
}