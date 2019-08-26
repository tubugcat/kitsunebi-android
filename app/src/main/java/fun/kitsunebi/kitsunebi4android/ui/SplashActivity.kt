package `fun`.kitsunebi.kitsunebi4android.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import `fun`.kitsunebi.kitsunebi4android.R
import android.content.Intent

import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.content_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        buttonToMain.setOnClickListener{view->
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }


    }

}
