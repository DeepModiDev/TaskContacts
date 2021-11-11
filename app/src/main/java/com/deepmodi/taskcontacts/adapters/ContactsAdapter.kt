package com.deepmodi.taskcontacts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.deepmodi.taskcontacts.R
import com.deepmodi.taskcontacts.models.Contact

class ContactsAdapter(val contacts : List<Contact>) : RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
       val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_view_contacts,parent,false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(contact = contacts[position])
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}


class ContactsViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

    private val imageView : ImageView = view.findViewById(R.id.profileImageView)
    private val firstName : TextView = view.findViewById(R.id.firstName)
    private val lastName : TextView = view.findViewById(R.id.lastName)
    private val email : TextView = view.findViewById(R.id.userEmail)

    fun bind(contact : Contact){
        imageView.load(contact.avatar)
        firstName.text = contact.first_name
        lastName.text = contact.last_name
        email.text = contact.email
    }
}

