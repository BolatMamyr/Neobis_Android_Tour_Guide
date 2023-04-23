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
                "24:00",
                1.5,
                4500,
                "Морепродукты",
                "43.2182375669765",
                "76.9645552894261"
                ),
            Place("Manana",
                R.drawable.manana,
                getString(R.string.more_and_more_address),
                getString(R.string.manana_overview),
                "23:00",
                8.0,
                5000,
                "Европейская и восточная кухня",
                "43.203699533618426",
                "76.97674167364616"
            ),
            Place("Pugasov",
                R.drawable.pugasov,
                getString(R.string.pugasov_address),
                getString(R.string.pugasov_overview),
                "22:00",
                9.0,
                3500,
                "Европейская и восточная кухня",
                "43.25412728312345",
                "76.96052277382388"
            ),
            Place("Little Brazil",
                R.drawable.little_brazil,
                getString(R.string.little_brazil_address),
                getString(R.string.little_brazil_overview),
                "02:00",
                13.0,
                8000,
                "Бразильская кухня",
                "43.21383522478644",
                "76.92254980216582"
            ),
            Place("Erbil",
                R.drawable.erbil1,
                getString(R.string.erbil_address),
                getString(R.string.erbil_overview),
                "24:00",
                2.0,
                2500,
                "Европейская и восточная кухня",
                "43.33729430551487",
                "76.94885264758564"
            ),
            Place("Storia",
                R.drawable.storia,
                getString(R.string.storia_address),
                getString(R.string.storia_overview),
                "23:00",
                4.6,
                5000,
                "Итальянская кухня",
                "43.25676758635216",
                "76.96019803942696"
            )
        )
    }

}