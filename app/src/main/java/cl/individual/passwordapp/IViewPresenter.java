package cl.individual.passwordapp;

public interface IViewPresenter {

    void mostrarDebil();
    void mostrarMedio();
    void mostrarFuerte();
    void mostrarError();

    void mostrarResultadoAColor(String aviso, int color);


}
