package hr.fvlahov.barsapp.dal.interfaces

import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User

interface IRepoBar {
    fun getBarByUserId(userId: Int) : Bar
}