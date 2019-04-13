package dev.bibuti.nimaptest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.bibuti.nimaptest.R
import dev.bibuti.nimaptest.models.CatelogueCategory
import kotlinx.android.synthetic.main.single_category_view.view.*

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.CustomVH>() {

    private var catelogueCategoryList: List<CatelogueCategory>

    init {
        catelogueCategoryList = emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomVH {
        return CustomVH(LayoutInflater.from(parent.context).inflate(R.layout.single_category_view, parent, false))
    }

    override fun onBindViewHolder(holder: CustomVH, position: Int) {

        val singlecatelogue = catelogueCategoryList[position]

        holder.itemView.categoryNameTV.text = singlecatelogue.categoryName

        holder.itemView.imageRV.setHasFixedSize(true)
        holder.itemView.imageRV.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.itemView.imageRV.adapter = CustomImageAdapter(singlecatelogue.categoryImages)


    }

    override fun getItemCount(): Int {
        return catelogueCategoryList.size
    }

    fun updateData(list: List<CatelogueCategory>) {
        catelogueCategoryList = list
        notifyDataSetChanged()
    }

    inner class CustomVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}
