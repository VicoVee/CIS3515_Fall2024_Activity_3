package edu.temple.inclassuiacvitivity

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(_context : Context, _numberArray :  Array<Int>) : BaseAdapter() {

    val context = _context
    val numberArray = _numberArray

    override fun getCount(): Int {
        return numberArray.size
    }

    override fun getItem(position: Int): Any {
        return numberArray[position]
    }

    override fun getItemId(position: Int): Long {
        return numberArray[position].toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView : TextView
        //To ensure that resources are used efficiently, we can recycle the view
        //rather than creating a new TextView view.
        if(convertView != null){
            //If textView is already initialized, then recycle the view (p1)
            textView = convertView as TextView
        } else {
            //Create a new TextView
            //Get the corresponding spinner box
            textView = TextView(context)
            //For each new TextView, set the font size and the padding
            textView.textSize = 22f
            textView.setPadding(5, 10 ,0,10) //Padding the box
        }
        textView.text = numberArray[position].toString() //Return the color text to that box

        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return super.getDropDownView(position, convertView, parent).apply{
            if (convertView is TextView){
                convertView.textSize = numberArray[position].toFloat()
            }
        }

    }

}