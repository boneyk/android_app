package com.example.travel_agency.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.ViewModel.LoginViewModel
import com.example.travel_agency.ViewModel.RegViewModel
//import com.example.travel_agency.ViewModel.FaveViewModel
import com.example.travel_agency.ViewModel.ToursFragmentViewModel
import com.example.travel_agency.adapters.FaveListAdapter
//import com.example.travel_agency.adapters.FaveListAdapter
import com.example.travel_agency.adapters.TourListAdapter
import com.example.travel_agency.databinding.FragmentFaveBinding
import com.example.travel_agency.databinding.FragmentToursBinding
import com.example.travel_agency.models.TourFav
import com.example.travel_agency.models.Tours

class FaveFragment : Fragment() {

    private lateinit var binding: FragmentFaveBinding
    private lateinit var faveViewModel: FaveViewModel
    private lateinit var regViewModel: RegViewModel
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var tourFaveAdapter: FaveListAdapter
    private var list: List<TourFav> = emptyList()
    private var user_id: Int  = 1
    fun update(response : Int){
        user_id = response
    }
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


        if (user_id != null) {
            Log.d("MyLog", "получен id_user из id_token и передан в функцию findFavetour(id_user)")
            faveViewModel.findFavetour(user_id)
        } else {
            Log.d("MyLog", "Не удалось получить id_user из id_token")
        }
//        regViewModel.id_regToken.observe(viewLifecycleOwner, { id_user ->
////            id_user = loginViewModel.id_token.value!!
//            Log.d("MyLog", "получено значение токена и отправляется в запрос faveViewModel.findFavetour(id_user)")
//            faveViewModel.findFavetour(id_user)
//            Log.d("MyLog", "запрос выполнился")
//        })
//        if(loginViewModel.id_token.isInitialized) {
//            val id_user : Int = loginViewModel.id_token.value!!
//            Log.d("MyLog", "получено значение токена и отправляется в запрос faveViewModel.findFavetour(id_user)")
//            faveViewModel.findFavetour(id_user)
//            Log.d("MyLog", "запрос выполнился")
//        }else if(regViewModel.id_regToken.isInitialized){
//            val id_user : Int = regViewModel.id_regToken.value!!
//            faveViewModel.findFavetour(id_user)
//        }else{
//            Log.d("MyLog", "токен пользователя не удалось получить")
//        }
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