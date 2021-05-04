package hr.fvlahov.barsapp.dal.interfaces

import hr.fvlahov.barsapp.model.User

interface IRepoShifts {
    fun getShifts(user: User)
}