package ggikko.me.ggikkoapplication.data

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */
interface HireInfoDataSource {

    interface HireInfoService {
        @GET("hire/info/")
        fun getInfo(): Observable<HireInfoRes>
    }

    fun getHireInfo(): Observable<HireInfoRes>
}