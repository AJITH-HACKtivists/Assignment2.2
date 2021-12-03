package com.example.secondapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var names= mutableMapOf<String,Int>()
        var texts=""
        var valuefromtextbox=findViewById<TextInputLayout>(R.id.names)
        var button=findViewById<TextView>(R.id.button)
        var text=findViewById<TextView>(R.id.text)
        button.setOnClickListener{
          var getname=valuefromtextbox.editText?.text.toString();
            text.setText(getname)
          var setname=if(getname.isNullOrEmpty()) "Sombody"
                      else getname
          if(setname.toLowerCase() in names){
             var count=names[setname.toLowerCase()]?:0
              names[setname.toLowerCase()]=(count+1)
          }
          else
              names.put(setname.toLowerCase(),1)
          texts=""
          for(k in names.keys)
              texts=texts+"$k clicked ${names[k]} times \n"
          text.setText(texts)
        }
    }
}