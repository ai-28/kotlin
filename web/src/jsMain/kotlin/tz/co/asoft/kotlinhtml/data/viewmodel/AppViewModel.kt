package tz.co.asoft.kotlinhtml.data.viewmodel

import tz.co.asoft.kotlinhtml.data.repo.StaffRepo

class AppViewModel(private val repo: StaffRepo) {
    suspend fun loadAll() = repo.loadAll()
}