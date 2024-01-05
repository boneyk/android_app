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
import com.example.travel_agency.Memory
import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.ViewModel.LoginViewModel
import com.example.travel_agency.ViewModel.RegViewModel
//import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.adapters.FaveListAdapter
//import com.example.travel_agency.adapters.FaveListAdapter
import com.example.travel_agency.databinding.FragmentFaveBinding
import com.example.travel_agency.models.TourFav

class FaveFragment : Fragment() {

    private lateinit var binding: FragmentFaveBinding
    private lateinit var faveViewModel: FaveViewModel
    private lateinit var regViewModel: RegViewModel
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var tourFaveAdapter: FaveListAdapter
    private var list: List<TourFav> = emptyList()
    private var user_id: String  = "1"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFaveBinding.inflate(inflater, container, false)
        Log.d("MyLog", "binding = FragmentFaveBinding.inflate(inflater, container, false)")
        faveViewModel = ViewModelProvider(this)[FaveViewModel::class.java]
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        Log.d("MyLog", "создана viewmodelprovider в faveviewmodel")
        user_id = Memory(requireContext()).getUserId()
        Log.d("MyLog", "значение3 = ${user_id}")
        faveViewModel.findFavetour(user_id)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        regViewModel = ViewModelProvider(this)[RegViewModel::class.java]
        faveViewModel = ViewModelProvider(this)[FaveViewModel::class.java]
        Log.d("MyLog", "создана onViewCreate")

        tourFaveAdapter = FaveListAdapter(list,requireContext())
        faveViewModel.Favetours.observe(viewLifecycleOwner, { tours ->
            if (tours.isNotEmpty()) {
                Log.d("MyLog", "туры получены, передаются в FaveAdapter")
                tourFaveAdapter.updateData(tours)
            } else {
                Toast.makeText(requireContext(), "Сегодня в нашем агентстве нет туров :(", Toast.LENGTH_LONG).show()
            }
        })
        binding.toursList.layoutManager = LinearLayoutManager(requireContext())
        binding.toursList.adapter = tourFaveAdapter
    }
    companion object {
        @JvmStatic
        fun newInstance() = FaveFragment()
    }
}