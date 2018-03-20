package ggikko.me.ggikkoapplication.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}