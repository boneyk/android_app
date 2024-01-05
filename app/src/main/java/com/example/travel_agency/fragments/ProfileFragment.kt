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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.travel_agency.ViewModel.ProfileViewModel
import com.example.travel_agency.activities.DockActivity
import com.example.travel_agency.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var user_id: String  = "1"
    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    fun finallyGetIt(){
        user_id = Memory(requireContext()).getUserId()
        Log.d("MyLog", "user_id = ${user_id}")
        viewModel.getUserInfo(user_id)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        binding = FragmentProfileBinding.inflate(layoutInflater)
        user_id = Memory(requireContext()).getUserId()
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
        var name : String
        var phone : String

        val passCancel: View = view.findViewById(R.id.prof_cancelbutton)
        passCancel.visibility = View.GONE
        val passSave: View = view.findViewById(R.id.prof_okbutton)
        passSave.visibility = View.GONE

        val editProfName = view.findViewById(R.id.prof_name) as EditText
        val editProfLogin = view.findViewById(R.id.prof_login) as EditText
        val editProfEmail = view.findViewById(R.id.prof_email) as EditText
        val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
        val editProfPassword = view.findViewById(R.id.prof_password) as EditText


        viewModel.Infolist.observe(requireActivity(), Observer { tours ->
            //        ОТМЕНА И СОХРАНИТЬ
            passCancel.visibility = View.GONE
            passSave.visibility = View.GONE

            Log.d("MyLog", "зашел в viewModel.Infolist.observe = ${tours.fullname}")
            editProfName.isEnabled = false
            editProfName.setText(tours.fullname)
            editProfLogin.isEnabled = false
            editProfLogin.setText(tours.login)
            editProfEmail.isEnabled = false
            editProfEmail.setText(tours.email)
            editProfPhone.isEnabled = false
            editProfPhone.setText(tours.phone_number)
            editProfPassword.isEnabled = false
            editProfPassword.setText(tours.password)

        })

        editProfButton.setOnClickListener{
            editProfName.isEnabled = true
            editProfLogin.isEnabled = true
            editProfEmail.isEnabled = true
            editProfPhone.isEnabled = true
            editProfPassword.isEnabled = true
            passCancel.visibility = View.VISIBLE
            passSave.visibility = View.VISIBLE
        }
        cancelProfButton.setOnClickListener{
            passCancel.visibility = View.GONE
            passSave.visibility = View.GONE
            editProfName.isEnabled = false
            editProfLogin.isEnabled = false
            editProfEmail.isEnabled = false
            editProfPhone.isEnabled = false
            editProfPassword.isEnabled = false
        }
        saveProfButton.setOnClickListener{
            name = editProfName.text.toString()
            phone = editProfPhone.text.toString()
            binding.profName.setText(name)
            binding.profPhone.setText(phone)
            Log.d("MyLog", "телефон отредактирован = ${editProfPhone.text.toString()}")
            Log.d("MyLog", "имя отредактировано = ${editProfName.text.toString()}")
            Log.d("MyLog", "v binding это выглядит так = ${binding.profName.text.toString()}")
            passCancel.visibility = View.GONE
            passSave.visibility = View.GONE
            editProfName.isEnabled = false
            editProfLogin.isEnabled = false
            editProfEmail.isEnabled = false
            editProfPhone.isEnabled = false
            editProfPassword.isEnabled = false
            viewModel.tryUpdateProf(binding)
            Log.d("MyLog", "телефон отредактирован = ${binding.profName.text.toString()}")

//                viewModel.getUserInfo(user_id)
//                onViewCreated(view,savedInstanceState)
//                requireActivity().supportFragmentManager.beginTransaction().detach(this).attach(this).commit()
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