package ggikko.me.ggikkoapplication.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ggikko.me.ggikkoapplication.hire.HireInfoActivity
import ggikko.me.ggikkoapplication.hire.HireInfoActivityModule
import ggikko.me.ggikkoapplication.home.HomeActivity
import ggikko.me.ggikkoapplication.home.HomeActivityModule


/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    internal abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [HireInfoActivityModule::class])
    internal abstract fun bindHireInfoActivity(): HireInfoActivity
}