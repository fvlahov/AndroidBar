package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.Database
import hr.fvlahov.barsapp.dal.interfaces.IRepository
import hr.fvlahov.barsapp.utils.BarUtils

class SqlRepo : IRepository {
    override fun readInventory() {
        var con = Database.getConnection()
        var stmt = con.prepareStatement("SELECT * FROM Inventory WHERE BarId = ?")
        stmt.setInt(1, BarUtils.currentBar.idBar)


        var rs = stmt.executeQuery()
    }

}