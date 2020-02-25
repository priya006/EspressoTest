package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_chef.*

class ChefFragment : Fragment(){

    private val chefs: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            chefs.addAll(args.get("args_chef") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chef, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        set_chefs()
    }

    private fun set_chefs(){
        chef_text.text = stringBuilderForMenus(chefs)
    }

    companion object{
        fun stringBuilderForMenus (menus: ArrayList<String>): String{
            val sb = StringBuilder()
            for(menu in menus){
                sb.append(menu + "\n")
            }
            return sb.toString()
        }
    }
}














