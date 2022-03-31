package jp.techacademy.yutaro.kadai_lesson4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            { view, hour, minute ->
                var aisatsu:String
                aisatsu=if(120<=tomin(hour,minute)&&tomin(hour,minute)<=599){
                    "おはよう"
                }else if(600<=tomin(hour,minute)&&tomin(hour,minute)<=1079) {
                    "こんにちは"
                }else{
                    "こんばんは"
                }
                textView.text=aisatsu
            },
            12, 0, true)
        timePickerDialog.show()
    }

    private fun tomin(hour:Int,minute:Int):Int{
        return hour*60+minute
    }
}