package hr.fvlahov.barsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import hr.fvlahov.barsapp.utils.BarUtils

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BarUtils.currentUser?.isAdmin?.let { createTabs(it) }
    }

    private fun createTabs(isAdmin: Boolean) {
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabNameInv)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabNameShifts)))

        if (isAdmin) {
            tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabNameAdmin)))
        }

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MainAdapter(
            this, supportFragmentManager,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}