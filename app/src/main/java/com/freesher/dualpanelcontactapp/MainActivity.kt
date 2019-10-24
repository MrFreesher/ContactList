package com.freesher.dualpanelcontactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), Communicator {
    private var isDualPanel: Boolean = false
    override fun displayDetails(firstName: String, lastName: String, phoneNumber: String) {
        if (isDualPanel) {
            val fragmentB =
                supportFragmentManager.findFragmentById(R.id.detail_fragment) as DetailsFragment?
            fragmentB?.displayDetails(firstName, lastName, phoneNumber)
        } else {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("phoneNumber", phoneNumber)
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentBView = findViewById<View>(R.id.detail_fragment)
        isDualPanel = fragmentBView?.visibility == View.VISIBLE
        title = getString(R.string.contactActivity_title)
    }
}
