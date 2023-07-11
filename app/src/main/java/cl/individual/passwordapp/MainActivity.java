package cl.individual.passwordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import cl.individual.passwordapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IViewPresenter {
    private ActivityMainBinding binding;
    private PasswordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        presenter = new PasswordPresenter(this);
        initListeners();
        initTextWatcher();
        setContentView(binding.getRoot());
    }

    private void initTextWatcher() {
        binding.editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.medirSeguridadClave(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initListeners() {
        binding.btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.editPassword.getText().toString();
                presenter.medirSeguridadClave(password);
                // binding.txtNivelSeguridad.setText();
            }
        });
    }


    @Override
    public void mostrarDebil() {
        binding.txtEvaluadorSimultaneo.setText(R.string.weak_password);
    }

    @Override
    public void mostrarMedio() {
        binding.txtEvaluadorSimultaneo.setText(R.string.medium_password);
    }

    @Override
    public void mostrarFuerte() {
        binding.txtEvaluadorSimultaneo.setText(R.string.strong_password);
    }


      @Override
       public void mostrarError() {
       binding.txtEvaluadorSimultaneo.setText(R.string.error_password);
       }
}