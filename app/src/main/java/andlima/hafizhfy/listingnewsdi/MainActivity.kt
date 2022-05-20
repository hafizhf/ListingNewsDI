package andlima.hafizhfy.listingnewsdi

import andlima.hafizhfy.listingnewsdi.adapter.NewsAdapter
import andlima.hafizhfy.listingnewsdi.model.GetAllNewsResponseItem
import andlima.hafizhfy.listingnewsdi.viewmodel.NewsViewModel
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var news: News

    private var newsAdapter: NewsAdapter? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter = NewsAdapter()

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter

        getNewsData {
            newsAdapter!!.setNewsList(it)
            newsAdapter!!.notifyDataSetChanged()
        }

//        initRV()

//        initRecyclerViewNews()
//        initViewModel()
    }

//    private fun initViewModel() {
//        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
//        viewModel.getLiveDataNews().observe(this, {
//            if (it != null) {
//                newsAdapter.setNewsList(it)
//                newsAdapter.notifyDataSetChanged()
//            }
//        })
//        viewModel.getNewsData()
//    }

//    private fun initRecyclerViewNews() {
//        rv_news.layoutManager = LinearLayoutManager(this)
//        newsAdapter = NewsAdapter()
//        rv_news.adapter = newsAdapter
//    }

    private fun getNewsData(action: (List<GetAllNewsResponseItem>) -> Unit) {
        news.instance.getALlNews()
            .enqueue(object : retrofit2.Callback<List<GetAllNewsResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        action(response.body()!!)
                    } else {
                        Log.d("RESPONSE", response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                    Log.d("FAIL MESSAGE", t.message!!)
                }

            })
    }

//    private fun initRV() {
//        getNewsData()
//
//        newsAdapter = NewsAdapter()
//        rv_news.layoutManager = LinearLayoutManager(this)
//        rv_news.adapter = newsAdapter
//
//        if (dataNews != null) {
//            if (dataNews!!.isNotEmpty()) {
//                newsAdapter!!.setNewsList(dataNews!!)
//                newsAdapter!!.notifyDataSetChanged()
//            }
//        }
//    }
}