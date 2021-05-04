package hr.fvlahov.barsapp.inventory

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.dal.implementations.ItemRepo
import hr.fvlahov.barsapp.model.Item

private const val ARG_PARAM = "item"


class UpdateItems : DialogFragment() {

    var item: Item? = null
    var initialSupply : Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_items, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getSerializable(ARG_PARAM)?.let {
            item = it as Item
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialSupply = item?.currentSupply

        view.findViewById<TextView>(R.id.tv_ItemName).text = item?.name
        view.findViewById<TextView>(R.id.tv_CurrentSupply).text = item?.currentSupply.toString()
        view.findViewById<Button>(R.id.btn_Add).setOnClickListener { updateCurrentSupply(view, 1) }
        view.findViewById<Button>(R.id.btn_Remove)
            .setOnClickListener { updateCurrentSupply(view, -1) }
        view.findViewById<Button>(R.id.btn_UpdateItemConfirm)
            .setOnClickListener { confirmUpdateItem(view) }
        view.findViewById<Button>(R.id.btn_UpdateItemCancel)
            .setOnClickListener { cancelUpdateItem(view) }
    }

    companion object {
        @JvmStatic
        fun newInstance(item: Item) =
            UpdateItems().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, item)
                }
            }

        const val TAG = "UpdateItemsDialog"
    }

    private fun updateCurrentSupply(view: View, value: Int) {
        item?.currentSupply = item?.currentSupply!!.plus(value)
        view.findViewById<TextView>(R.id.tv_CurrentSupply).text = item?.currentSupply.toString()
    }

    private fun confirmUpdateItem(view: View) {
        view.findViewById<TextView>(R.id.tv_CurrentSupply).text = item?.currentSupply.toString()
        this.dialog?.dismiss()

    }

    private fun cancelUpdateItem(view: View) {
        item?.currentSupply = initialSupply!!
        this.dialog?.dismiss()
    }
}