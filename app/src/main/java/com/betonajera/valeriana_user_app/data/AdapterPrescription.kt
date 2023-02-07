package com.betonajera.valeriana_user_app.data

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.betonajera.valeriana_user_app.R
import com.squareup.picasso.Picasso

class AdapterPrescription(private val context: Activity, private val arrayList: ArrayList<Prescription>): ArrayAdapter<Prescription>(context, R.layout.list_prescription_item, arrayList) {

    override  fun getView(position: Int, convertView: View?, parent: ViewGroup): View{

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_prescription_item, null)

        val titlePrescription = view.findViewById<TextView>(R.id.title_prescription)
        val timePrescription = view.findViewById<TextView>(R.id.time_prescription)
        val quantityPrescription = view.findViewById<TextView>(R.id.quantity_prescription)
        val descriptionPrescription = view.findViewById<TextView>(R.id.description_prescription)

        titlePrescription.text = arrayList[position].name
        timePrescription.text = arrayList[position].times.toString().plus(" veces por ").plus(arrayList[position].days.toString()).plus(" dias")
        quantityPrescription.text = arrayList[position].quantity.toString().plus(" mg.")
        descriptionPrescription.text = arrayList[position].description

        return view

    }
}