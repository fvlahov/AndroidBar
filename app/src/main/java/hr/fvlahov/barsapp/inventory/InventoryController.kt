package hr.fvlahov.barsapp.inventory

import android.opengl.Visibility
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import com.google.android.material.snackbar.Snackbar
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.dal.implementations.InventoryRepo
import hr.fvlahov.barsapp.utils.BarUtils

class InventoryController : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Get Inventory
        var inventory = InventoryRepo().getInventoryByBarId(BarUtils.currentUser.bar.idBar)
        var itemLayout = view.findViewById<LinearLayout>(R.id.ll_Items)
        for(item in inventory.items){
            var fragMan = childFragmentManager
            var fragTransaction = fragMan.beginTransaction()

            var myFrag = ItemFragment.newInstance(item)
            fragTransaction.add(itemLayout?.id!!, myFrag);
            fragTransaction.commit()

        }

        val fab: View = view.findViewById(R.id.fab_Add)
        if(!BarUtils.currentUser.isAdmin){
            fab.visibility = View.INVISIBLE
        }
        fab.setOnClickListener { view ->
            InsertItem().show(childFragmentManager, InsertItem.TAG)
        }
    }
}