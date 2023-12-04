package com.example.travel_agency.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.models.Tour
import com.example.travel_agency.TourAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BasketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasketFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toursList: RecyclerView = view.findViewById(R.id.toursList)
        val tours = arrayListOf<Tour>()

        tours.add(Tour(1,"Нидерланды", "Амстердам", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse elit velit, venenatis tempus egestas in, iaculis sed mi. Praesent ultrices blandit elit id pellentesque. Nulla nec odio at eros vehicula eleifend. Etiam posuere bibendum ante eget facilisis. Quisque sed sollicitudin eros, non rhoncus nisi. Vestibulum posuere dui sit amet justo mollis, vel finibus mauris blandit. Aliquam tincidunt nunc ac erat mattis posuere. Proin pharetra ante eget urna rutrum molestie. Maecenas ante tellus, sodales ac molestie ac, vehicula eget ligula.","21-11-2023", "24-11-2023",2,"5500 руб.","amsterdam"))
        tours.add(Tour(2,"Южная Корея", "Сеул", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse elit velit, venenatis tempus egestas in, iaculis sed mi. Praesent ultrices blandit elit id pellentesque. Nulla nec odio at eros vehicula eleifend. Etiam posuere bibendum ante eget facilisis. Quisque sed sollicitudin eros, non rhoncus nisi. Vestibulum posuere dui sit amet justo mollis, vel finibus mauris blandit. Aliquam tincidunt nunc ac erat mattis posuere. Proin pharetra ante eget urna rutrum molestie. Maecenas ante tellus, sodales ac molestie ac, vehicula eget ligula.","30-11-2023", "06-12-2023",1,"2500 руб.","southkorea"))

        toursList.layoutManager = LinearLayoutManager(requireContext())
        toursList.adapter = TourAdapter(tours, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BasketFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BasketFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}