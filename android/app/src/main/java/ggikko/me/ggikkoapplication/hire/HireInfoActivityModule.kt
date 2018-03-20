package ggikko.me.ggikkoapplication.hire

import dagger.Module
import dagger.Provides
import ggikko.me.ggikkoapplication.data.HireInfoDataSource
import ggikko.me.ggikkoapplication.data.remote.HireInfoRemoteDataSource
import ggikko.me.ggikkoapplication.util.localRetrofit

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */

@Module
class HireInfoActivityModule {

    @Provides
    fun hireInfoService(): HireInfoDataSource.HireInfoService {
        return localRetrofit().create(HireInfoDataSource.HireInfoService::class.java)
    }

    @Provides
    fun dataSource(hireInfoService: HireInfoDataSource.HireInfoService): HireInfoDataSource {
        return HireInfoRemoteDataSource(hireInfoService)
    }
}