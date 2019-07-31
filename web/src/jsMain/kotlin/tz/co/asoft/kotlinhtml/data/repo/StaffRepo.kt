package tz.co.asoft.kotlinhtml.data.repo

import tz.co.asoft.kotlinhtml.Staff
import tz.co.asoft.kotlinhtml.data.dao.StaffDao

class StaffRepo private constructor(private val dao: StaffDao) {
    companion object {
        var instance: StaffRepo? = null
        fun getInstance(dao: StaffDao) = instance ?: StaffRepo(dao).also {
            instance = it
        }
    }

    suspend fun create(staff: Staff) = dao.create(staff)

    suspend fun edit(staff: Staff) = dao.edit(staff)

    suspend fun load(id: Any) = dao.load(id)

    suspend fun delete(staff: Staff) = dao.delete(staff)

    suspend fun loadAll() = dao.loadAll()
}