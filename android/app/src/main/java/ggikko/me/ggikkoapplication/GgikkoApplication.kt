package ggikko.me.ggikkoapplication

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ggikko.me.ggikkoapplication.di.DaggerAppComponent

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */
class GgikkoApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        appComponent.inject(this)
        return appComponent

    }
}