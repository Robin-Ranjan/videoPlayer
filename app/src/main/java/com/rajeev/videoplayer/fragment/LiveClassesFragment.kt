package com.rajeev.videoplayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajeev.videoplayer.R
import com.rajeev.videoplayer.adapter.CompletedClassFragmentAdapter
import com.rajeev.videoplayer.dataClass.LiveClassDataClass

class LiveClassesFragment : Fragment() {
    private lateinit var myAdapter: CompletedClassFragmentAdapter
    private lateinit var recyclerview: RecyclerView
    private var dataList: List<LiveClassDataClass> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.frag_complete_class, container, false)
        recyclerview = view.findViewById(R.id.recyclerview)
        val dataMap = hashMapOf(
            "item1" to LiveClassDataClass("Science", "Science class is going on", "https://youtu.be/OxFXHYigDRc?si=Eja8c6Q5L5z6_hir"),
            "item2" to LiveClassDataClass("Maths", "Maths class is going on", "https://youtu.be/OxFXHYigDRc?si=Eja8c6Q5L5z6_hir"),
            "item3" to LiveClassDataClass("English", "English Class is going on", "https://youtu.be/OxFXHYigDRc?si=Eja8c6Q5L5z6_hir")
        )
        val dataList = dataMap.values.toList()
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        myAdapter = CompletedClassFragmentAdapter(dataList)
        recyclerview.adapter = myAdapter
        return view
    }
}