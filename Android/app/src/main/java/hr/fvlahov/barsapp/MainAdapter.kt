package hr.fvlahov.barsapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hr.fvlahov.barsapp.administration.Administration
import hr.fvlahov.barsapp.inventory.InventoryController
import hr.fvlahov.barsapp.shifts.Shifts

@Suppress("DEPRECATION")
internal class MainAdapter(
        var context: Context,
        fm: FragmentManager,
        var totalTabs: Int
) :
        FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                InventoryController()
            }
            1 -> {
                Shifts()
            }
            2 -> {
                Administration()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}