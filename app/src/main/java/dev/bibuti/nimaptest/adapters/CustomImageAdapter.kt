package dev.bibuti.nimaptest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dev.bibuti.nimaptest.R
import dev.bibuti.nimaptest.models.CategoryImage
import kotlinx.android.synthetic.main.single_image_layout.view.*

class CustomImageAdapter(private val categoryImageList: List<CategoryImage> ) : RecyclerView.Adapter<CustomImageAdapter.CustomImageVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomImageVH {
        return CustomImageVH(LayoutInflater.from(parent.context).inflate(R.layout.single_image_layout, parent, false))
    }

    override fun onBindViewHolder(holder: CustomImageVH, position: Int) {

        val singleImage = categoryImageList[position]

        holder.itemView.imageView.let {
            Glide.with(holder.itemView.context)
                    .load(singleImage.iphone)
                    .apply(RequestOptions().placeholder(R.mipmap.ic_launcher).diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                    .into(it)
        }
    }

    override fun getItemCount(): Int {
        return categoryImageList.size
    }

    inner class CustomImageVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}
