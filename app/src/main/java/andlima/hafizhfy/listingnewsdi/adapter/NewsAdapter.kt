package andlima.hafizhfy.listingnewsdi.adapter

import andlima.hafizhfy.listingnewsdi.R
import andlima.hafizhfy.listingnewsdi.model.GetAllNewsResponseItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsData: List<GetAllNewsResponseItem>? = null

    fun setNewsList(newsList: List<GetAllNewsResponseItem>) {
        this.newsData = newsList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(newsData!![position].image)
            .into(holder.itemView.iv_news_thumbnail)
        holder.itemView.tv_news_title.text = newsData!![position].title
        holder.itemView.tv_news_date.text = newsData!![position].createdAt
    }

    override fun getItemCount(): Int {
        return if (newsData!= null) {
            newsData!!.size
        } else {
            0
        }
    }
}