package com.example.tourguide.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tourguide.R
import com.example.tourguide.databinding.FragmentDetailsBinding
import kotlin.math.abs

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<DetailsFragmentArgs>()
    private val place by lazy { args.place }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // if expanded make navigation icon of toolbar black and vice versa
            appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
                if ((abs(verticalOffset) - appBarLayout.totalScrollRange) == 0) {
                    // Collapsed
                    toolbar.setNavigationIconTint(resources.getColor(R.color.black, null))
                } else {
                    toolbar.setNavigationIconTint(resources.getColor(R.color.white, null))
                }
            }

            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }

            collapsingToolbar.title = place.name
            txtAddress.text = place.address
            txtOverview.text = place.overview
            imgToolbar.setImageResource(place.imageId)
        }
    }

}