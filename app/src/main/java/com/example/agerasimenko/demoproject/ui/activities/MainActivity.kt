package com.example.agerasimenko.demoproject.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.agerasimenko.demoproject.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)
        FirebaseFirestore.setLoggingEnabled(true)
        db = FirebaseFirestore.getInstance()
        db.firestoreSettings = FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build()


        get_data_fb.setOnClickListener { read() }
    }

    private fun read() {
        Log.d("FireStore", "click")

        db.collection("service").get().addOnCompleteListener {
            it.run {
                if (isSuccessful) {
                    result.run {
                        if (isEmpty) Log.d("FireStore", "empty collection")

                        forEach { document ->
                            Log.d("FireStore", document.data.toString())
                        }
                    }
                } else Log.e("FireStore", exception.toString())
            }
        }
    }
}
