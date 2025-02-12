package mx.edu.itson.examenc1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etCantidad:EditText = findViewById(R.id.etCantidad)
        val etProducto:EditText = findViewById(R.id.etProducto)
        val etPrecio:EditText = findViewById(R.id.etPrecio)

        val btnAgregar:Button = findViewById(R.id.btnAgregar)

        val tvCantidad1:TextView = findViewById(R.id.tvCantidad1)
        val tvProducto1:TextView = findViewById(R.id.tvProducto1)
        val tvPrecio1:TextView = findViewById(R.id.tvPrecio1)
        val tvCantidad2:TextView = findViewById(R.id.tvCantidad2)
        val tvProducto2:TextView = findViewById(R.id.tvProducto2)
        val tvPrecio2:TextView = findViewById(R.id.tvPrecio2)
        val tvCantidad3:TextView = findViewById(R.id.tvCantidad3)
        val tvProducto3:TextView = findViewById(R.id.tvProducto3)
        val tvPrecio3:TextView = findViewById(R.id.tvPrecio3)

        val tvSubtotal:TextView = findViewById(R.id.tvSubtotal)
        val tvIVA:TextView = findViewById(R.id.tvIVA)
        val tvTotal:TextView = findViewById(R.id.tvTotal)

        var productosIngresados = 0
        val limiteProductos = 3

        var subTotal1:Float = 0F
        var subTotal2:Float = 0F
        var subTotal3:Float = 0F

        btnAgregar.setOnClickListener {
            productosIngresados++
            when(productosIngresados) {
                1 -> {
                    tvCantidad1.setText(etCantidad.text.toString())
                    tvProducto1.setText(etProducto.text.toString())
                    subTotal1 =  etPrecio.text.toString().toFloat() * etCantidad.text.toString().toFloat()
                    tvPrecio1.setText(String.format("%.2f", subTotal1))
                }

                2 -> {
                    tvCantidad2.setText(etCantidad.text.toString())
                    tvProducto2.setText(etProducto.text.toString())
                    subTotal2 =  etPrecio.text.toString().toFloat() * etCantidad.text.toString().toFloat()
                    tvPrecio2.setText(String.format("%.2f", subTotal2))
                }

                3 -> {
                    tvCantidad3.setText(etCantidad.text.toString())
                    tvProducto3.setText(etProducto.text.toString())
                    subTotal3 =  etPrecio.text.toString().toFloat() * etCantidad.text.toString().toFloat()
                    tvPrecio3.setText(String.format("%.2f", subTotal3))
                }
            }

            etCantidad.setText(null)
            etProducto.setText(null)
            etPrecio.setText(null)

            if (productosIngresados == 3) {
                var subTotal:Float = subTotal1 + subTotal2 + subTotal3
                tvSubtotal.setText(String.format("%.2f", subTotal))
                var iva:Float = subTotal * 0.16F
                tvIVA.setText(String.format("%.2f", iva))
                var total:Float = subTotal + iva
                tvTotal.setText(String.format("%.2f", total))
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}