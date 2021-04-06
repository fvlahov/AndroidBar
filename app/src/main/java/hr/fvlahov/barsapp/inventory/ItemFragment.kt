package hr.fvlahov.barsapp.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.model.Item

private const val ARG_PARAM = "item"

class ItemFragment : Fragment() {
    private var item: Item? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(item: Item) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, item)
                }
            }
    }
}