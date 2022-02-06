package com.angelblanco.database_angelblanco

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.angelblanco.database_angelblanco.databinding.ItemUserBinding
import com.angelblanco.database_angelblanco.db.User

class UserAdapter(
    private val onItemClick: (User) -> Unit,
    private val deleteItemClick: (User) -> Unit
) : ListAdapter<User, UserAdapter.ViewHolder>(UserDiffUtils()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)

        holder.binding.tvName.text = user.name
        holder.binding.tvSubname.text = user.subname
        holder.binding.tvNumber.text = user.numberPhone
        holder.binding.btnDelete.setOnClickListener{
            deleteItemClick(user)
        }
    }


    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

}


class UserDiffUtils: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
}