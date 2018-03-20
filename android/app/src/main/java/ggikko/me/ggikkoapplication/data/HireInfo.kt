package ggikko.me.ggikkoapplication.data

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */
data class HireInfo(val id: String,
                    val createdAt: String,
                    val category: String,
                    val title: String,
                    val link: String,
                    val content: String)

data class HireInfoRes(val infos: List<HireInfo>)