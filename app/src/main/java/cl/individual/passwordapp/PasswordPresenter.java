package cl.individual.passwordapp;

import android.graphics.Color;

public class PasswordPresenter {
    private PasswordModel model;
    private IViewPresenter view;

    public PasswordPresenter(IViewPresenter view) {
        this.view = view;
        model = new PasswordModel();
    }

    public void medirSeguridadClave(String password) {
        int nivelSeguridad = model.validarClave(password);

        switch (nivelSeguridad) {
            case PasswordModel.DEBIL:
                this.view.mostrarDebil();

                break;
            case PasswordModel.MEDIO:
                this.view.mostrarMedio();

                break;
            case PasswordModel.FUERTE:
                this.view.mostrarFuerte();

                break;
            case PasswordModel.ERROR:
                this.view.mostrarError();

                break;
        }
    }
public void evaluarResultadoAColor(String password) {
    int nivelSeguridad = model.validarClave(password);
    String avisoDebil = "CONTRASEÑA DEBIL";
    String avisoMedio = "CONTRASEÑA NIVEL MEDIO";
    String avisoFuerte = "CONTRASEÑA FUERTE";
    String avisoError = "ERROR";
    int colorDebil = Color.LTGRAY;
    int colorMedio = Color.YELLOW;
    int colorFuerte = Color.GREEN;
    int colorError = Color.RED;

    switch (nivelSeguridad) {
        case PasswordModel.DEBIL:
            this.view.mostrarResultadoAColor(avisoDebil, colorDebil);
            break;
        case PasswordModel.MEDIO:
            this.view.mostrarResultadoAColor(avisoMedio, colorMedio);
            break;
        case PasswordModel.FUERTE:
            this.view.mostrarResultadoAColor(avisoFuerte, colorFuerte);
            break;
        case PasswordModel.ERROR:
            this.view.mostrarResultadoAColor(avisoError, colorError);
            break;
    }
}

}

