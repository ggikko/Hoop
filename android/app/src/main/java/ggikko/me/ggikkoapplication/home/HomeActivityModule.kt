package ggikko.me.ggikkoapplication.home

import dagger.Module
import dagger.Provides

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */

@Module
class HomeActivityModule {

    @Provides
    fun helloModel(): HomeHelloModel {
        return HomeHelloModel()
    }
}