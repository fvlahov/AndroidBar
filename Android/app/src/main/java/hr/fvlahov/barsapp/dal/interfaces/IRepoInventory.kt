package hr.fvlahov.barsapp.dal.interfaces

import hr.fvlahov.barsapp.model.Inventory

interface IRepoInventory {
    fun getInventoryByBarId(barId: Int): Inventory
}