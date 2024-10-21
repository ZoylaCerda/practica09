package com.example.practica09.ui.view

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.practica09.ui.viewmodel.CameraViewModel

@Composable
fun CameraScreen(
    viewModel: CameraViewModel,
    onCaptureImage: () -> Unit,
    onSaveImage: (Uri) -> Unit,
    onShareImage: (Uri) -> Unit
) {
    val imageUri by viewModel.imageUri
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            if (viewModel.checkPermissions(context)) {
                onCaptureImage()
            } else {
                viewModel.requestPermissions(context as ComponentActivity)
            }
        }) {
            Text(text = "Tomar Foto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        imageUri?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = "Imagen Capturada",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onSaveImage(uri) }) {
                Text(text = "Guardar en Galería")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { onShareImage(uri) }) {
                Text(text = "Compartir Imagen")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { viewModel.setImageUri(null) }) {
                Text(text = "Volver a Tomar Foto")
            }
        }
    }
}
