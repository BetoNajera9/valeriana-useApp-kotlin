package com.betonajera.valeriana_user_app.data

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.betonajera.valeriana_user_app.R
import com.squareup.picasso.Picasso

class AdapterDoctor(private val context: Activity, private val arrayList: ArrayList<Doctor>): ArrayAdapter<Doctor>(context, R.layout.list_doctor_item, arrayList) {

    override  fun getView(position: Int, convertView: View?, parent: ViewGroup): View{

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_doctor_item, null)

        val imageView = view.findViewById<ImageView>(R.id.profilePic)
        val userName = view.findViewById<TextView>(R.id.doctorName)
        val job = view.findViewById<TextView>(R.id.job)
        val popularity = view.findViewById<TextView>(R.id.popularity)
        val patients = view.findViewById<TextView>(R.id.patients)

        val image = Picasso.get().load(arrayList[position].photo).into(imageView)

        userName.text = arrayList[position].first_name.plus(" ").plus(arrayList[position].last_name)
        job.text = arrayList[position].job
        popularity.text = arrayList[position].popularity.toString()
        patients.text = arrayList[position].patients.toString()

        return view

    }
}