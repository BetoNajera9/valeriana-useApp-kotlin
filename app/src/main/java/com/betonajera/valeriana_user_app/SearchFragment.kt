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
import com.betonajera.valeriana_user_app.data.AdapterDoctor
import com.betonajera.valeriana_user_app.data.Doctor
import com.betonajera.valeriana_user_app.data.ResponseDoctor
import com.betonajera.valeriana_user_app.databinding.ActivityHomeBinding
import com.google.gson.Gson
import java.io.IOException

class SearchFragment : Fragment() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val gson = Gson()

        val jsonFile = activity?.let { getJsonDataFromAsset(it, "doctors.json") }

        val arrayData = gson.fromJson(jsonFile, ResponseDoctor::class.java)

        val doctorList = view.findViewById<ListView>(R.id.doctorsList)
        doctorList.isClickable = true
        doctorList.adapter = activity?.let { AdapterDoctor(it, arrayData.data) }
//        doctorList.setOnItemClickListener{parent, view, position, id ->
//            val name = arrayData[position]
//        }

        val searchView = view.findViewById<SearchView>(R.id.search)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    arrayData.data.filter{it.job.lowercase().contains(p0.lowercase())}
                }

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    arrayData.data.filter{it.job.lowercase().contains(p0.lowercase())}
                }

                return false
            }

        })


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