package com.example.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(){

    private val chefs: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            chefs.addAll(args.get("args_menu") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setChefs()
    }

    private fun setChefs(){
        menu_text.text = stringBuilderForChefs(chefs)
    }

    companion object{
        fun stringBuilderForChefs(chefs: ArrayList<String>): String{
            val sb = StringBuilder()
            for(director in chefs){
                sb.append(director + "\n")
            }
            return sb.toString()
        }
    }
}

















