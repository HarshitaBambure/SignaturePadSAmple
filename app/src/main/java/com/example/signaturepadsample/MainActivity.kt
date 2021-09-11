package com.example.signaturepadsample

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.signaturepadsample.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
          var file=  savebitmap(binding.signaturePad.signatureBitmap)
          Toast.makeText(this, "Signature Saved"+file?.absolutePath, Toast.LENGTH_LONG).show()

        }


    }

    fun savebitmap(bmp: Bitmap): File? {
        val bytes = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes)
        val f = File(
            (filesDir.absolutePath
                    + File.separator).toString() + "signature.jpg"
        )
        f.createNewFile()
        val fo: FileOutputStream = FileOutputStream(f)
        fo.write(bytes.toByteArray())
        fo.close()
        return f
    }
/*
    @Multipart
    @POST("Api.php?apicall=upload")
    fun uploadImage(
        @Part("image\"; filename=\"myfile.jpg\" ") file: RequestBody?,
    ): Call<MyResponse?>*/

}