package tz.co.asoft.kotlinhtml.staff

import kotlinx.coroutines.launch
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
import tz.co.asoft.kotlinhtml.injectio
import tz.co.asoft.ui.module.ScopedRComponent
import tz.co.asoft.ui.react.widget.button.primaryButton
import tz.co.asoft.ui.react.widget.dateinput.dateInput
import tz.co.asoft.ui.react.widget.dropdown.dropDown
import tz.co.asoft.ui.react.widget.radio.radioButton
import tz.co.asoft.ui.react.widget.text.textinput.textInput
import tz.co.asoft.ui.theme.Theme
import kotlin.browser.document
import kotlin.js.Date
import tz.co.asoft.kotlinhtml.staff.StaffForm.Props as Props

class StaffForm : ScopedRComponent<Props, RState>() {

    private val viewModel = injectio.viewModel.staffForm()

    object Props : RProps {
        var onStaffAdded = { _: Staff -> }
        var theme = Theme()
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
        sendStaffToDb(staff)
    }

    private fun sendStaffToDb(staff: Staff) = launch {
        viewModel.create(staff)
        props.onStaffAdded(staff)
    }

    private fun RBuilder.form() = styledForm {
        css {
            display = Display.grid
            gap = Gap("1em")
            gridTemplateColumns = GridTemplateColumns("1fr 1fr")
            justifyContent = JustifyContent.center
            alignItems = Align.center

        }
        attrs.id = FORM_ID
        attrs.onSubmitFunction = {
            it.preventDefault()
            submit()
        }

        textInput {
            attrs {
                theme = props.theme
                name = "name"
                hint = "John Doe"
                label = "Enter full Name"
            }
        }

        dropDown {
            attrs {
                theme = props.theme
                name = "region"
            }
            attrs.options = listOf(
                    "Select a Region",
                    "Dar",
                    "Arusha",
                    "Mwanza",
                    "Kigoma"
            )
        }

        dateInput {
            attrs {
                theme = props.theme
                name = "dob"
                label = "Date of Birth"
            }
        }

        textInput {
            attrs {
                theme = props.theme
                name = "title"
                label = "title"
            }
        }

        styledDiv {
            radioButton("Male") {
                attrs {
                    theme = props.theme
                    name = "gender"
                    value = "Male"
                }
            }
        }


        styledDiv {
            radioButton("Female") {
                attrs {
                    theme = props.theme
                    name = "gender"
                    value = "Female"
                }
            }
        }

        primaryButton("Submit") {
            attrs.css = {
                gridColumn = GridColumn("2/3")
            }
            attrs {
                theme = props.theme
                isSubmit = true
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