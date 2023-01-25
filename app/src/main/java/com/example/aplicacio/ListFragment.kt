package com.example.aplicacio

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacio.DB.PeliculasDBHelper

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment(db:PeliculasDBHelper) : Fragment() {
    private var dbHelper:PeliculasDBHelper = db

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        val llistat = dbHelper.getAllPeliculas()
        // crea una vista de RecycerView
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler: RecyclerView = view.findViewById(R.id.recyclerLlistat)
        recycler.layoutManager = LinearLayoutManager(context)
        val adapter = RecyclerViewAdapter(llistat, context, dbHelper)
        recycler.adapter = adapter
        return view
    }

}