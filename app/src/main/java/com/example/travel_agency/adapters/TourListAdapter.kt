package com.example.travel_agency.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travel_agency.R
import com.example.travel_agency.activities.TourActivity
import com.example.travel_agency.models.Tours

class TourListAdapter(var tours: List<Tours>, var context: Context): RecyclerView.Adapter<TourListAdapter.MyViewHolder>() {

    fun updateData(newTours: List<Tours>) {
        tours = newTours
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
        return tours.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = tours[position].name
        holder.price.text = tours[position].capacity.toString()
        holder.tour_type.text = tours[position].country


//        val imageId = context.resources.getIdentifier(
//            tours[position].image,
//            "drawable",
//            context.packageName
//        )
//        holder.image.setImageResource(imageId)


        holder.btn.setOnClickListener{
            val intent = Intent(context, TourActivity::class.java)
            intent.putExtra("tourPrice",tours[position].name)
            context.startActivity(intent)
        }
    }
}