# menuNavigationDialog
1.
首先製作NavigationDialog.kt 客製化 Dialog
這裡使用左邊顯示Menu Bar 做講解
fun showLeftDialog(context: Context){
        //自定义dialog显示布局
        var inflater = LayoutInflater.from(context).inflate(R.layout.menu_view, null)
        //自定义dialog显示风格
        var dialog= Dialog(context,R.style.DialogLeft)
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
    }
2.
然後製作 layout/menu_view.xml  這裡跟一般的xml沒有太大差別
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="200dp"
              android:layout_height="match_parent"
              android:padding="10dp"
              android:background="#8888ffff"
>
    <TextView
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:id="@+id/title"
            android:textSize="30dp"
            android:text="Menu"
    />
    <TextView
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:id="@+id/textView1"
            android:textSize="20dp"
            android:text="title1"
    />
    <TextView
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:id="@+id/textView2"
            android:textSize="20dp"
            android:text="title2"
    />
    <TextView
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:id="@+id/textView3"
            android:textSize="20dp"
            android:text="title3"
    />
</LinearLayout>
3.
製作style/DialogLeft.xml
<!--位于左侧dialog的风格-->
    <style name="DialogLeft" parent="@android:style/Theme.Dialog">
        <!-- 背景透明 -->
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:windowContentOverlay">@null</item>
        <!-- 浮于Activity之上 -->
        <item name="android:windowIsFloating">true</item>
        <!-- 边框 -->
        <item name="android:windowFrame">@null</item>
        <!-- Dialog以外的区域模糊效果 -->
        <item name="android:backgroundDimEnabled">true</item>
        <!-- 无标题 -->
        <item name="android:windowNoTitle">true</item>
        <!-- 半透明 -->
        <item name="android:windowIsTranslucent">true</item>
        <!--点击dialog以外区域关闭弹窗-->
        <item name="android:windowCloseOnTouchOutside">true</item>

        <!-- Dialog进入及退出动画 -->
        <item name="android:windowAnimationStyle">@style/ActionSheetDialogLeft</item>
    </style>

    <!-- ActionSheet进出动画 -->
    <style name="ActionSheetDialogLeft" parent="@android:style/Animation.Dialog">
        <item name="android:windowEnterAnimation">@anim/dialog_left_in</item>
        <item name="android:windowExitAnimation">@anim/dialog_left_out</item>
    </style>
4.    
製作 anim/dialog_left_in ,anim/dialog_left_out 分別為 滑動進來 跟 出去的動作
    
    dialog_left_in.xml
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
    <scale
            android:interpolator="@android:anim/accelerate_interpolator"
            //顯示動畫的X位置
            android:fromXScale="0.0"
            android:toXScale="1.0"
            //顯示動畫的Y位置
            android:fromYScale="1.0"
            android:toYScale="1.0"
            //由左到右的滑動，如果要由右到左 pivotX設定為100%
            android:pivotX="0%"
            android:pivotY="0%"
            android:fillAfter="false"
            //滑動出來的動畫時間
            android:duration="500"/>  
    </set>
    
    dialog_left_out.xml
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
    <scale
            android:interpolator="@android:anim/accelerate_interpolator"
            //顯示動畫的X位置
            android:fromXScale="1.0"
            android:toXScale="0.0"
            //顯示動畫的Y位置
            android:fromYScale="1.0"
            android:toYScale="1.0"
            //由左到右的滑動，如果要由右到左 pivotX設定為100% pivotY則是上到下或是下到上的動畫
            android:pivotX="0%"
            android:pivotY="0%"
            android:fillAfter="true"
            //滑動收起的動畫時間
            android:duration="500"/>
    </set>
5.  
    然後在MainActivity.kt 製作button來呼叫顯示
    var navigationDialog = NavigationDialog()
    var menubarRight = findViewById(R.id.menubarRight);
    menubarRight.setOnClickListener {
        navigationDialog.showRightDialog(this)
    }
    


