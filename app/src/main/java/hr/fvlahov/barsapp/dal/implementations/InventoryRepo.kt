package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.interfaces.IRepoInventory
import hr.fvlahov.barsapp.model.Inventory
import hr.fvlahov.barsapp.model.Item
import hr.fvlahov.barsapp.model.UnitOfMeasurement

class InventoryRepo : IRepoInventory {
    override fun getInventoryByBarId(barId: Int): Inventory {
        var list : List<Item> = listOf<Item>(
            Item(1, "Ožujsko", 20, UnitOfMeasurement.BOTTLE),
            Item(2, "Kava", 2, UnitOfMeasurement.KG),
            Item(3, "Mlijeko", 5, UnitOfMeasurement.LITRE)
        )
        return Inventory(1, list)
    }
}