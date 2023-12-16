package com.example.travel_agency.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.ViewModel.ToursFragmentViewModel
import com.example.travel_agency.adapters.TourListAdapter
import com.example.travel_agency.databinding.FragmentToursBinding
import com.example.travel_agency.models.Tours


class ToursFragment : Fragment() {

    private lateinit var binding: FragmentToursBinding
    private lateinit var mainViewModel: ToursFragmentViewModel
//    private val toursList: RecyclerView = binding.toursList
    private lateinit var tourListAdapter: TourListAdapter
    private var list: List<Tours> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToursBinding.inflate(inflater, container, false)
        Log.d("MyLog", "binding = FragmentToursBinding.inflate(inflater)")
        mainViewModel = ViewModelProvider(this)[ToursFragmentViewModel::class.java]
        Log.d("MyLog", "создана viewmodelprovider")
        mainViewModel.tryTours()
        Log.d("MyLog", "viewModel.trygetTours(binding)")
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tourListAdapter = TourListAdapter(list,requireContext())
        binding.toursList.layoutManager = LinearLayoutManager(requireContext())
        binding.toursList.adapter = tourListAdapter

        mainViewModel.tourList.observe(viewLifecycleOwner, Observer { tours ->
            if (tours.isNotEmpty()) {
                tourListAdapter.updateData(tours)
            } else {
                Toast.makeText(requireContext(), "Сегодня в нашем агентстве нет туров :(", Toast.LENGTH_LONG).show()
            }
        })
    }
    companion object {
        @JvmStatic
        fun newInstance() = ToursFragment()
    }
}