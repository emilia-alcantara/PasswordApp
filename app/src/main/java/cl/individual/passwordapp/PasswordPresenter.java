package cl.individual.passwordapp;

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
}
