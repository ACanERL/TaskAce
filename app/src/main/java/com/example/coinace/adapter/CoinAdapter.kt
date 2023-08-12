package com.example.coinace.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.db.williamchart.view.LineChartView
import com.example.coinace.R
import com.example.coinace.ViewModel.CoinViewModel
import com.example.coinace.data.model.CoinModel
import com.example.coinace.util.roundToThreeDecimals
import com.example.coinace.util.toDoubleFloatPairs
import kotlin.reflect.KFunction1

class CoinAdapter(var coinList:List<CoinModel>, var OnClick: (CoinModel) -> Unit):RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]
        holder.coinNameTextView.text=coin.name
        holder.coinPriceTextView.text="$ "+coin.current_price.roundToThreeDecimals()

        Glide.with(holder.itemView.context)
            .load(coin.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.coinImageView)

        val listData = coin.sparklineIn7d?.price.toDoubleFloatPairs()
        val apiData: List<Pair<String, Float>> = listData
        holder.chart.animate(apiData)

        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
  inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val coinNameTextView:TextView=itemView.findViewById(R.id.coinName)
      val coinPriceTextView:TextView=itemView.findViewById(R.id.coinPrice)
      val coinImageView:ImageView=itemView.findViewById(R.id.coinImage)
      val chart: LineChartView=itemView.findViewById(R.id.lineChart)


    }
}