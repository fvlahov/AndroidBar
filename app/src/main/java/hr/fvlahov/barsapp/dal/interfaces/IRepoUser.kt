package hr.fvlahov.barsapp.dal.interfaces

import hr.fvlahov.barsapp.model.User

interface IRepoUser {
    fun authenticateUser(userName: String, password: String) : User

}