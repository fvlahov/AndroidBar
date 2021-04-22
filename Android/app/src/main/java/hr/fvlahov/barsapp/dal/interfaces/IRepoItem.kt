package hr.fvlahov.barsapp.dal.interfaces

import hr.fvlahov.barsapp.model.Item


interface IRepoItem {
    fun updateItem(item : Item)
    fun insertItem(item: Item)
}