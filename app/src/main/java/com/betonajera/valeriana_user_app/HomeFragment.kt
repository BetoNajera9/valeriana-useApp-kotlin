package com.betonajera.valeriana_user_app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.betonajera.valeriana_user_app.data.*
import com.betonajera.valeriana_user_app.databinding.ActivityHomeBinding
import com.google.gson.Gson
import java.io.IOException

class HomeFragment : Fragment() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val gson = Gson()

        val jsonFilePresciption = activity?.let { getJsonDataFromAsset(it, "prescription.json") }

        val arrayDataPrescription = gson.fromJson(jsonFilePresciption, ResponsePrescription::class.java)

        val prescriptionList = view.findViewById<ListView>(R.id.prescriptionList)
        prescriptionList.adapter = activity?.let { AdapterPrescription(it, arrayDataPrescription.prescription) }


        val jsonFileDoctor = activity?.let { getJsonDataFromAsset(it, "doctors.json") }

        val arrayDataDoctor = gson.fromJson(jsonFileDoctor, ResponseDoctor::class.java)

        val doctorList = view.findViewById<ListView>(R.id.doctorList)
        doctorList.adapter = activity?.let { AdapterDoctor(it, arrayListOf(arrayDataDoctor.data[0], arrayDataDoctor.data[1], arrayDataDoctor.data[2], arrayDataDoctor.data[3], arrayDataDoctor.data[4], arrayDataDoctor.data[5])) }


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