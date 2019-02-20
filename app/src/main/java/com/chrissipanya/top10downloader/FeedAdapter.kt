package com.chrissipanya.top10downloader

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FeedAdapter(context: Context, val resource: Int, val application: List<FeedEntryModel>): ArrayAdapter<FeedEntryModel> (context, resource){
    private val TAG = "FeedAdapter"
    private val inflater = LayoutInflater.from(context )


    override fun getCount(): Int {
        Log.d(TAG,"getCount() called")
        return application.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d(TAG,"getView() called")

        val view = inflater.inflate(resource, parent, false)

        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvArtist: TextView = view.findViewById(R.id.tvArtist)
        val tvSummary: TextView = view.findViewById(R.id.tvSummary)

        val currentApp = application[position]

        tvName.text = currentApp.name
        tvArtist.text = currentApp.artist
        tvSummary.text = currentApp.summary

        return view
    }
}