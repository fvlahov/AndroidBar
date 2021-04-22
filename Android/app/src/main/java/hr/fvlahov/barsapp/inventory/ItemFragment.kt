package hr.fvlahov.barsapp.inventory

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import hr.fvlahov.barsapp.R
import hr.fvlahov.barsapp.model.Item


private const val ARG_PARAM = "item"

class ItemFragment : Fragment() {
    var item: Item? = null

    companion object {
        @JvmStatic
        fun newInstance(item: Item) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, item)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getSerializable(ARG_PARAM)?.let {
            item = it as Item
        }
    }

    private fun initFragment() {
        view?.findViewById<Button>(R.id.btn_ShowAddMenu)?.setOnClickListener { showAddMenu(requireView()) }

        view?.findViewById<TextView>(R.id.tv_ItemName)?.text = item?.name
        view?.findViewById<TextView>(R.id.tv_CurrentSupply)?.text = StringBuilder().append(
            item?.currentSupply.toString(), " ", item?.unitOfMeasurement?.getCorrectMeasure(
                item?.currentSupply
            )
        )
        view?.findViewById<TextView>(R.id.tv_MinSupply)?.text = StringBuilder().append(
            item?.minSupply.toString(), " ", item?.unitOfMeasurement?.getCorrectMeasure(
                item?.minSupply
            )
        )
    }

    private fun showAddMenu(view: View) {
        var updateItems = UpdateItems.newInstance(item!!)
        updateItems.show(childFragmentManager, UpdateItems.TAG)
    }
}