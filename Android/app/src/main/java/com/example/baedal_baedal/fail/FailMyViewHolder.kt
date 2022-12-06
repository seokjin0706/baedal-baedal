package com.example.baedal_baedal.fail/*
package com.example.baedal_baedal

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FailMyViewHolder(itemView: View, recyclerInterface: FailMyRecyclerInterface): RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val TAG: String = "로그"
    private val usernameTextView = itemView.findViewById<TextView>(R.id.item_list)
    private val profileImageView = itemView.findViewById<ImageView>(R.id.item_img)

    private var myRecyclerInterface : FailMyRecyclerInterface? = null

    // 기본 생성자
    init {
        Log.d(TAG, "MyViewHolder - init() called")
        itemView.setOnClickListener(this)
        this.myRecyclerInterface = recyclerInterface
    }

    // 데이터와 뷰 묶기
    fun bind(myModel: FailMyModel){
        Log.d(TAG, "MyViewHolder - bind() called")
        // 텍스트뷰와 실제 텍스트 데이터를 묶기
        usernameTextView.text = myModel.name

        // 이미지뷰와 실제 이미지 데이터 묶기
        Glide
            .with(FailApp.instance)
            .load(myModel.profileImage)
            //.centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(profileImageView)
    }

    override fun onClick(p0: View?) {
        Log.d(TAG, "MyViewHolder - onClick() called")
        this.myRecyclerInterface?.onItemClicked(adapterPosition)
    }
}
*/