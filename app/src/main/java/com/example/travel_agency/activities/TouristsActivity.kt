package com.example.travel_agency.activities

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.R
import com.example.travel_agency.ViewModel.DocksViewModel
import com.example.travel_agency.ViewModel.TouristsViewModel
import com.example.travel_agency.models.Person

class TouristsActivity : AppCompatActivity() {
    private lateinit var touristsList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var editText: EditText
    private lateinit var viewModel: TouristsViewModel

    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourists)
        viewModel = ViewModelProvider(this).get(TouristsViewModel::class.java)
        sharedPref = getSharedPreferences("myPref", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPref.edit()
        val user_id = sharedPref.getString("token", null)!!
        viewModel.getDocks(user_id)
        val touristName = "Нажмите, чтобы заполнить"


        val listView: ListView = findViewById(R.id.listView)
        touristsList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, touristsList)
        listView.adapter = adapter

        viewModel.peoplist.observe(this, Observer { tours ->
            touristsList.clear()
            touristsList.addAll(tours.map{if(it.fullname == null) touristName else it.fullname})
            adapter.notifyDataSetChanged()
        })

        val addButton: Button = findViewById(R.id.button_add)
        addButton.setOnClickListener {
            addTourist()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val curPeop : Person = viewModel.peoplist.value?.get(position) ?: return@setOnItemClickListener
            editor.putString("doc_token", curPeop.token).apply()
            Log.d("MyLog", "doc_token = ${curPeop.token}")
            seeTourist(position)
        }
    }

    private fun addTourist() {
        val user_id = sharedPref.getString("token", null)!!
        viewModel.putPeop(user_id)
        viewModel.getDocks(user_id)
    }

    private fun seeTourist(position: Int) {
        val intent = Intent(this, DockActivity::class.java)
        startActivity(intent)
    }
}
