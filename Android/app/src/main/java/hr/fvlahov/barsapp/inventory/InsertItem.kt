package hr.fvlahov.barsapp.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.dal.implementations.ItemRepo
import hr.fvlahov.barsapp.model.Item
import hr.fvlahov.barsapp.model.UnitOfMeasurement


class InsertItem : DialogFragment() {

    companion object {
        const val TAG = "InserItem"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insert_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()

    }

    private fun initFragment() {
        val mySpinner = view?.findViewById<Spinner>(R.id.spinner_UOM)
        mySpinner?.adapter =
            ArrayAdapter<UnitOfMeasurement>(
                this.requireContext(),
                android.R.layout.simple_list_item_1,
                UnitOfMeasurement.values()
            )
        view?.findViewById<Button>(R.id.btn_InsertItemConfirm)
            ?.setOnClickListener { insertConfirm() }
        view?.findViewById<Button>(R.id.btn_InsertItemCancel)?.setOnClickListener { insertCancel() }
    }

    private fun insertConfirm() {
        ItemRepo().insertItem(
            Item(
                0,
                view?.findViewById<EditText>(R.id.et_ItemName)?.text.toString(),
                view?.findViewById<EditText>(R.id.et_MinSupply)?.text.toString().toInt(),
                0,
                view?.findViewById<Spinner>(R.id.spinner_UOM)?.selectedItem as UnitOfMeasurement
            )
        )
        this.dialog?.dismiss()
    }

    private fun insertCancel() {
        this.dialog?.dismiss()
    }
}