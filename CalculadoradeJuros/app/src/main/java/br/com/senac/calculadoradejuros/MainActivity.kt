package br.com.senac.calculadoradejuros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Envia dados para a próxima activity
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val etValor = findViewById<TextView>(R.id.etValor)
        val etQnt = findViewById<TextView>(R.id.etQnt)
        val etJuros = findViewById<TextView>(R.id.etJuros)
        val rdbOptSimples = findViewById<RadioButton>(R.id.rdbOptSimples)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnEnviar.setOnClickListener {
            if(etValor.text.isNotEmpty() && etQnt.text.isNotEmpty() && etJuros.text.isNotEmpty()){
                val intent = Intent(this, RespActivity::class.java).apply {
                    putExtra(
                        "mode",
                        if (rdbOptSimples.isChecked) "simples"
                        else "composto"
                    )
                    putExtra("valor", etValor.text.toString())
                    putExtra("qnt", etQnt.text.toString())
                    putExtra("juros", etJuros.text.toString())
                }
                startActivity(intent)
            }
            else{
                Toast.makeText(this, R.string.err_vazio, Toast.LENGTH_LONG).show()
            }
        }

        // Limpa dados do EditText
        btnLimpar.setOnClickListener {
            etValor.setText("")
            etQnt.setText("")
            etJuros.setText("")
            rdbOptSimples.isChecked = true
        }
    }
}