package com.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    fun loadUsers() {
        // Do an asynchronous operation to fetch users.
        viewModelScope.launch {
            delay(3000L)
            val userList = mutableListOf(User("姓名18",18),
                User("姓名19",19),User("姓名20",20))
            users.postValue(userList)
        }
    }
}
