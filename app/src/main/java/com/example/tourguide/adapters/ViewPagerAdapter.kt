package com.example.tourguide.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tourguide.fragments.cinemas.CinemasFragment
import com.example.tourguide.fragments.fitness.FitnessCentersFragment
import com.example.tourguide.fragments.restaurants.RestaurantsFragment

class ViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RestaurantsFragment()
            1 -> FitnessCentersFragment()
            else -> CinemasFragment()
        }
    }
}