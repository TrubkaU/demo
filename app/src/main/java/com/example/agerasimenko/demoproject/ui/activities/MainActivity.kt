package com.example.agerasimenko.demoproject.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application  as MainApp).getApplicationComponent().inject(this)
        setContentView(R.layout.activity_main)


        get_data_fb.setOnClickListener {
            readCollection("service")
            readCollection("review")
        }
    }

    private fun readCollection(collectionName: String) {
        db.collection(collectionName).get().addOnCompleteListener {
            it.run {
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
}
