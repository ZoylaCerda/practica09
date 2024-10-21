package com.example.practica09

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.practica09.ui.view.CameraScreen
import com.example.practica09.ui.viewmodel.CameraViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CameraViewModel by viewModels()

    private val takePictureLauncher = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        bitmap?.let {
            val uri = Uri.parse(
                MediaStore.Images.Media.insertImage(
                    contentResolver, it, "Nueva Foto", "Foto desde la cámara"
                )
            )
            viewModel.setImageUri(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CameraScreen(
                viewModel = viewModel,
                onCaptureImage = { takePictureLauncher.launch(null) },
                onSaveImage = { uri -> saveImageToGallery(uri) },
                onShareImage = { uri -> shareImage(uri) }
            )
        }
    }

    private fun saveImageToGallery(uri: Uri) {
        // Aquí podrías implementar la lógica para guardar la imagen
    }

    private fun shareImage(uri: Uri) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/*"
            putExtra(Intent.EXTRA_STREAM, uri)
        }
        startActivity(Intent.createChooser(intent, "Compartir Imagen"))
    }
}
