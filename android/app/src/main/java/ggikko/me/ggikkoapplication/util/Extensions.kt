package ggikko.me.ggikkoapplication.util

import retrofit2.Retrofit

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */

//잘모르겠따;;

fun localRetrofit(): Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
        .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        .baseUrl("http://10.0.2.2:8080/")
        .build()