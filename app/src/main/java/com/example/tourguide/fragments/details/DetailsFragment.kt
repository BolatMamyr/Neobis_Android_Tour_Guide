package com.example.tourguide.fragments.details

import android.content.Intent
import android.net.Uri
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
import java.util.*
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
        setOnNavigationIconClickListener()
        setNavIconColor()
        setPlaceInfo()
        openMap()
    }

    // if expanded make navigation icon of toolbar black and vice versa
    private fun setNavIconColor() {
        binding.apply {
            appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
                if ((abs(verticalOffset) - appBarLayout.totalScrollRange) == 0) {
                    // Collapsed
                    toolbar.setNavigationIconTint(resources.getColor(R.color.black, null))
                } else {
                    toolbar.setNavigationIconTint(resources.getColor(R.color.white, null))
                }
            }
        }
    }

    private fun setOnNavigationIconClickListener() {
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    private fun setPlaceInfo() {
        binding.apply {
            collapsingToolbar.title = place.name
            txtAddress.text = place.address

            val openUntil = getString(R.string.openUntil) + place.time
            txtOpenUntil.text = openUntil
            val distance = String.format(Locale.FRANCE, "%.1f", place.distance) +
                    getString(R.string.kilometers)
            txtDetailsDistance.text = distance
            val aveBill = getString(R.string.average_bill) +
                    place.averageBill + getString(R.string.tenge)
            txtAverageBill.text = aveBill
            txtCuisine.text = place.cuisine
            txtOverview.text = place.overview
            imgToolbar.setImageResource(place.imageId)
        }
    }

    private fun openMap() {
        binding.txtAddress.setOnClickListener {
            Intent(Intent.ACTION_VIEW).also { intent ->
                intent.data = Uri.parse("geo:${place.latitude},${place.longitude}")
                startActivity(Intent.createChooser(intent, "Choose an app"))
//                if (intent.resolveActivity(requireActivity().packageManager) != null) {
//                }
            }
        }
    }
}