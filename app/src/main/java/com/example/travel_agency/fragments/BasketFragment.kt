package com.example.travel_agency.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travel_agency.adapters.BasketListAdapter
import com.example.travel_agency.Memory
import com.example.travel_agency.ViewModel.BasketViewModel
import com.example.travel_agency.databinding.FragmentBasketBinding
import com.example.travel_agency.models.TourFav

class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var baskViewModel: BasketViewModel
    private lateinit var baskFaveAdapter: BasketListAdapter
    private var list: List<TourFav> = emptyList()
    private var user_id: Int  = 2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        baskViewModel = ViewModelProvider(this)[BasketViewModel::class.java]
        Log.d("MyLog", "binding = FragmentFaveBinding.inflate(inflater, container, false)")
        Log.d("MyLog", "создана viewmodelprovider в faveviewmodel")
        user_id = Memory(requireContext()).getUserId()
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