package ggikko.me.ggikkoapplication.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ggikko.me.ggikkoapplication.GgikkoApplication
import javax.inject.Singleton


/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(ggikkoApplication: GgikkoApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}