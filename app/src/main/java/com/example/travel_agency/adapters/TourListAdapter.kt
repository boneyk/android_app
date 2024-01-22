package com.example.travel_agency.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.TourWithIdViewModel
import com.example.travel_agency.ViewModel.ToursFragmentViewModel
import com.example.travel_agency.activities.TourActivity
import com.example.travel_agency.models.Tour_Image
import com.example.travel_agency.models.Tours

class TourListAdapter(var tours: MutableLiveData<List<Tours>>, var context: Context): RecyclerView.Adapter<TourListAdapter.MyViewHolder>() {
    fun updateData(newTours: List<Tours>) {
        tours.value = newTours
        notifyDataSetChanged()
    }


    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.tour_list_image)
        val name: TextView = view.findViewById(R.id.tour_list_name)
        val price: TextView = view.findViewById(R.id.tour_list_price)
        val tour_type: TextView = view.findViewById(R.id.tour_list_tourtype)
        val btn: Button = view.findViewById(R.id.tour_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_in_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tours.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentTours = tours.value ?: emptyList()
        holder.name.text = currentTours[position].name
        val pricePerOne = currentTours[position].price_per_one
        val formattedPrice = String.format("%,d", pricePerOne).replace(",", " ")
        holder.price.text = "$formattedPrice руб."
        holder.tour_type.text = currentTours[position].tour_type

        val currentImage:List<Tour_Image> = currentTours[position].images
        if(currentImage.isNullOrEmpty()) {
            Log.d("MyLog", "список пустой")
        } else {
            Log.d("MyLog", "массив не пуст")
            val imageId = context.resources.getIdentifier(
                currentImage[0].filename,
                "drawable",
                context.packageName
            )
            holder.image.setImageResource(imageId)
        }

        holder.btn.setOnClickListener{
            val tour_id = currentTours[position].id
            val intent = Intent(context, TourActivity::class.java)
            intent.putExtra("tour_id", tour_id)
            context.startActivity(intent)
        }
    }
}
