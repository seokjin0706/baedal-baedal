package com.example.baedal_baedal

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter (val context : Context, val List : ArrayList<ListViewModel>) : BaseAdapter(){

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
        /*var convertView = convertView

        if(convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)
        }

        val listviewText = convertView?.findViewById<TextView>(R.id.listViewTextArea)
        listviewText!!.text = List[position].address

        return convertView!!*/

        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val name = view.findViewById<TextView>(R.id.nameTxt)
        val title = view.findViewById<TextView>(R.id.titleTxt)
        val address = view.findViewById<TextView>(R.id.addressTxt)
        val content = view.findViewById<TextView>(R.id.contentTxt)

        /* ArrayList<Dog>의 변수 dog의 이미지와 데이터를 ImageView와 TextView에 담는다. */
        val listViewModel = List[position]
        // 사용자 이미지 담는 부분
        val resourceId = context.resources.getIdentifier(listViewModel.img, "drawable", context.packageName)
        name.text = listViewModel.name
        title.text = listViewModel.title
        address.text = listViewModel.address
        content.text = listViewModel.content

        return view
    }
}










