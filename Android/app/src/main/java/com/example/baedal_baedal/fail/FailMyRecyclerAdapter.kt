package com.example.baedal_baedal.fail/*
package com.example.baedal_baedal

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FailMyRecyclerAdapter(myRecyclerInterface: FailMyRecyclerInterface): RecyclerView.Adapter<FailMyViewHolder>() {

    val TAG: String = "로그"

    private var modelList = ArrayList<FailMyModel>()

    private var myRecyclerInterface : FailMyRecyclerInterface? = null

    init{
        this.myRecyclerInterface = myRecyclerInterface
    }

    // 뷰 홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FailMyViewHolder {
        return FailMyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fail_layout_recycler_item, parent, false), this.myRecyclerInterface!!)
    }
    // 목록의 수
    override fun getItemCount(): Int {
        return this.modelList.size
    }
    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: FailMyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position: $position")
        holder.bind(this.modelList[position])

    }

    fun submitList(modelList: ArrayList<FailMyModel>){
        this.modelList = modelList
    }

}*/
