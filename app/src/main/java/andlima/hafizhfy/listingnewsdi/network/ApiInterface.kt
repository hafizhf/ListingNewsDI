package andlima.hafizhfy.listingnewsdi.network

import andlima.hafizhfy.listingnewsdi.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("news")
    fun getALlNews() : Call<List<GetAllNewsResponseItem>>
}