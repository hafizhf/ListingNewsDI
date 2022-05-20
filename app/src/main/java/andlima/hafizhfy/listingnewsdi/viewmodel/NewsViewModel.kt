package andlima.hafizhfy.listingnewsdi.viewmodel

import andlima.hafizhfy.listingnewsdi.News
import andlima.hafizhfy.listingnewsdi.model.GetAllNewsResponseItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class NewsViewModel : ViewModel() {

//    lateinit var news: News
//
//    lateinit var liveDataList: MutableLiveData<List<GetAllNewsResponseItem>>
//
//    init {
//        liveDataList = MutableLiveData()
//    }
//
//    fun getLiveDataNews() : MutableLiveData<List<GetAllNewsResponseItem>> {
//        return liveDataList
//    }
//
//    fun getNewsData() {
//        news.instance.getALlNews()
//            .enqueue(object : retrofit2.Callback<List<GetAllNewsResponseItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllNewsResponseItem>>,
//                    response: Response<List<GetAllNewsResponseItem>>
//                ) {
//                    if (response.isSuccessful) {
//                        liveDataList.postValue(response.body())
//                    } else {
//                        liveDataList.postValue(null)
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
//                    liveDataList.postValue(null)
//                }
//
//            })
//    }
}