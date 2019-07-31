package tz.co.asoft.kotlinhtml.staff

import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onSubmitFunction
import kotlinx.html.label
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.get
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.*
import tz.co.asoft.kotlinhtml.Staff
import kotlin.browser.document
import kotlin.js.Date
import tz.co.asoft.kotlinhtml.staff.StaffForm.Props as Props

class StaffForm : RComponent<Props, RState>() {

    object Props : RProps {
        var onStaffAdded = { _: Staff -> }
    }

    private val FORM_ID = "add-staff"

    private fun HTMLFormElement.getVal(id: String) = (get(id).unsafeCast<HTMLInputElement>()).value

    private fun submit() {
        val form = document.getElementById(FORM_ID) as HTMLFormElement
        console.dir(form)

        val staff = Staff().apply {
            name = form.getVal("name")
            date = Date(form.getVal("dob"))
            gender = form.getVal("gender")
            title = form.getVal("title")
            region = (form["region"] as HTMLSelectElement).value
        }
        console.log(staff)
        props.onStaffAdded(staff)
    }

    private fun RBuilder.form() = styledForm {
        css {
            display = Display.grid
            gridTemplateColumns = GridTemplateColumns("1fr 1fr")
            justifyContent = JustifyContent.center
            alignItems = Align.center

        }
        attrs.id = FORM_ID
        attrs.onSubmitFunction = {
            it.preventDefault()
            submit()
        }

        styledInput(type = InputType.text) {
            css {
                +StaffFormStyles.inputs
            }
            attrs {
                name = "name"
                placeholder = "Name"
                required = true
            }
        }

        styledSelect {
            css {
                +StaffFormStyles.inputs
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
                +StaffFormStyles.inputs
            }
            attrs {
                name = "dob"
                placeholder = "Date of Birth"
                required = true
            }
        }

        styledInput(type = InputType.text) {
            css {
                +StaffFormStyles.inputs
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
                    +StaffFormStyles.inputs
                }
                attrs {
                    name = "gender"
                    value = "Male"
                }
            }

            styledLabel {
                +"Male"
            }

        }


        styledDiv {

            styledInput(type = InputType.radio) {
                css {
                    color = Color.blue
                }
                attrs {
                    name = "gender"
                    value = "Female"
                }
            }

            styledLabel {
                +"Female"
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
        }
    }

    override fun RBuilder.render(): dynamic = styledDiv {
        +"Add Staff"
        css {
            margin(8.em)
            height = 100.vh
            textAlign = TextAlign.center
        }
        form()
    }
}