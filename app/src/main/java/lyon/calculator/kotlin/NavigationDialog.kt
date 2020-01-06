package lyon.calculator.kotlin

import android.app.Dialog
import android.content.Context
import android.view.*
import android.widget.TextView
import lyon.calculator.kotlin.R.menu.drawer_view

/**
 * https://ithelp.ithome.com.tw/articles/10203735
 */
class NavigationDialog{
    val TAG:String = "NavigationDialog"//NavigationDialog::class.simpleName.toString()//
    lateinit var dialog:Dialog
    lateinit var inflater: View
    lateinit var text1:TextView
    lateinit var text2:TextView

    fun showRightDialog(context: Context){
        //自定义dialog显示布局
         inflater = LayoutInflater.from(context).inflate(R.layout.menu_view, null)
        //自定义dialog显示风格
         dialog= Dialog(context,R.style.DialogRight)
        //弹窗点击周围空白处弹出层自动消失弹窗消失(false时为点击周围空白处弹出层不自动消失)
        dialog.setCanceledOnTouchOutside(true)
        //将布局设置给Dialog
        dialog.setContentView(inflater)
        //获取当前Activity所在的窗体
        var window: Window = dialog.window!!
        var wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.RIGHT
        wlp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
        dialog.show()

        text1 = inflater.findViewById(R.id.textView1)
        text1.setOnClickListener {
            text1.setText("you click this text 1    1231212412312412341241234123")
            close()
        }

        text2 = inflater.findViewById(R.id.textView2)
        text2.setOnClickListener {
            text2.setText("you click this text 1    1231212412312412341241234123 1231212412312412341241234123 1231212412312412341241234123")
            close()
        }

    }

    fun showLeftDialog(context: Context){
        //自定义dialog显示布局
        inflater = LayoutInflater.from(context).inflate(R.layout.menu_view, null)
        //自定义dialog显示风格
        dialog= Dialog(context,R.style.DialogLeft)
        //弹窗点击周围空白处弹出层自动消失弹窗消失(false时为点击周围空白处弹出层不自动消失)
        dialog.setCanceledOnTouchOutside(true)
        //将布局设置给Dialog
        dialog.setContentView(inflater)
        //获取当前Activity所在的窗体
        var window: Window = dialog.window!!
        var wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.LEFT
        wlp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
        dialog.show()

        text1 = inflater.findViewById(R.id.textView1)
        text1.setOnClickListener {
            text1.setText("you click this text 1    1231212412312412341241234123")
            close()
        }

        text2 = inflater.findViewById(R.id.textView2)
        text2.setOnClickListener {
            text2.setText("you click this text 1    1231212412312412341241234123 1231212412312412341241234123 1231212412312412341241234123")
            close()
        }

    }

    fun close(){
        if(dialog!=null) {
            dialog.dismiss()
        }
    }

}