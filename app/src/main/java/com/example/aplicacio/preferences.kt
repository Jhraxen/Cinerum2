package com.example.aplicacio

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate

import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [preferences.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class preferences : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // if radio botton radioCastella is clicked, change language
        showChangeLanguageDialog()


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.preferences, container, false)
    }
    // al pulsar sobre un botón cambiará a idioma castellano



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment preferences.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            preferences().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun showChangeLanguageDialog() {
        val listItems = arrayOf("Castellano", "Català", "English")
        val mBuilder = AlertDialog.Builder(this.context)
        mBuilder.setTitle("Choose Language...")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialog, which ->
            if (which == 0) {
                setAppLocale("es")
                recreate()
            } else if (which == 1) {
                setAppLocale("ca")
                recreate()
            } else if (which == 2) {
                setAppLocale("en")
                recreate()
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun recreate() {
        val intent = Intent(this.context, Activity_Main::class.java).apply {
        }
        startActivity(intent)
    }

    private fun setAppLocale(localeCode: String) {
        val resources: Resources = resources
        val dm: DisplayMetrics = resources.displayMetrics
        val config: Configuration = resources.configuration
        config.setLocale(Locale(localeCode.lowercase(Locale.getDefault())))

        resources.updateConfiguration(config, dm)
    }
}
