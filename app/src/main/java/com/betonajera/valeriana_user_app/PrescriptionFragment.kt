package com.betonajera.valeriana_user_app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import com.betonajera.valeriana_user_app.data.*
import com.betonajera.valeriana_user_app.databinding.ActivityHomeBinding
import com.google.gson.Gson
import java.io.IOException

class PrescriptionFragment : Fragment() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prescription, container, false)
        val gson = Gson()

        val jsonFile = activity?.let { getJsonDataFromAsset(it, "prescription.json") }

        val arrayData = gson.fromJson(jsonFile, ResponsePrescription::class.java)

        val prescriptionList = view.findViewById<ListView>(R.id.prescriptionList)
        prescriptionList.adapter = activity?.let { AdapterPrescription(it, arrayData.prescription) }
        return view
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}