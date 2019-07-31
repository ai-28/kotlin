package tz.co.asoft.kotlinhtml

import tz.co.asoft.kotlinhtml.data.dao.StaffDao
import tz.co.asoft.kotlinhtml.data.repo.StaffRepo
import tz.co.asoft.kotlinhtml.data.viewmodel.AppViewModel
import tz.co.asoft.kotlinhtml.data.viewmodel.StaffFormViewModel

object injectio {
    object dao {
        fun staff() = StaffDao.getInstance()
    }

    object repo {
        fun staff() = StaffRepo.getInstance(dao.staff())
    }

    object viewModel {
        fun app() = AppViewModel(repo.staff())
        fun staffForm() = StaffFormViewModel(repo.staff())
    }
}