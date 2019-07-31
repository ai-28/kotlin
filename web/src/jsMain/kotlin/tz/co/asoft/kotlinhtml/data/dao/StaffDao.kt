package tz.co.asoft.kotlinhtml.data.dao

import kotlinx.coroutines.delay
import tz.co.asoft.kotlinhtml.Staff
import tz.co.asoft.rx.observers.ObservableList
import kotlin.js.Date

class StaffDao private constructor() {

    companion object {
        private var instance: StaffDao? = null
        fun getInstance() = instance ?: StaffDao().also {
            instance = it
        }
    }

    private val staffs = ObservableList(
            Staff().apply {
                name = "Eminem"
                title = "Entertainer"
                date = Date()
                gender = "Male"
                region = "Detroit"
            },
            Staff().apply {
                name = "Drake"
                title = "Entertainer"
                date = Date()
                gender = "Male"
                region = "Detroit"
            }
    )

    suspend fun create(staff: Staff): Staff? {
        delay(1000L)
        staffs.add(staff)
        return staff
    }

    suspend fun edit(staff: Staff): Staff? {
        delay(200L)
        return staff
    }

    suspend fun load(id: Any) = staffs.value.firstOrNull { it.id == it.toString() }

    suspend fun delete(staff: Staff): Staff? {
        staffs.remove(staff)
        return staff
    }

    suspend fun loadAll(): ObservableList<Staff> {
        return staffs
    }
}