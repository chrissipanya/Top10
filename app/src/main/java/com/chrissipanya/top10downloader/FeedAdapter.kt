package com.chrissipanya.top10downloader

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class FeedAdapter(context: Context, val resource: Int, val application: List<FeedEntryModel>) :
    ArrayAdapter<FeedEntryModel>(context, resource) {
    private val TAG = "FeedAdapter"
    private val inflater = LayoutInflater.from(context)


    override fun getCount(): Int {
        Log.d(TAG, "getCount() called")
        return application.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d(TAG, "getView() called")

        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            Log.d(TAG, "getView provided convertView")
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        val currentApp = application[position]

        viewHolder.tvName.text = currentApp.name
        viewHolder.tvArtist.text = currentApp.artist
        viewHolder.tvSummary.text = currentApp.summary

        return view
    }
}