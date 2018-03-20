package ggikko.me.ggikkoapplication.home

import android.os.Bundle
import dagger.android.DaggerActivity
import ggikko.me.ggikkoapplication.R
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerActivity() {

    @Inject
    lateinit var helloModel: HomeHelloModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        helloTextView.setText(helloModel.getHelloString())
    }
}
