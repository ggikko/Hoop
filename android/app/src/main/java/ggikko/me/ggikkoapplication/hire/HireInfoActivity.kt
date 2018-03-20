package ggikko.me.ggikkoapplication.hire

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import dagger.android.DaggerActivity
import ggikko.me.ggikkoapplication.R
import ggikko.me.ggikkoapplication.data.HireInfoDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_hire_info.*
import javax.inject.Inject

class HireInfoActivity : DaggerActivity() {

    @Inject
    lateinit var hireInfoDataSource: HireInfoDataSource

    private val adapter = HireInfoAdapter()
    private val recyclerView: RecyclerView by lazy {
        hireRecyclerView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hire_info)
        recyclerView.adapter = adapter
        getInfo()
    }

    //TODO MVVM + AAC
    private fun getInfo() {
        hireInfoDataSource.getHireInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    adapter.setItem(result.infos)
                }, { error ->
                    error.printStackTrace()
                })
    }
}
