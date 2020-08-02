package com.madhan.listdemo.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.madhan.listdemo.R
import com.madhan.listdemo.databinding.ItemNameBinding
import com.madhan.listdemo.model.ListModel
import com.madhan.listdemo.ui.utils.ImageUtils
import java.lang.ref.WeakReference
import java.util.*

class ListAdapter(
    var listModel: List<ListModel>,
    context: Context
) : RecyclerView.Adapter<ViewHolder>() {
    var mContextWeakReference: WeakReference<Context>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = mContextWeakReference.get()
        val itemNameBinding: ItemNameBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_name,
                parent,
                false
            )
        return ItemViewHolder(itemNameBinding)
    }

    override fun getItemViewType(position: Int): Int {
        return CONTENT_VIEW

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = mContextWeakReference.get() ?: return
        val itemViewHolder = holder as ItemViewHolder
        itemViewHolder.itemNameBinding.tvName.text = listModel[position].title
        itemViewHolder.itemNameBinding.tvDescription.text = listModel[position].description
        var imageUrl=""
       if(!TextUtils.isEmpty(listModel[position].imageHref))
           imageUrl = listModel[position].imageHref!!
       else imageUrl = ""
        ImageUtils.loadImage(imageUrl ,itemViewHolder.itemNameBinding.ivPlaceUrl,R.color.colorAccent)
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

    class ItemViewHolder(var itemNameBinding: ItemNameBinding) :
        ViewHolder(itemNameBinding.root)



    companion object {
        const val PROGRESS_VIEW = 0
        const val CONTENT_VIEW = 1
    }

    init {
        mContextWeakReference = WeakReference(context)
    }
}