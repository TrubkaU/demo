package com.example.agerasimenko.demoproject.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.os.CountDownTimer
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var db: FirebaseFirestore

    val time = TimeUnit.HOURS.toMillis(4)

    private val timer = object : CountDownTimer(time, 1000) {

        var count = 0

        override fun onTick(millisUntilFinished: Long) {
            count++
            readCollection("service", count)
            writeCollection("review", count)
        }

        override fun onFinish() {
            Log.d("FireStore", "fin")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application  as MainApp).getApplicationComponent().inject(this)
        setContentView(R.layout.activity_main)

        get_data_fb.setOnClickListener {
            get_data_fb.isEnabled = false
            timer.start()
        }
        stop.setOnClickListener {
            timer.cancel()
            Log.d("FireStore", "cancel")
        }
    }

    private fun readCollection(collectionName: String, count: Int) {
        db.collection(collectionName).get().addOnCompleteListener {
            it.run {
                Log.d("FireStore", "attempt $count")
                if (isSuccessful) {
                    result.run {
                        Log.d("FireStore", "print $collectionName")
                        if (isEmpty) Log.d("FireStore", "empty collection")

                        forEach { document ->
                            Log.d("FireStore", document.data.toString())
                        }
                    }
                } else Log.e("FireStore", exception.toString())
            }
        }
    }

    private fun writeCollection(collectionName: String, count: Int)  {
        val data = HashMap<String, Any>()
        data["reviewer"] = count

        db.collection(collectionName).document("W_$count")
                .set(data)
                .addOnSuccessListener {
                    Log.d("FireStore", "successful $count")
                }
    }
}
