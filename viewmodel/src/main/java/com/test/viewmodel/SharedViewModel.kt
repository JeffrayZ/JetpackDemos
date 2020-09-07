package com.test.viewmodel

import android.content.ClipData
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import java.nio.channels.Selector

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<ClipData.Item>()

    fun select(item: ClipData.Item) {
        selected.value = item
    }
}

class MasterFragment : Fragment() {

//    private lateinit var itemSelector: Selector

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val model: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        itemSelector.setOnClickListener { item ->
//            // Update the UI
//        }
    }
}

class DetailFragment : Fragment() {

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val model: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.selected.observe(viewLifecycleOwner, Observer { item ->
            // Update the UI
        })
    }
}