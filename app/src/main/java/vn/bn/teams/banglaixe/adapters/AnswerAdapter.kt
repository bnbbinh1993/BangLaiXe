package vn.bn.teams.banglaixe.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import vn.bn.teams.banglaixe.R
import vn.bn.teams.banglaixe.databinding.ItemAnswerBinding

import vn.bn.teams.banglaixe.databinding.ItemIntroBinding
import vn.bn.teams.banglaixe.models.Answer
import vn.bn.teams.banglaixe.models.Intro
import vn.bn.teams.banglaixe.utils.Tools

class AnswerAdapter() :
    RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {
    var list: List<Answer> = mutableListOf()
    private var select: Int = -1
    var onComplete: ((position: Int, answer: Answer) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[holder.adapterPosition]
        holder.bind(item, select)
        holder.itemView.setOnClickListener {
            if (select == -1) {
                onComplete?.invoke(holder.adapterPosition, item)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Answer>) {
        this.list = list
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setSelect(it: Int) {
        this.select = it
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(answer: Answer, select: Int) {
            binding.apply {
                tvAnswer.text = answer.text
                if (select != -1) {
                    val backgroundResId = when {
                        answer.correct && answer.isSelect -> R.drawable.bg_question_3
                        answer.isSelect -> R.drawable.bg_question_2
                        answer.correct -> R.drawable.bg_question_3
                        else -> R.drawable.bg_question_1
                    }
                    viewAnswer.setBackgroundResource(backgroundResId)
                } else {
                    viewAnswer.setBackgroundResource(R.drawable.bg_question_1)
                }
            }
        }
    }
}
