package com.example.practica09.ui.viewmodel

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel

class CameraViewModel : ViewModel() {
    var imageUri = mutableStateOf<Uri?>(null)
        private set

    fun setImageUri(uri: Uri?) {
        imageUri.value = uri
    }

    fun checkPermissions(context: Context): Boolean {
        val cameraPermission = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
        val storagePermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return cameraPermission == PackageManager.PERMISSION_GRANTED &&
                storagePermission == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermissions(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
            REQUEST_CODE_PERMISSIONS
        )
    }

    fun showPermissionDeniedMessage(context: Context) {
        Toast.makeText(context, "Permisos denegados", Toast.LENGTH_SHORT).show()
    }


    companion object {
        const val REQUEST_CODE_PERMISSIONS = 100
    }
}
