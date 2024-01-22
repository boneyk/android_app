package com.example.travel_agency.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_agency.adapters.BasketListAdapter
import com.example.travel_agency.ViewModel.BasketViewModel
import com.example.travel_agency.databinding.FragmentBasketBinding
import com.example.travel_agency.models.HistElement
import com.example.travel_agency.models.TourFav

class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var baskViewModel: BasketViewModel
    private lateinit var baskFaveAdapter: BasketListAdapter
    private var list: List<HistElement> = emptyList()
    private var user_id: String  = "1"

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        baskViewModel = ViewModelProvider(this)[BasketViewModel::class.java]
        Log.d("MyLog", "binding = FragmentFaveBinding.inflate(inflater, container, false)")
        Log.d("MyLog", "создана viewmodelprovider в faveviewmodel")
        sharedPref = requireContext().getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()
        user_id = sharedPref.getString("token", null)!!
        Log.d("MyLog", "значение3 = ${user_id}")
        baskViewModel.findHistTour(user_id)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baskViewModel = ViewModelProvider(this)[BasketViewModel::class.java]
        Log.d("MyLog", "создана onViewCreate")

        baskFaveAdapter = BasketListAdapter(list,requireContext())
        baskViewModel.Histtours.observe(viewLifecycleOwner, { tours ->
            if (tours.isNotEmpty()) {
                Log.d("MyLog", "туры получены, передаются в FaveAdapter")
                baskFaveAdapter.updateData(tours)
            } else {
                Toast.makeText(requireContext(), "Сегодня в нашем агентстве нет туров :(", Toast.LENGTH_LONG).show()
            }
        })
        binding.toursList.layoutManager = LinearLayoutManager(requireContext())
        binding.toursList.adapter = baskFaveAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = BasketFragment()
    }
}