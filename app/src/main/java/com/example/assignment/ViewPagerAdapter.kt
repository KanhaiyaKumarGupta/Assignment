package com.example.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val context: Context, private val images: IntArray) : PagerAdapter() {
    private val mLayoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Inflating the item.xml
        val itemView = mLayoutInflater.inflate(R.layout.item, container, false)

        // Referencing the ImageView from the item.xml file
        val imageView = itemView.findViewById<ImageView>(R.id.imageViewMain)

        // Setting the image in the ImageView
        imageView.setImageResource(images[position])

        // Adding the View
        container.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}
