package vn.bn.teams.banglaixe.adapters


import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

import vn.bn.teams.banglaixe.databinding.ItemIntroBinding
import vn.bn.teams.banglaixe.models.Intro
import vn.bn.teams.banglaixe.utils.Tools

class IntroPagerAdapter() :
    RecyclerView.Adapter<IntroPagerAdapter.ViewHolder>() {

    val list = Tools.getListIntro()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[holder.adapterPosition]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(val binding: ItemIntroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(intro: Intro) {
            binding.title.text = intro.title
            binding.des.text = intro.des
            Glide.with(itemView.context)
                .load(intro.logo)
                .circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.circleCropTransform())
                .into(binding.logo)

        }
    }
}
