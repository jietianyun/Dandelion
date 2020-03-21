package com.jty.dandelion.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jty.dandelion.R
import com.jty.dandelion.customview.CircleImageView
import com.jty.dandelion.register.bean.User


class PeoplesAdapter(userList:MutableList<User>?): RecyclerView.Adapter<PeoplesAdapter.PeoplesViewHolder>(){
    val contactList:MutableList<Contact> = mutableListOf()
    val tags by lazy {
        LinkedHashMap<String, Int>().apply {
            put(contactList[0].nameType,0)
        }
    }
    init {
        initData(userList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeoplesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_peoples_rl,parent,false)
        return PeoplesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return contactList.size
    }

    override fun onBindViewHolder(holder: PeoplesViewHolder, position: Int) {
         holder.peoples_name_tv.text = contactList[position].user.name
        if (position<contactList.size-1&&contactList[position].nameType!=contactList[position+1].nameType){
            holder.peoples_rl_item_line.visibility = View.GONE
        }else{
            holder.peoples_rl_item_line.visibility = View.VISIBLE
        }
        Log.d("PeoplesAdapter","$tags")
    }

    fun addData(userList:MutableList<User>?){
        initData(userList)
        tags.clear()
        tags[contactList[0].nameType] = 0
        this.notifyDataSetChanged()
    }

    private fun initData(userList:MutableList<User>?){
        userList?.forEach {
            contactList.add(Contact(it.getNamePinyin(), it))
        }
        contactList.sortBy {
            it.nameType
        }
        for(position in 1 until contactList.size){
            if (contactList[position].nameType!=contactList[position-1].nameType){
               tags[contactList[position].nameType] = position
            }
        }
    }

    class PeoplesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
          val peoples_rl_civ = itemView.findViewById<CircleImageView>(R.id.peoples_rl_civ)
          val peoples_name_tv  = itemView.findViewById<TextView>(R.id.peoples_name_tv)
          val peoples_rl_item_line = itemView.findViewById<View>(R.id.peoples_rl_item_line)
    }
}