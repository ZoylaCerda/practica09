---

## 📸 Camera App - Jetpack Compose

Esta es una aplicación de Android sencilla que utiliza **Jetpack Compose** y **Kotlin** para capturar, guardar y compartir imágenes desde la cámara del dispositivo. La app maneja permisos de cámara y almacenamiento y permite al usuario visualizar la imagen tomada en la interfaz, así como compartirla o guardarla en la galería.

---

### 🎯 **Características**

- Solicita permisos de **cámara** y **almacenamiento** (o acceso a imágenes según la versión de Android).
- Toma una fotografía y la muestra en la interfaz.
- Permite **guardar la imagen en la galería** del dispositivo.
- Permite **compartir la imagen** con otras aplicaciones.
- Posibilidad de **volver a capturar la foto** si el usuario no está satisfecho.

---

### 📋 **Requisitos**

- **Android Studio** Arctic Fox o superior.
- **SDK Mínimo**: 26
- **SDK Objetivo**: 34
- **Kotlin**: 1.9+
- **Gradle KTS**: Compatible

---

### 🚀 **Instalación y configuración**

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/tu_usuario/camera-app-compose.git
   cd camera-app-compose
   ```

2. **Abrir el proyecto en Android Studio**.

3. **Sincronizar las dependencias** con Gradle.

4. **Ejecutar en un emulador o dispositivo físico**:
   - Asegúrate de conceder manualmente los permisos si es necesario.

---

### 📂 **Estructura del proyecto**

```bash
.
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example/practica09
│   │   │   │   ├── MainActivity.kt       # Punto de entrada de la app
│   │   │   │   ├── ui/view               # Contiene las pantallas de la UI
│   │   │   │   │   └── CameraScreen.kt   # Pantalla principal con Jetpack Compose
│   │   │   │   ├── ui/viewmodel          # Lógica de la app
│   │   │   │   │   └── CameraViewModel.kt # ViewModel para gestionar el estado
│   │   │   └── AndroidManifest.xml       # Configuración del manifest y permisos
├── build.gradle.kts                      # Configuración de Gradle Kotlin Script
├── README.md                             # Este archivo
```

---

### 🔧 **Dependencias importantes**

- **Jetpack Compose**: Para la interfaz declarativa.
- **Coil**: Para la carga eficiente de imágenes en Compose.
- **CameraX**: Para acceder a la cámara del dispositivo.
- **Kotlin Coroutines y State Management**: Para manejar el estado de la UI.

---

### 📱 **Permisos utilizados**

En el archivo `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
```

- **Cámara**: Para capturar imágenes.
- **Almacenamiento o acceso a medios**: Para guardar la imagen en la galería.

---

### 💻 **Cómo funciona**

1. **Inicio**: Muestra un botón para **capturar foto**.
2. **Tomar foto**: La imagen se captura y se muestra en la pantalla.
3. **Opciones adicionales**:
   - **Guardar en galería**: Guarda la imagen en la galería del dispositivo.
   - **Compartir imagen**: Abre un intent para compartir la imagen con otras apps.
   - **Volver a tomar foto**: Permite capturar una nueva imagen.

---

### 🛠️ **Posibles problemas y soluciones**

1. **La imagen no se muestra después de capturarla**:
   - Asegúrate de que los permisos están concedidos correctamente.
   - Verifica que el `Uri` no sea nulo en el log de `Logcat`.

2. **Permisos no concedidos**:
   - Asegúrate de revisar manualmente los permisos en la configuración del dispositivo.

3. **Problemas con el emulador**:
   - Usa un **dispositivo físico** si el emulador no soporta la cámara adecuadamente.

---
