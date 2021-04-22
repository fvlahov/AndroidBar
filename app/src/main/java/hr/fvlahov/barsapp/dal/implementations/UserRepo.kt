package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.interfaces.IRepoUser
import hr.fvlahov.barsapp.model.User

class UserRepo : IRepoUser {
    override fun authenticateUser(userName: String, password: String): User {
        return User(1, "admin", "a", "Franko", true, BarRepo().getBarByUserId(1))
    }

}