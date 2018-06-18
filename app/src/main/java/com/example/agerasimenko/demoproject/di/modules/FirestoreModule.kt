package com.example.agerasimenko.demoproject.di.modules

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class FirestoreModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideFirestore(): FirebaseFirestore {
        FirebaseApp.initializeApp(context)
        FirebaseFirestore.setLoggingEnabled(true)
        val firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build()

        return firestore
    }
}