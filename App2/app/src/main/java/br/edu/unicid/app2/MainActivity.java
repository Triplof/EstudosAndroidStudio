package br.edu.unicid.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private EditText edtNome, edtMostrar;
    private CheckBox chkMatutino, chkNoturno;
    private Button btnMostra, btnDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // atrelando IDs do XML com o Java
        // o arquivo R é usado para atrelar dados do XML com classes e métodos do Java
        edtNome = findViewById(R.id.edtNome);
        edtMostrar = findViewById(R.id.edtMostrar);
        chkNoturno = findViewById(R.id.chkNoturno);
        chkMatutino = findViewById(R.id.chkMatutino);
        btnMostra = findViewById(R.id.btnMostrar);
        btnDeletar = findViewById(R.id.btnDeletar);
    }

    // funcionalidade para o botao de mostrar talvez
    public void mostrar(View view){
        String mensagem = null;
        mensagem = "\n"+edtNome.getText().toString();

        edtMostrar.setText("");

        if(chkMatutino.isChecked())
            mensagem+="\n>> Matutino";

        if(chkNoturno.isChecked())
            mensagem+="\n>> Noturno";

        edtMostrar.append(mensagem);
    }
    public void deletar(View view){
        edtMostrar.setText("");
    }
}

