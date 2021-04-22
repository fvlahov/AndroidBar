package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.interfaces.IRepoBar
import hr.fvlahov.barsapp.model.Bar
import hr.fvlahov.barsapp.model.User

class BarRepo : IRepoBar{
    override fun getBarByUserId(userId: Int): Bar {
        return Bar(1,"Pivnica Toni", InventoryRepo().getInventoryByBarId(1))
    }
}