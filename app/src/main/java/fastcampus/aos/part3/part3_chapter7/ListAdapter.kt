package fastcampus.aos.part3.part3_chapter7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import fastcampus.aos.part3.part3_chapter7.MainActivity.Handler
import fastcampus.aos.part3.part3_chapter7.databinding.ItemContentBinding
import fastcampus.aos.part3.part3_chapter7.model.ContentEntity

class ListAdapter(private val handler: Handler) : androidx.recyclerview.widget.ListAdapter<ContentEntity, ContentViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentViewHolder {
        return ContentViewHolder(ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false), handler)
    }

    override fun onBindViewHolder(
        holder: ContentViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ContentEntity>() {
            override fun areItemsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean = oldItem == newItem
        }
    }
}