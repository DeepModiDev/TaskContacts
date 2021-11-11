package com.deepmodi.taskcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.deepmodi.taskcontacts.adapters.ContactsAdapter
import com.deepmodi.taskcontacts.api.ApiGenerator
import com.deepmodi.taskcontacts.databinding.ActivityMainBinding
import com.deepmodi.taskcontacts.models.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //val contacts = fetchUsers()
        //Log.d("MainActivity",contacts.toString())

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.contacts.observe(this, Observer {
            binding.recyclerView.adapter = ContactsAdapter(it)
            // Here I have directly passes the adapter this is a bad practice
            // but due to time limit i have done this so sorry for that
            // we can also use the DiffUtil and ListAdapter instead of that.. and the submitList()
        })
    }

}