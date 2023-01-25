package com.example.aplicacio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.aplicacio.DB.Pelicula
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// En esta clase se muestra la información de la película seleccionada en el fragmento anterior

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment(var peli:Pelicula): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail2, container, false)
        val txtImage: ImageView = view.findViewById(R.id.imageView_detail)
        val txtTitol: TextView = view.findViewById(R.id.titulo_detail)
        val txtDirector: TextView = view.findViewById(R.id.director_detail)
        Glide.with(this).load(peli.image).into(txtImage)
        txtTitol.text = peli.title
        txtDirector.text = peli.director
        return view
    }

}