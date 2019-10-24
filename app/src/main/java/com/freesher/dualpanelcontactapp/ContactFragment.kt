package com.freesher.dualpanelcontactapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {
    private lateinit var personList: ArrayList<Person>
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_contact, container, false)



        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()

        setupRecyclerView(rootView)

    }

    private fun setupRecyclerView(rootView: View) {

        val recyclerView = rootView.findViewById(R.id.contact_recycler) as RecyclerView

        val adapter = ContactAdapter(context, personList)
        recyclerView.adapter = adapter

        val manager = LinearLayoutManager(activity)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = manager
    }

    private fun setupList() {
        personList = ArrayList<Person>()
        personList.add(Person("John", "Doe", "123123123"))
        personList.add(Person("Mike", "Smith", "123456789"))
        personList.add(Person("Eve", "Kenzie", "321456987"))

    }

}
