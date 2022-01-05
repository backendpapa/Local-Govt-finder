package com.backendpapa.localgovtadvicerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        set button to listen to events
        val findLocalGovtButton=findViewById<Button>(R.id.find_local_govt)
        findLocalGovtButton.setOnClickListener{
            val localGovtOptions=findViewById<Spinner>(R.id.state_list)
            val selectedLocalGovt=localGovtOptions.selectedItem.toString()
            val localGovt=getLocaGovt(selectedLocalGovt)
            val localGovtResult=findViewById<TextView>(R.id.local_govt)
            localGovtResult.text=localGovt.reduce{str,item->str+'\n'+item}

        }
    }


    fun getLocaGovt(selectedLocalGovt:String):List<String>{
        return when (selectedLocalGovt){
            "FCT"-> listOf("Lugbe","Wuse","Garki","Jabi")
            else -> listOf("Akure","Owo","Ilesha","Akoko")
        }
    }
}