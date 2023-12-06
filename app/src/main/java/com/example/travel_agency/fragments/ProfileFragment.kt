package com.example.travel_agency

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.travel_agency.activities.DockActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_profile, container, false)

            val editProfButton = view.findViewById(R.id.prof_edit_button) as Button
            val cancelProfButton = view.findViewById(R.id.prof_cancelbutton) as Button
            val saveProfButton = view.findViewById(R.id.prof_okbutton) as Button

            //        ОТМЕНА И СОХРАНИТЬ
            val passCancel: View = view.findViewById(R.id.prof_cancelbutton)
            passCancel.visibility = View.GONE
            val passSave: View = view.findViewById(R.id.prof_okbutton)
            passSave.visibility = View.GONE
            val editProfLogin = view.findViewById(R.id.prof_login) as EditText
            editProfLogin.isEnabled = false
            val editProfEmail = view.findViewById(R.id.prof_email) as EditText
            editProfEmail.isEnabled = false
            val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
            editProfPhone.isEnabled = false
            val editProfPassword = view.findViewById(R.id.prof_password) as EditText
            editProfPassword.isEnabled = false

            editProfButton.setOnClickListener{
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
                val editProfLogin = view.findViewById(R.id.prof_login) as EditText
                editProfLogin.isEnabled = false
                val editProfEmail = view.findViewById(R.id.prof_email) as EditText
                editProfEmail.isEnabled = false
                val editProfPhone = view.findViewById(R.id.prof_phone) as EditText
                editProfPhone.isEnabled = false
                val editProfPassword = view.findViewById(R.id.prof_password) as EditText
                editProfPassword.isEnabled = false
            }


            val buttonDock: Button = view.findViewById(R.id.button_dock)
            buttonDock.setOnClickListener {
                val intent = Intent(activity, DockActivity::class.java)
                startActivity(intent)
            }
            return view
        }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}