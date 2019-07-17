package org.panta.misskeysleepy.helpers

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.support.v7.util.DiffUtil
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.panta.misskeysleepy.adapters.TimelineAdapter
import org.panta.misskeysleepy.entities.Note

object TimelineBindingHelper {
    @BindingAdapter("noteItems")
    @JvmStatic
    fun RecyclerView.setTimeline(list: ObservableArrayList<Note>){
        val adapter: TimelineAdapter? = this.adapter as? TimelineAdapter
        val oldList = adapter?.list
        val latestList = list.toList()

        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback(){
            override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
                return latestList[p1].id == oldList?.get(p0)?.id
            }

            override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
                return latestList[p1] == oldList?.get(p0)
            }

            override fun getNewListSize(): Int {
                return latestList.size
            }

            override fun getOldListSize(): Int {
                return oldList?.size?: 0
            }
        })

        adapter?.list = latestList
        if(adapter != null){
            diff.dispatchUpdatesTo(adapter)
        }else{
            Log.d("", "AdapterはNullだった")
        }
    }

    @BindingAdapter("itemDecoration")
    @JvmStatic
    fun RecyclerView.itemDecoration(b: Boolean){
        if(b){
            this.addItemDecoration(DividerItemDecoration(this.context,  LinearLayoutManager(this.context).orientation))

        }
    }
}