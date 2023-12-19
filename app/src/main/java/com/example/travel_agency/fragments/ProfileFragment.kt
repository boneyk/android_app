package com.example.travel_agency

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.ViewModel.LoginViewModel
import com.example.travel_agency.ViewModel.ProfileViewModel
import com.example.travel_agency.activities.DockActivity
import com.example.travel_agency.databinding.ActivitySignBinding
import com.example.travel_agency.databinding.FragmentProfileBinding
import com.example.travel_agency.fragments.FaveFragment

class ProfileFragment : Fragment() {
    private var user_id: Int  = 2
    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    fun finallyGetIt(){
        user_id = Storage(requireContext()).getUserId()
        Log.d("MyLog", "user_id = ${user_id}")
        viewModel.getUserInfo(user_id)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding = FragmentProfileBinding.inflate(layoutInflater)
        user_id = Storage(requireContext()).getUserId()
        Log.d("MyLog", "user_id = ${user_id}")
        viewModel.getUserInfo(user_id)
        finallyGetIt()
//        Log.d("MyLog", "user_id = ${(}")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editProfButton = view.findViewById(R.id.prof_edit_button) as Button
        val cancelProfButton = view.findViewById(R.id.prof_cancelbutton) as Button
        val saveProfButton = view.findViewById(R.id.prof_okbutton) as Button

        //        ОТМЕНА И СОХРАНИТЬ
        val passCancel: View = view.findViewById(R.id.prof_cancelbutton)
        passCancel.visibility = View.GONE
        val passSave: View = view.findViewById(R.id.prof_okbutton)
        passSave.visibility = View.GONE

        val info = Storage(requireContext()).getPersInfo()
        Log.d("MyLog", "info = ${info.email}")
        val editProfName = view.findViewById(R.id.prof_name) as EditText
        editProfName.isEnabled = false
        editProfName.setText(info.fullname)
        val editProfLogin = view.findViewById(R.id.prof_login) as EditText
        editProfLogin.isEnabled = false
        editProfLogin.setText(info.login)
        val editProfEmail = view.findViewById(R.id.prof_email) as EditText
        editProfEmail.isEnabled = false
        editProfEmail.setText(info.email)
        val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
        editProfPhone.isEnabled = false
        editProfPhone.setText(info.phone_number)
        val editProfPassword = view.findViewById(R.id.prof_password) as EditText
        editProfPassword.isEnabled = false
        editProfPassword.setText(info.password)

        editProfButton.setOnClickListener{
            val editProfName = view.findViewById(R.id.prof_name) as EditText
            editProfName.isEnabled = true
            val editProfLogin = view.findViewById(R.id.prof_login) as EditText
            editProfLogin.isEnabled = true
            val editProfEmail = view.findViewById(R.id.prof_email) as EditText
            editProfEmail.isEnabled = true
            val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
            editProfPhone.isEnabled = true
            val editProfPassword = view.findViewById(R.id.prof_password) as EditText
            editProfPassword.isEnabled = true
            val passCancel: View = view.findViewById(R.id.prof_cancelbutton)
            passCancel.visibility = View.VISIBLE
            val passSave: View = view.findViewById(R.id.prof_okbutton)
            passSave.visibility = View.VISIBLE
        }
        cancelProfButton.setOnClickListener{
            val passCancel: View = view.findViewById(R.id.prof_cancelbutton)
            passCancel.visibility = View.GONE
            val passSave: View = view.findViewById(R.id.prof_okbutton)
            passSave.visibility = View.GONE
            val editProfName = view.findViewById(R.id.prof_name) as EditText
            editProfName.isEnabled = false
            val editProfLogin = view.findViewById(R.id.prof_login) as EditText
            editProfLogin.isEnabled = false
            val editProfEmail = view.findViewById(R.id.prof_email) as EditText
            editProfEmail.isEnabled = false
            val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
            editProfPhone.isEnabled = false
            val editProfPassword = view.findViewById(R.id.prof_password) as EditText
            editProfPassword.isEnabled = false
        }
        saveProfButton.setOnClickListener{
            val passCancel: View = view.findViewById(R.id.prof_cancelbutton)
            passCancel.visibility = View.GONE
            val passSave: View = view.findViewById(R.id.prof_okbutton)
            passSave.visibility = View.GONE
            val editProfName = view.findViewById(R.id.prof_name) as EditText
            editProfName.isEnabled = false
            val editProfLogin = view.findViewById(R.id.prof_login) as EditText
            editProfLogin.isEnabled = false
            val editProfEmail = view.findViewById(R.id.prof_email) as EditText
            editProfEmail.isEnabled = false
            val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
            editProfPhone.isEnabled = false
            val editProfPassword = view.findViewById(R.id.prof_password) as EditText
            editProfPassword.isEnabled = false
            viewModel.tryUpdateProf(binding)
        }


        val buttonDock: Button = view.findViewById(R.id.button_dock)
        buttonDock.setOnClickListener {
            val intent = Intent(activity, DockActivity::class.java)
            startActivity(intent)
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}