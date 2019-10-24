package com.freesher.dualpanelcontactapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*

/**
 * A simple [Fragment] subclass.
 */
class DetailsFragment : Fragment(), Communicator {
    override fun displayDetails(firstName: String, lastName: String, phoneNumber: String) {
        firstname_tv.text = firstName
        lastnumber_tv.text = lastName
        phonenumber_tv.text = phoneNumber
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }


}
