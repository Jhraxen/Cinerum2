package com.example.aplicacio

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplicacio.DB.Pelicula
import com.example.aplicacio.DB.PeliculasDBHelper


/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment(db:PeliculasDBHelper) : Fragment() {
    var dbHelper:PeliculasDBHelper = db

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_form, container, false)
        val txtImage: EditText = view.findViewById(R.id.image_url)
        val txtTitol: EditText = view.findViewById(R.id.titulo)
        val txtDirector: EditText = view.findViewById(R.id.director)
        val btnGuardar: Button = view.findViewById(R.id.guardar)
        val btnBorrar: Button = view.findViewById(R.id.borrar)
        val cancelado = "Acción cancelada"
        val borrado = "BDD borrada"
        val insertada = "Película insertada"
        val duration = Toast.LENGTH_SHORT
        val toastCancela = Toast.makeText(context, cancelado, duration)
        val toastBorrado = Toast.makeText(context, borrado, duration)
        val toastInsertado = Toast.makeText(context, insertada, duration)



        //*var btnGuardar: introduce objeto pelicula en la base de datos
        btnGuardar.setOnClickListener {
            val pelicula = Pelicula(txtImage.text.toString(), txtTitol.text.toString(), txtDirector.text.toString())
            val builder = AlertDialog.Builder(context)
            builder.setMessage("¿Quieres guardar los datos de la película?")
                .setPositiveButton("Sí",
                    DialogInterface.OnClickListener { dialog, id ->
                        dbHelper.insertPelicula(pelicula)
                        toastInsertado.show()
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        toastCancela.show()
                    })
// Create the AlertDialog object and return it
            builder.create().show()

        }
        btnBorrar.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("ALERTA: ¿Seguro que deseas borrar la base de datos de peliculas?")
                .setPositiveButton("Sí",
                    DialogInterface.OnClickListener { dialog, id ->
                        dbHelper.deleteAllPeliculas()
                        toastBorrado.show()
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        toastCancela.show()
                    })
// Create the AlertDialog object and return it
            builder.create().show()


       }

        return view
    }


}