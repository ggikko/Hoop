package ggikko.me.ggikkoapplication.data.remote

import ggikko.me.ggikkoapplication.data.HireInfoDataSource
import ggikko.me.ggikkoapplication.data.HireInfoRes
import io.reactivex.Observable

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */
class HireInfoRemoteDataSource(private val hireInfoService: HireInfoDataSource.HireInfoService) : HireInfoDataSource {

    override fun getHireInfo(): Observable<HireInfoRes> {
        return hireInfoService.getInfo()
    }
}