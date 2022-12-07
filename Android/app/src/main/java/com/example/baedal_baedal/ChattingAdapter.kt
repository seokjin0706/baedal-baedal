package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class ChattingAdapter (val context : Context, val List : ArrayList<ListViewModel2>) : BaseAdapter(){

    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //chatListView chattingEdit chattingBtn
        val view: View = LayoutInflater.from(context).inflate(R.layout.chat_item, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val chatSender = view.findViewById<TextView>(R.id.userTxt)
        val chatMessage = view.findViewById<TextView>(R.id.userTxt2)

        /* ArrayList<Dog>의 변수 dog의 이미지와 데이터를 ImageView와 TextView에 담는다. */
        val listViewModel2 = List[position]
        // 사용자 이미지 담는 부분

        chatSender.text = listViewModel2.sender
        chatMessage.text = listViewModel2.message
        return view
    }
}