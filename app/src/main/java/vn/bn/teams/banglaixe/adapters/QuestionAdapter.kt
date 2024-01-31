package vn.bn.teams.banglaixe.adapters


import android.annotation.SuppressLint
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

import vn.bn.teams.banglaixe.databinding.ItemIntroBinding
import vn.bn.teams.banglaixe.databinding.ItemQuestionBinding
import vn.bn.teams.banglaixe.models.Intro
import vn.bn.teams.banglaixe.models.Question
import vn.bn.teams.banglaixe.utils.Tools
import vn.bn.teams.banglaixe.utils.loadImageFromAssets


class QuestionAdapter() :
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    var list: List<Question> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[holder.adapterPosition]
        val answerAdapter = AnswerAdapter()
        holder.binding.apply {

            tvExplain.text = HtmlCompat.fromHtml(item.tip , HtmlCompat.FROM_HTML_MODE_LEGACY)

            if (item.required == 1) {
                tvQuestion.text = HtmlCompat.fromHtml(item.text +"<b><font color='#F39C12'> (Câu điểm liệt) </font></b>", HtmlCompat.FROM_HTML_MODE_LEGACY)
            }else{
                tvQuestion.text = HtmlCompat.fromHtml(item.text, HtmlCompat.FROM_HTML_MODE_LEGACY)
            }

            if (item.selected != -1) {
                viewExplain.visibility = View.VISIBLE
            } else {
                viewExplain.visibility = View.GONE
            }
            recyclerViewAnswer.adapter = answerAdapter
            recyclerViewAnswer.layoutManager =
                LinearLayoutManager(holder.binding.root.context, RecyclerView.VERTICAL, false)
            recyclerViewAnswer.setHasFixedSize(true)
            answerAdapter.setSelect(item.selected)
            answerAdapter.setData(item.answers)
            answerAdapter.onComplete = { i, it ->
                list[holder.adapterPosition].answers[i].isSelect = true
                list[holder.adapterPosition].selected = i
                answerAdapter.setSelect(i)
                holder.binding.viewExplain.visibility = View.VISIBLE
            }
        }


        if (list[holder.adapterPosition].image.isEmpty()) {
            holder.binding.cardViewImage.visibility = View.GONE
        } else {
            holder.binding.cardViewImage.visibility = View.VISIBLE
            Glide.with(holder.binding.root.context)
                .load(
                    loadImageFromAssets(
                        holder.binding.root.context,
                        list[holder.adapterPosition].image.substring(1)
                    )
                )
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.binding.imvQuestion)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addData(lt: List<Question>) {
        this.list = lt
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root)
}
