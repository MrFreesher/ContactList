package com.freesher.dualpanelcontactapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter(private val context: Context?, private val personArray: ArrayList<Person>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = inflater.inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int = personArray.size
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val current = personArray[position]
        holder.setData(current, position)
        holder.setListeners()
    }

    inner class ContactViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private var pos: Int = 0
        lateinit var current: Person

        fun setData(current: Person, position: Int) {
            itemView.contact_item_name.text = "${current.firstName} ${current.lastName}"

            this.pos = position
            this.current = current
        }

        fun setListeners() {

            itemView.setOnClickListener {
                val myCommunicator = context as Communicator
                myCommunicator.displayDetails(
                    current.firstName,
                    current.lastName,
                    current.phoneNumber
                )
            }
        }


    }
}