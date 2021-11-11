package com.deepmodi.taskcontacts

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.*
import com.deepmodi.taskcontacts.api.ApiGenerator
import com.deepmodi.taskcontacts.models.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>>
        get() = _contacts

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ApiGenerator.api.getAllContacts()
                if (response.isSuccessful) {
                    Log.d("MainActivity", response.body().toString())
                    _contacts.postValue(response.body()!!.data)
                } else {
                    Log.d("MainActivity", response.errorBody().toString())
                }
            } catch (e: Exception) {
                Log.e("MainActivity", e.message.toString())
            }
        }
    }
}