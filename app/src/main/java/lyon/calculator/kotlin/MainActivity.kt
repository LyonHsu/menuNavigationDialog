package lyon.calculator.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {


    lateinit var drawer: DrawerLayout
    lateinit var navigationDialog: NavigationDialog
    lateinit var menubarRight:ImageView
    lateinit var menubarLeft:ImageView
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationDialog = NavigationDialog()
        menubarRight = findViewById(R.id.menubarRight);
        menubarRight.setOnClickListener {
            navigationDialog.showRightDialog(this)
        }

        menubarLeft = findViewById(R.id.menubarLeft);
        menubarLeft.setOnClickListener {
            navigationDialog.showLeftDialog(this)
        }
    }
}
