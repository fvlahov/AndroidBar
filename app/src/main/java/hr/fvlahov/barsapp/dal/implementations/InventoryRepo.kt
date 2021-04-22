package hr.fvlahov.barsapp.dal.implementations

import hr.fvlahov.barsapp.dal.interfaces.IRepoInventory
import hr.fvlahov.barsapp.model.Inventory
import hr.fvlahov.barsapp.model.Item
import hr.fvlahov.barsapp.model.UnitOfMeasurement

class InventoryRepo : IRepoInventory {
    override fun getInventoryByBarId(barId: Int): Inventory {
        var list: List<Item> = listOf<Item>(
            Item(1, "Ožujsko", 20, 25, UnitOfMeasurement.BOTTLE),
            Item(2, "Kava", 2, 1, UnitOfMeasurement.KG),
            Item(3, "Mlijeko", 5, 6, UnitOfMeasurement.LITRE),
            Item(4, "Pelinkovac", 2, 3, UnitOfMeasurement.BOTTLE),
            Item(5, "Orahovac", 1, 1, UnitOfMeasurement.BOTTLE),
            Item(6, "Zlatni pan", 15, 10, UnitOfMeasurement.BOTTLE),
            Item(7, "Krušovice", 7, 8, UnitOfMeasurement.BOTTLE),
            Item(8, "Coca cola", 7, 10, UnitOfMeasurement.BOTTLE),
            Item(9, "Fanta", 5, 6, UnitOfMeasurement.BOTTLE),
            Item(10, "Sprite", 5, 6, UnitOfMeasurement.BOTTLE),
            Item(11, "Stella Artois", 5, 6, UnitOfMeasurement.BOTTLE)
        )
        return Inventory(1, list)
    }
}