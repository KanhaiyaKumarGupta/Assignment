package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager


class ImageSliding : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager
    private val images = intArrayOf(
        R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
    )
    private lateinit var mViewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_sliding)

        mViewPager = findViewById(R.id.viewPagerMain)
        mViewPagerAdapter = ViewPagerAdapter(this, images)
        mViewPager.adapter = mViewPagerAdapter
    }
}
