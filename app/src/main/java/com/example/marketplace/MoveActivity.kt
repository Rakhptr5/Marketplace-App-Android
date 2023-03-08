package com.example.marketplace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
class MoveActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)
        supportActionBar?.hide()


            tabLayout = findViewById(R.id.tabs)
            viewPager = findViewById(R.id.view_pager)
            tabLayout.addTab(tabLayout.newTab().setText("Register"))
            tabLayout.addTab(tabLayout.newTab().setText("Welcome"))
            tabLayout.tabGravity = TabLayout.GRAVITY_FILL
            val adapter = ViewPagerAdapter(
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
