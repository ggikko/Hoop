package ggikko.me.ggikkoapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ggikko.me.ggikkoapplication.home.HomeActivity
import ggikko.me.ggikkoapplication.home.HomeActivityModule


/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    internal abstract fun bindHomeActivity(): HomeActivity
}