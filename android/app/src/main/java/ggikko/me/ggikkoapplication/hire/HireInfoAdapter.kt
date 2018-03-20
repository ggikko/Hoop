package ggikko.me.ggikkoapplication.hire

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ggikko.me.ggikkoapplication.R
import ggikko.me.ggikkoapplication.data.HireInfo
import kotlinx.android.synthetic.main.item_hire_info.view.*

/**
 * Created by ggikko (JiHong Park) on 2018. 3. 21..
 */
class HireInfoAdapter : RecyclerView.Adapter<HireInfoAdapter.HireInfoViewHolder>() {

    var itemList: List<HireInfo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            HireInfoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_hire_info, parent, false))

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: HireInfoViewHolder?, position: Int) {
        val item = itemList.get(position)
        holder?.textView?.text = item.id
    }

    fun setItem(itemList: List<HireInfo>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    class HireInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView by lazy { itemView.infoView }
    }
}