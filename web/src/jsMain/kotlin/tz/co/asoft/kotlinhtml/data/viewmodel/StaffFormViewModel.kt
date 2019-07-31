package tz.co.asoft.kotlinhtml.data.viewmodel

import tz.co.asoft.kotlinhtml.Staff
import tz.co.asoft.kotlinhtml.data.repo.StaffRepo

class StaffFormViewModel(private val repo: StaffRepo) {
    suspend fun create(staff: Staff) = repo.create(staff)
}