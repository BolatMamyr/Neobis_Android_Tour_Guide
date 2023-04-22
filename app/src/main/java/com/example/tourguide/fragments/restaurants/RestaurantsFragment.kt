package com.example.tourguide.fragments.restaurants

import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourguide.R
import com.example.tourguide.adapters.RvAdapter
import com.example.tourguide.databinding.FragmentMainBinding
import com.example.tourguide.databinding.FragmentRestaurantsBinding
import com.example.tourguide.fragments.MainFragment
import com.example.tourguide.fragments.MainFragmentDirections
import com.example.tourguide.model.Place

class RestaurantsFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = RvAdapter()
        binding.rvRestaurants.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
                )
            setHasFixedSize(true)
        }
        mAdapter.updateData(getRestaurants())
        mAdapter.onItemClick = { place ->
            place?.let {
                val action = MainFragmentDirections.actionMainFragmentToDetailsFragment(place)
                findNavController().navigate(action)
            }
        }
    }

    private fun getRestaurants(): List<Place> {
        return listOf(
            Place("More&More",
                R.drawable.more_and_more,
                getString(R.string.more_and_more_address),
                getString(R.string.more_and_more_overview),
                "24:00"
                ),
            Place("Manana",
                R.drawable.manana,
                getString(R.string.more_and_more_address),
                getString(R.string.manana_overview),
                "23:00"
            ),
            Place("Pugasov",
                R.drawable.pugasov,
                getString(R.string.pugasov_address),
                getString(R.string.pugasov_overview),
                "22:00"
            ),
            Place("Little Brazil",
                R.drawable.little_brazil,
                getString(R.string.little_brazil_address),
                getString(R.string.little_brazil_overview),
                "02:00"
            ),
            Place("Erbil",
                R.drawable.erbil1,
                getString(R.string.erbil_address),
                getString(R.string.erbil_overview),
                "24:00"
            ),
            Place("Storia",
                R.drawable.storia,
                getString(R.string.storia_address),
                getString(R.string.storia_overview),
                "23:00"
            )
        )
    }

}